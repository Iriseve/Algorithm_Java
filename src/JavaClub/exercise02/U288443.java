package JavaClub.exercise02;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName U288443
 * @Description 数列之异或
 * @Author yiling
 * @date 2023/4/1 15:24
 */
public class U288443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger num = new BigInteger("0");
        for (BigInteger i = new BigInteger("1"); i.compareTo(n) != 1; i = i.add(new BigInteger("1"))) {
            num = num.xor(i);
        }
        System.out.println(num);
    }
}
