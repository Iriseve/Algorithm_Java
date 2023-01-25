package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T842
 * @Description 排列数字
 * @Author yiling
 * @date 2023/1/24 20:12
 */
public class T842 {
    static int n; //1~n全排列（也即位数）
    static int[] path; //路径
    static boolean[] exist;//数字是否已经被用过

    static void dfs(int u) {

        //终止条件：走到尽头了，就可以返回了
        if (u == n) {
            //输出路径
            for (int i = 0; i < n; ++i) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!exist[i]) {
                path[u] = i;
                exist[i] = true;
                dfs(u + 1);
                exist[i] = false; //还原现场
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        path = new int[n + 1];
        exist = new boolean[n + 1];
        dfs(0);
    }
}
