package acwing.每日一题2023春季;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName T3502
 * @Description 不同路径数
 * @Author yiling
 * @date 2023/3/1 14:45
 */
public class T3502 {
    static HashSet<String> hashSet = new HashSet(); //直接去重
    static int k;//走k次
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int m, n;
    static int[][] matrix;

    //x表示行，n表示列,num表示目前是第几步，s目前遍历的字符串
    static void dfs(int x, int y, int num, String s) {
        //终止条件
        if (num == k) {
            hashSet.add(s);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            //没有越界，在边界上的元素本来就不能往外界走、
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                dfs(nx, ny, num + 1, s + matrix[nx][ny]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dfs(i, j, 0, String.valueOf(matrix[i][j]));
            }
        }
        System.out.println(hashSet.size());
    }
}
