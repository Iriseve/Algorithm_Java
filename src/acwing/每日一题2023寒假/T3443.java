package acwing.每日一题2023寒假;

import java.util.Scanner;

/**
 * @ClassName T3443
 * @Description 学分绩点
 * @Author yiling
 * @date 2023/1/1 19:25
 */
public class T3443 {
    public static double GPA(int score) {
        double gpa = 0;
        if (score < 60)
            gpa = 0;
        else if (score < 64)
            gpa = 1.0;
        else if (score < 68)
            gpa = 1.5;
        else if (score < 72)
            gpa = 2.0;
        else if (score < 75)
            gpa = 2.3;
        else if (score < 78)
            gpa = 2.7;
        else if (score < 82)
            gpa = 3.0;
        else if (score < 85)
            gpa = 3.3;
        else if (score < 90)
            gpa = 3.7;
        else
            gpa = 4.0;
        return gpa;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] lesson = new int[n];
        double[] score = new double[n];
        int lesson_sum = 0;
        int i;
        for (i = 0; i < n; ++i) {
            lesson[i] = sc.nextInt();
            lesson_sum += lesson[i];
        }
        for (i = 0; i < n; ++i) {
            score[i] = GPA(sc.nextInt());
        }
        double sum = 0;
        for (i = 0; i < n; ++i) {
            sum += score[i] * lesson[i] * 1.0;
        }
        sum = sum / lesson_sum;
        System.out.printf("%.2f\n",sum);
    }
}
