package lanqiao.Java2022B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @ClassName T4
 * @Description
 * @Author yiling
 * @date 2023/1/7 23:52
 */
public class T4 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        int[] a = new int[n];
        int i,j;
        for(i=0;i<n;++i){
            st.nextToken();
            a[i]=(int)st.nval;
        }


        int[][] big = new int[n][n-1];//统计比下标元素大的数
        int[] num = new int[n];//统计比下标元素大的数的个数
        for(i=0;i<n-1;++i){
            for(j=i+1;j<n;++j){
                if(a[j]>a[i]){
                    big[i][num[i]]=a[j];
                    num[i]++;
                }else{
                    big[j][num[j]]=a[i];
                    num[j]++;
                }
            }
        }

//        for (i=0;i<n;++i){
//            for(j=0;j<num[i];++j){
//                System.out.print(big[i][j]+" ");
//            }
//            System.out.println("\n");
//        }

        int mid =(n-1)/2;
        for(i=0;i<n;++i){
            if(num[i]<=mid)
                System.out.print("0 ");
            else {
                Arrays.sort(big[i],0,num[i]-1);
                System.out.print(big[i][num[i]-mid-1]+1-a[i]+" ");
            }
        }

    }
}
