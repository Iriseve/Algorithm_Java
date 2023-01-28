package acwing.周赛.No88;

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
    //休息的可能只会在0和132/231子串，以及11/22，这三种情况
    //感觉是字符串匹配算法？
    //这里数据小直接暴力模拟了 13/15
    //漏了13332情况 麻了不搞了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder s = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String ai = sc.next();
            if (ai.equals("0"))
                sum++;
            s.append(ai);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                if (i + 1 < n && s.charAt(i + 1) == '1') {
                    sum++;
                    i = i + 1;
                } else if (i + 2 < n && s.charAt(i + 1) == '3' && s.charAt(i + 2) == '2') {
                    sum++;
                    i = i + 2;
                }
            } else if (s.charAt(i) == '2') {
                if (i + 1 < n && s.charAt(i + 1) == '2') {
                    sum++;
                    i = i + 1;
                } else if (i + 2 < n && s.charAt(i + 1) == '3' && s.charAt(i + 2) == '1') {
                    sum++;
                    i = i + 2;
                }
            }
        }
        System.out.println(sum);
    }
}
