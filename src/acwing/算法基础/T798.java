package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @ClassName T798
 * @Description 差分矩阵
 * @Author yiling
 * @date 2022/12/18 18:38
 */
public class T798 {

    static void insert(int x1,int y1,int x2,int y2,int c,int [][]b){
        b[x1][y1] += c;
        b[x2+1][y1] -= c;
        b[x1][y2+1] -= c;
        b[x2+1][y2+1] += c;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int)st.nval;
        st.nextToken();
        int q = (int)st.nval;
        int[][] a = new int[n + 10][m + 10]; //原始前缀和数组
        int[][] b = new int[n + 10][m + 10]; //差分数组
        int i,j;
        for(i = 1;i <= n;++ i){
            for (j = 1;j <= m;++ j){
                st.nextToken();
                a[i][j] = (int)st.nval;
                insert(i,j,i,j,a[i][j],b);
            }
        }


        while (q--!=0){
            st.nextToken();
            int x1 = (int)st.nval;
            st.nextToken();
            int y1 = (int)st.nval;
            st.nextToken();
            int x2 = (int)st.nval;
            st.nextToken();
            int y2 = (int)st.nval;
            st.nextToken();
            int c = (int)st.nval;
            insert(x1,y1,x2,y2,c,b);
        }

        for(i = 1;i<=n;++i){
            for (j = 1;j<=m;++j){
                a[i][j] = a[i][j-1]+a[i-1][j]-a[i-1][j-1]+b[i][j];
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}