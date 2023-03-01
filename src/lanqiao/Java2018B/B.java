package lanqiao.Java2018B;

/**
 * @ClassName B
 * @Description 方格计数
 * @Author yiling
 * @date 2023/2/6 21:13
 */
public class B {
    static long N = 50000L;

    /**
     * 以x为一个单位，求y相当于看一列上有多少方格满足
     */
    public static void main(String[] args) {
        long x = 0, y = N, res = 0;
        for (x = 1; x < N; ++x) {
            while (x*x+y*y>N*N && y>0) y--;
            res+=y;
        }
        System.out.println(4*res);
    }
}
