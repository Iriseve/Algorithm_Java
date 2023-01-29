package lanqiao.Java2020B;

import java.util.Arrays;

/**
 * @ClassName C
 * @Description 蛇形填数
 * @Author yiling
 * @date 2023/1/27 16:08
 */
public class C {
    public static void main(String[] args) {
        int[][] num = new int[40][40];
        int flag =1;
        num[0][0]=1;
        int out = 2;
        for(int i =1;i<40;++i){
            for(int j=0;j<=i;++j){
                if(flag==1){
                    num[j][i-j]=out;
                    out++;
                }else{
                    num[i-j][j]=out;
                    out++;
                }
            }
            flag *=(-1);
        }
        System.out.println(num[19][19]);
//        for (int[] i:num) {
//            System.out.println(Arrays.toString(i));
//        }
    }
}
