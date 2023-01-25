package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T796
 * @Description 二维前缀和模板
 * @Description  子矩阵的和
 * @Author yiling
 * @date 2022/12/16 23:40
 */
public class T796 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        int[][] x = new int[n + 1][m + 1];

        int i ,j;
        //这里for循环从1开始一个是为了和题目统一，另一个就是避免特判了（直接用0行0列都为0初始化了hhhh）
        for(i = 1 ; i<=n; ++ i)
            for(j = 1 ; j <= m; ++ j ){
                x[i][j] = sc.nextInt();
                x[i][j] = x[i][j-1] + x[i-1][j] - x[i-1][j-1] + x[i][j];  //这里因为没有复用x数组，所以直接算前缀和数组了
            }

        int x1,y1,x2,y2;
        while (q-- != 0){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            System.out.println(x[x2][y2] - x[x2][y1 - 1] - x[x1-1][y2] + x[x1-1][y1-1]);  //子矩阵的和
        }
    }
}
