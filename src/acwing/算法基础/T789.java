package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T789
 * @Description 数的范围
 * @Author yiling
 * @date 2022/12/6 19:26
 */
public class T789 {
    //整数二分
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);  //数组长度
        int q = Integer.parseInt(s[1]);  //查询个数
        int[] nums = new int[n];
        int i;
        s = br.readLine().split(" ");
        for (i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int key;
        while ((q--) != 0) {
            key = Integer.parseInt(br.readLine());

            //查左边界
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                //左边界右侧的数都大于等于(右边界)key，左侧的数都小于key
                if (nums[mid] >= key) r = mid;
                else l = mid + 1;
            }
            if (nums[l] != key) System.out.println("-1 -1");
            else {
                System.out.print(l + " ");

                //查右边界
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    //右边界右侧的数都大于key 左侧的数小于等于key
                    if (nums[mid] <= key) l = mid;
                    else r = mid - 1;
                }
                System.out.println(r);
            }
        }
    }
}
