package acwing.周赛.No86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T4795
 * @Description 安全区域
 * @Author yiling
 * @date 2023/1/14 19:17
 */
public class T4795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        int[] row = new int[n + 1];//行
        int[] column = new int[n + 1];//列
        int rowCount = n;
        int columnCount = n;
        for (int i = 1; i <= m; ++i) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            if (row[x] == 0) {
                rowCount--;
                row[x] = 1;
            }
            if(column[y] == 0){
                columnCount--;
                column[y] = 1;
            }
            System.out.print((long)rowCount*columnCount+" ");
        }
    }
}
