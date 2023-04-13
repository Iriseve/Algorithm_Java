package JavaClub.exercise02;

import java.util.Scanner;

/**
 * @ClassName P1865
 * @Description A % B Problem
 * @Author yiling
 * @date 2023/4/1 14:05
 */
public class P1865 {
    static int prime(int num) {
        int flag = 0;
        for (int i = 1; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                flag++;
            }
            //不是质数
            if (flag > 1) {
                return 0;
            }
        }
        //是质数
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] num = new int[m + 1];
        for (int i = 2; i <= m; ++i) {
            num[i] = num[i - 1] + prime(i); //求前缀和
        }
        for (int i = 1; i <= n; ++i) {
            int l = sc.nextInt(), r = sc.nextInt();
            if (r > m) {
                System.out.println("Crossing the line");
                continue;
            }
            if (l < 0) {
                System.out.println(num[r] - num[0]);
            } else {
                System.out.println(num[r] - num[l - 1]);
            }
        }
    }
}
