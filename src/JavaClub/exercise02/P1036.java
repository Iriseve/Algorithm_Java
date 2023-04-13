package JavaClub.exercise02;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName P1036
 * @Description [NOIP2002 普及组] 选数
 * @Author yiling
 * @date 2023/4/1 14:57
 */
public class P1036 {
    static int n, k;
    static int[] num;
    static boolean[] flag;
    static int result = 0;
    static int sum = 0;//记录挑选k个数的总和
    static HashSet<Integer> set = new HashSet<>();

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

    static void dfs(int u) {
        //走完啦
        if (u == k) {
            set.add(sum);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!flag[i]) {
                sum += num[i];
                flag[i] = true;
                dfs(u + 1);
                flag[i] = false;
                sum -= num[i];
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        num = new int[n];
        flag = new boolean[n];
        for (int i = 0; i < n; ++i) {
            num[i] = sc.nextInt();
        }
        dfs(0);
        for(Integer s:set){
            if(prime(s)==1){
                result++;
            }
        }
        System.out.println(result);

    }
}
