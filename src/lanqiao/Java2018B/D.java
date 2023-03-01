package lanqiao.Java2018B;

/**
 * @ClassName D
 * @Description 测试次数
 * @Author yiling
 * @date 2023/2/12 1:06
 */
public class D {
    static int m = 3;
    static int n = 1000;
    static int[][] dp = new int[m + 1][n + 1];
    static int inf = 0x3f3f3f3f;

    public static void main(String[] args) {
        //初始化二维数组
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j)
                dp[i][j] = inf;
        }

        System.out.println(test(m, n));
    }

    //dp[m][n]表示剩下m个手机在m层高的塔中测试的次数
    private static int test(int m, int n) {
        //已经更新过就不用再计算了
        if (dp[m][n] != inf)
            return dp[m][n];

        //只剩一个手机，为了防止它摔碎，只能从下往上一层层测试
        if (m == 1)
            return dp[m][n] = n;
        //只有一层塔，无论防摔指数为0还是为1都要操作一次
        if (n == 1)
            return dp[m][n] = 1;

        //第一部手机从第i层塔测试一次
        for (int i = 1; i <= n; ++i) {
            //min代表最优策略，即前一部手机从哪一层塔开始摔可以使得操作次数最少
            //max代表最坏的运气
            dp[m][n] = Math.min(dp[m][n], 1 + Math.max(test(m, n - i), test(m - 1, i - 1)));
        }
        return dp[m][n];
    }
}
