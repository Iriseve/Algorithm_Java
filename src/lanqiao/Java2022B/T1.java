package lanqiao.Java2022B;

import java.math.BigInteger;

/**
 * @ClassName T1
 * @Description 星期计算
 * @Author yiling
 * @date 2023/1/6 21:21
 */
public class T1 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("20").pow(22);
        BigInteger s = a.subtract(new BigInteger("1"));
        BigInteger m = s.mod(new BigInteger("7"));
        if(m.equals(new BigInteger("0"))){
            System.out.println(7);
        }else {
            System.out.println(m);
        }
    }
}
