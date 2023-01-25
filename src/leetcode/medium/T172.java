package leetcode.medium;

import java.util.Scanner;

/**
 * @ClassName T172
 * @Description  阶乘后的零
 * @Author yiling
 * @date 2023/1/11 17:42
 */
public class T172 {
    public static int trailingZeroes(int n) {
        int res = 0;

        //  n/5+n/5/5+n/5/5/5+...
        while (n != 0) {  //这里可以理解为分母从大到小
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(trailingZeroes(n));
    }
}
