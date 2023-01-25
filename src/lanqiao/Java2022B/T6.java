package lanqiao.Java2022B;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName T6
 * @Description 最大子矩阵
 * @Author yiling
 * @date 2023/1/9 17:34
 */
public class T6 {

    //n最大为80，m最大为100000
    static int n, m, limit;
    static int[][] a;//原始数组
    static int[][][] max;
    static int[][][] min;

    //单调队列（滑动窗口）求一块面积中的最大值和最小值
    //将二维面积通过max和min数组转变成了每列上的行区间的最大值最小值都求得了
    // 现在相当于只要求一维[1,m]上满足长度为width中的区间上的最大值和最小值
    public static boolean check(int x1, int x2, int width) {
        Deque<Integer> wmax = new ArrayDeque<>();
        Deque<Integer> wmin = new ArrayDeque<>();
        for (int i = 1; i <= m; ++i) { //i是右指针，peekFirst是左指针
            //窗口长度大于固定窗口width，就把最前面的去掉
            if (!wmax.isEmpty() && i - wmax.peekFirst() + 1 > width) wmax.pollFirst();
            //比即将入队的元素小的值就可以被即将入队的那个值替代了，所以可以直接把他扔掉
            while (!wmax.isEmpty() && max[wmax.peekLast()][x1][x2] < max[i][x1][x2]) wmax.pollLast();
            wmax.offerLast(i);

            if (!wmin.isEmpty() && i - wmin.peekFirst() + 1 > width) wmin.pollFirst();
            while (!wmin.isEmpty() && min[wmin.peekLast()][x1][x2] > min[i][x1][x2]) wmin.pollLast();
            wmin.offerLast(i);

            if (i >= width && max[wmax.peekFirst()][x1][x2] - min[wmin.peekFirst()][x1][x2] <= limit) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]); //n行
        m = Integer.parseInt(s[1]); //m列
        a = new int[n + 1][m + 1];
        max = new int[m + 1][n + 1][n + 1];
        min = new int[m + 1][n + 1][n + 1];
        int i,j;
        for (i = 1; i <= n; ++i) {
            s = br.readLine().split(" ");
            for (j = 1; j <= m; ++j) {
                a[i][j] = Integer.parseInt(s[j - 1]);
                max[j][i][i] = a[i][j];
                min[j][i][i] = a[i][j];
            }
        }
        limit=Integer.parseInt(br.readLine());

        //max/min[j][i][k]表示第j列第i到k行中的最大值/最小值
        for (j = 1; j <= m; ++j) {
            for (i = 1; i < n; ++i) {
                for (int k = i + 1; k <= n; ++k) {
                    max[j][i][k] = Math.max(max[j][i][k - 1], a[k][j]);
                    min[j][i][k] = Math.min(min[j][i][k - 1], a[k][j]);
                }
            }
        }

        int area = 0;

        //双指针遍历行（i表示开始端点，j表示结束端点，j>=i,行区间表示高度）
        for (i = 1; i <= n; ++i) {
            for (j = i; j <= n; ++j) {
                //在固定行区间内二分查找最大宽度
                int l = 1, r = m;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (check(i, j, mid)) l = mid; //符合条件，就去找更大的宽度，将区间右移
                    else r = mid - 1;
                }
                if (check(i, j, r)) {
                    area = Math.max(area, (j - i + 1) * r);
                }
            }
        }

        System.out.println(area);
    }
}
