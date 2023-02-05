package acwing.周赛.No88;

import java.util.Scanner;

/**
 * @ClassName T4800
 * @Description 下一个
 * @Author yiling
 * @date 2023/1/28 19:05
 */
public class T4800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int y = x + 1; ; ++y) {
            int[] i = new int[10];
            int flag = 0;
            int num = y;
            while (num != 0) {
                i[num % 10]++;
                if (i[num % 10] == 2) {
                    flag = 1;
                    break;
                }
                num = num / 10;
            }
            if (flag == 0) {
                System.out.println(y);
                break;
            }
        }
    }
}
