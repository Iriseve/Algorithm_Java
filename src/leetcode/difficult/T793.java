package leetcode.difficult;

import java.util.Scanner;

/**
 * @ClassName T793
 * @Description 阶乘函数后K个零
 * @Author yiling
 * @date 2023/1/11 17:51
 */
public class T793 {
    //答案要么就是5，要么就是0
    //在阶乘末尾有K个零找的到的情况下就是5，找不到就是0

    //通过mediumT173中的函数计算阶乘末尾有多少个0
    public static long trailingZeroes(long n) {
        long res = 0;

        //  n/5+n/5/5+n/5/5/5+...
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static int preimageSizeFZF(int k) {
        //这里数据10^9，所以遍历肯定不行
        long l = 0, r = Long.MAX_VALUE - 1;
        while (l < r) {
            long mid = l + (r + 1 - l >> 1); //注意溢出
            if (trailingZeroes(mid) > k) r = mid - 1;
            else l = mid;
        }
        System.out.println(l);
        return trailingZeroes(l) == k ? 5 : 0;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(preimageSizeFZF(n));
    }
}
