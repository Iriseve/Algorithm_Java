package acwing.每日一题2023寒假;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @ClassName T4261
 * @Description 孤独的照片（还没过）
 * @Author yiling
 * @date 2022/12/19 2:18
 */
public class T4261 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        String s = st.sval;

        int i,j;
        int flag = 0;
        for(i = 0;i < n-2;++ i){
            int[] ints = new int[2];
            for(j = i; j <= n-1 ; ++j){
                switch (s.charAt(j)){
                    case 'G': ints[0]++;break;
                    case 'H':ints[1]++;break;
                }
                if(ints[0] == j-i-1 || ints[1] == j-i-1){
                    flag++;
                    break;
                }
            }
        }
        System.out.println(flag);
    }
}
