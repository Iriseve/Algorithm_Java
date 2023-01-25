package lanqiao.Java2022B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T5
 * @Description
 * @Author yiling
 * @date 2023/1/8 16:41
 */
public class T5 {
    //求整数阶乘 末尾0的个数
//    public static void main(String[] args) {
//        int i;
//        BigInteger x=new BigInteger("1");
//        for(i=1;i<=995;++i){
//            x = x.multiply(new BigInteger(String.valueOf(i)));
//        }
//        System.out.println(x);
//        int num=0;
//        BigInteger d = x.mod(new BigInteger("10"));
//        while(d.equals(new BigInteger("0"))){
//            num++;
//            x=x.divide(new BigInteger("10"));
//            d=x.mod(new BigInteger("10"));
//        }
//        System.out.println(num);
//    }

    //求阶乘末尾0的个数
    //超时
    public static long count2(long x) {
        long res = 0;  //因数5的个数
        for (long i = 5; i <= x; i = i + 5) {  //每隔5 因数里面就会多至少一个5
            long num = i;
            while (num % 5 == 0) { //当num为5的幂时，就要相应的多加一次5
                res++;
                num /= 5;
            }
        }
        return res;
    }

    //有一个样例没通过，five可能溢出
    public static long count3(long x) {
        long res = 0;
        long five = 5;
        while (five < x) {
            res += x / five;
            five *= 5;
        }
        return res;
    }

    //求因数5的个数
    //nice
    public static long count(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x = x / 5;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long l = 1;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + (r - l >> 1);
            if (count(mid) < k)
                l = mid + 1;
            else
                r = mid;
        }

        if (count(l) == k) System.out.println(l);
        else System.out.println(-1);
    }
}
