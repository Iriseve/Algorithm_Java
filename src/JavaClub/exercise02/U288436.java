package JavaClub.exercise02;

import java.util.Scanner;

/**
 * @ClassName U288436
 * @Description
 * @Author yiling
 * @date 2023/4/1 16:22
 */
public class U288436 {
    public static long pow_MOD(long a, long b, long MOD) {
        a = a % MOD;
        long result = 1;
        for (; b != 0; b = b >> 1) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }
            a = a * a % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), p = sc.nextLong();
        System.out.println(a + "^" + b + " mod " + p + "=" + pow_MOD(a, b, p));
    }
}
