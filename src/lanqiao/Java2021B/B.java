package lanqiao.Java2021B;

import java.math.BigInteger;

/**
 * @ClassName B
 * @Description 卡片
 * @Author yiling
 * @date 2023/1/18 14:12
 */
public class B {
    static int[] cards = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            cards[i] = 2021;
        }
        BigInteger num = new BigInteger("1");
        BigInteger ten = new BigInteger("10");
        BigInteger zero = new BigInteger("0");
        int flag = 0;
        while (true) {
            BigInteger num1 = num;
            while (!num1.equals(zero)) {
                BigInteger mod = num1.mod(ten);
                cards[Integer.parseInt(String.valueOf(mod))]--;
                num1 = num1.divide(ten);
                if (cards[Integer.parseInt(String.valueOf(mod))] == -1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
            else
                num = num.add(new BigInteger("1"));
        }
        System.out.println(num.subtract(new BigInteger("1")));

    }
}
