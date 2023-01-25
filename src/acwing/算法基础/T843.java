package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T843
 * @Description n-皇后问题
 * @Author yiling
 * @date 2023/1/25 20:00
 */
public class T843 {

    static int n;
    static char[][] g;//棋盘
    static boolean[] row,col, dg, udg;//行，列，主对角，副对角

    /**
     * 按行搜索
     */
    //x表示行
    static void dfs1(int x) {
        //终止
        if (x == n) {
            for (int xi = 0; xi < n; ++xi) {
                //输出一行字符串
                for (int yj = 0; yj < n; yj++)
                    System.out.print(g[xi][yj]);
                System.out.println();//换行
            }
            //一种方案结束换行
            System.out.println();
            return;
        }

        for (int y = 0; y < n; ++y) {
            if (!col[y] && !dg[x + y] && !udg[x - y + n]) {
                g[x][y] = 'Q';
                col[y] = dg[x + y] = udg[x - y + n] = true;
                dfs1(x + 1);//搜索下一行
                //还原现场
                col[y] = dg[x + y] = udg[x - y + n] = false;
                g[x][y] = '.';
            }
        }
    }

    /**
     * 按格搜索
     */
    static void dfs2(int x, int y, int s) {
        if (y == n) {
            x++;
            y = 0;
        }

        //搜索结束
        if (x == n) {
            //皇后都放满了
            if (s == n) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j)
                        System.out.print(g[i][j]);
                    System.out.println();
                }
                System.out.println();
            }
            //无论放没放满最后都返回
            return;
        }

        //不放皇后
        dfs2(x, y + 1, s);

        //放皇后
        if (!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]) {
            g[x][y]='Q';
            row[x]=col[y]=dg[x+y]=udg[x-y+n]=true;
            dfs2(x,y+1,s+1);
            row[x]=col[y]=dg[x+y]=udg[x-y+n]=false;
            g[x][y]='.';
        }
    }

    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        g = new char[n][n];
        col = new boolean[n];
        row = new boolean[n];
        dg = new boolean[n * 2]; //这里注意开2倍空间，因为dfs里面对角线数组下标值域是[0,2n]
        udg = new boolean[n * 2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j)
                g[i][j] = '.';
        }
//        dfs1(0);
        dfs2(0,0,0);
    }
}
