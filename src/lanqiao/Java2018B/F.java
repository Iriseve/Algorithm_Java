package lanqiao.Java2018B;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName F
 * @Description 递增三元组
 * @Author yiling
 * @date 2023/2/6 22:06
 */
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] num = new int[3][N + 1];
        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j <= N; ++j)
                num[i][j] = sc.nextInt();
        }

        //从小到大排序
        Arrays.sort(num[0]);
        Arrays.sort(num[1]);
        Arrays.sort(num[2]);


        int res = 0;

        /**
         * 暴力枚举
         *O(N^3)
         * 6/8
         */
        //从大到小找
        for (int i = 1; i <= N; ++i) {
            int j = N;
            while (j >= 1 && num[1][j] >= num[2][i]) {  //找到第一个小于num[2][i]的num[1][j]
                j--;
            }
            for (; j >= 1; --j) {
                int k = N;
                while (k >= 1 && num[0][k] >= num[1][j]) {  //找到第一个小于num[1][j]的num[0][k]
                    k--;
                }
                res += k;
            }
        }

        System.out.println(res);

    }
}
