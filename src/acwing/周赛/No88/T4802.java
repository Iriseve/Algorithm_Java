package acwing.周赛.No88;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T4802
 * @Description 金明的假期
 * @Author yiling
 * @date 2023/1/28 19:33
 */
public class T4802 {
    //0--NONE
    //1--Lib
    //2--Gym
    //3--Both
    /**
     * DP，状态机
     */
    static int[] a;//每天的开放情况
    static int[][] f;//f[i][j]表示第i天选择做j后的最小休息天数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n + 1];
        f = new int[n + 1][3];
        for (int i = 1; i <= n; ++i)
            a[i] = sc.nextInt();

        //j-0休息
        //j-1图书馆
        //j-2健身馆

        //初始化！！！
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(f[i], n);
        }
        f[0][0] = 0;

        for (int i = 1; i <= n; ++i) {
            f[i][0] = Math.min(f[i - 1][0], Math.min(f[i - 1][1], f[i - 1][2])) + 1;
            if ((a[i] >> 0 & 1) == 1) f[i][1] = Math.min(f[i - 1][0], f[i - 1][2]);
            if ((a[i] >> 1 & 1) == 1) f[i][2] = Math.min(f[i - 1][0], f[i - 1][1]);
        }

        System.out.println(Math.min(f[n][0], Math.min(f[n][1], f[n][2])));
    }


    /**
     *模拟
     */
    //休息的可能只会在0和132/231子串，以及11/22，这三种情况
    //这里数据小直接暴力模拟了 13/15
    //漏了13332情况 麻了不搞了
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        StringBuilder s = new StringBuilder();
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            String ai = sc.next();
//            if (ai.equals("0"))
//                sum++;
//            s.append(ai);
//        }
//
//        for (int i = 0; i < s.length(); ++i) {
//            if (s.charAt(i) == '1') {
//                if (i + 1 < n && s.charAt(i + 1) == '1') {
//                    sum++;
//                    i = i + 1;
//                } else if (i + 2 < n && s.charAt(i + 1) == '3' && s.charAt(i + 2) == '2') {
//                    sum++;
//                    i = i + 2;
//                }
//            } else if (s.charAt(i) == '2') {
//                if (i + 1 < n && s.charAt(i + 1) == '2') {
//                    sum++;
//                    i = i + 1;
//                } else if (i + 2 < n && s.charAt(i + 1) == '3' && s.charAt(i + 2) == '1') {
//                    sum++;
//                    i = i + 2;
//                }
//            }
//        }
//        System.out.println(sum);
//    }
}
