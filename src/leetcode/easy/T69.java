package leetcode.easy;

import java.util.Scanner;

/**
 * @ClassName T69
 * @Description
 * @Author yiling
 * @date 2023/1/14 0:16
 */
public class T69 {
    public static int mySqrt(int x) {
        double l = 0, r = x;
        while (r - l > 1e-4) {
            double mid = (l + r) / 2;
            if (mid * mid >= x) r = mid;
            else l = mid;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        int i = new Scanner(System.in).nextInt();
        System.out.println(mySqrt(i));
    }
}
