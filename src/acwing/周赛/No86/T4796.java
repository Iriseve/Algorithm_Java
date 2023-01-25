package acwing.周赛.No86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T4796
 * @Description 删除序列
 * @Author yiling
 * @date 2023/1/14 19:44
 */
public class T4796 {
    //dp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] len = new long[(int) 1e5 + 10]; //记录每个对应下标元素的当前得分
        long[] f = new long[(int) 1e5 + 10];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            int ai = Integer.parseInt(s[i]);
            len[ai] += ai; //这一步+=可以将重复元素合并
        }

        f[1] = len[1];
        for (int i = 2; i <= 1e5; ++i) {
            f[i] = Math.max(f[i - 1], f[i - 2] + len[i]); // 即当前状态f[i]从 不选len[i] 和 选len[i] 中取最大值
        }
        System.out.println(f[(int) 1e5]);
    }


    //非正解，这里只考虑了相邻的不能选，没有考虑全选重复值的情况
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] a = new int[n + 2];
//        String[] s = br.readLine().split(" ");
//        for (int i = 1; i <= n; ++i) {
//            a[i] = Integer.parseInt(s[i - 1]);
//        }
//        Arrays.sort(a, 1, n + 1);
//        for (int i = 1; i <= n; ++i) {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("\n");
//
//        long res = 0;
//        int flag = 0;
//        for (int i = n; i >= 1; --i) {
//            if (flag - a[i] != 1) {
//                res += a[i];
//                flag = a[i];
//            }
//        }
//
//        System.out.println(res);
//    }
}
