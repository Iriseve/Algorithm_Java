package leetcode.medium;

/**
 * @ClassName medium.T790
 * @Description 见题解
 * @Author yiling
 * @date 2022/11/12 11:47
 */
public class T790 {
    /**
     * 找规律
     */
    //与实际输入意义相同，f[0]为空（默认初始化为0）
//    public int numTilings(int n) {
//        if(n==1)return 1;
//        if(n==2)return 2;
//        long MOD = (long) Math.pow(10,9)+7;
//        long[] f = new long[n + 1];
//        f[1] = 1;
//        f[2] = 2;
//        f[3] = 5;
//        for(int i = 4;i<=n;i++){
//            f[i]=(2*f[i-1]+f[i-3])%MOD;
//        }
//        return (int)f[n];  //因为最后输出要求int所以强转一下
//    }
    /**
     * 动态规划
     */
    static final int MOD = (int) Math.pow(10, 9) + 7;

    public int numTilings(int n) {
        int[][] dp = new int[n + 1][4];
        dp[1][0] = 1;
        //0已默认初始化
        //dp[1][1] = 0;
        //dp[1][2] = 0;
        dp[1][3] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
