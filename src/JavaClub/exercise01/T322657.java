package JavaClub.exercise01;

import java.util.Scanner;

/**
 * @ClassName T322657
 * @Description Eight Queens Puzzle
 * @Author yiling
 * @date 2023/3/18 14:51
 */
public class T322657 {
    static int n;
    static int[][] g;//棋盘
    static boolean[] col, dg, udg;//列，主对角，副对角
    static int num = 0;

    //x表示行
    static void dfs(int x) {
        //终止
        if (x == n) {
            if (num < 3) {
                for (int xi = 0; xi < n; ++xi) {
                    //输出一行字符串
                    for (int yj = 0; yj < n; yj++) {
                        if (g[xi][yj] != 0) {
                            System.out.print(g[xi][yj] + " ");
                            break;
                        }
                    }
                }
                System.out.println();//换行
            }
            num++;
            return;
        }

        for (int y = 0; y < n; ++y) {
            if (!col[y] && !dg[x + y] && !udg[x - y + n]) {
                g[x][y] = y + 1;
                col[y] = dg[x + y] = udg[x - y + n] = true;
                dfs(x + 1);//搜索下一行
                //还原现场
                col[y] = dg[x + y] = udg[x - y + n] = false;
                g[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        g = new int[n][n];
        col = new boolean[n];
        dg = new boolean[n * 2]; //这里注意开2倍空间，因为dfs里面对角线数组下标值域是[0,2n]
        udg = new boolean[n * 2];
        dfs(0);
        System.out.println(num);
    }
}
