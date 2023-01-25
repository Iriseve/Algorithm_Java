package leetcode.easy;

import java.util.Scanner;

/**
 * @ClassName T441
 * @Description
 * @Author yiling
 * @date 2023/1/14 1:01
 */
public class T441 {
    public static long sum(int m) {
        return (long) (1 + m) * m;
    }

    public static int arrangeCoins(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (sum(mid) <= 2L * n) l = mid; //注意要加L，否则还是int,会丢失精度！！！
            else r = mid - 1;
        }
       return l;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(arrangeCoins(n));
    }
}
