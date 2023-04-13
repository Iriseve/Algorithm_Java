package JavaClub.exercise01;

import java.util.Scanner;

/**
 * @ClassName P8808
 * @Description [蓝桥杯 2022 国 C] 斐波那契数组
 * @Author yiling
 * @date 2023/3/18 15:03
 */
public class P8808 {
    static int[] a;
    static int n;

    static int f1(int i, int a) {
        if (i == 0 || i == 1) {
            return a;
        }
        return f1(i - 1, a) + f1(i - 2, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 5];
        int[] b = new int[n + 5];
        int[] c = new int[n + 5];
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        int res = n;
        for (int j = 0;j<2;++j){
            int fix = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != f1(i, a[j])) {
                    fix++;
                }
            }
            res = Math.min(res, fix);
        }


        System.out.println(res);
    }
}
