package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T795
 * @Description 一维前缀和
 * @Author yiling
 * @date 2022/12/13 22:49
 */
public class T795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] x = new int[n+1];
        String[] s1 = br.readLine().split(" ");
        int i;
        for (i = 1; i <= n; ++ i){
            x[i] = Integer.parseInt(s1[i-1]);
        }

        //前缀和预处理
        //这题主要是对原数组没有复用，所以直接将原数组改成前缀和数组了减少点空间嘿嘿偷个懒（正常的话应该在创建一个新的前缀和数组）
        for(i = 1;i <= n; ++ i){
            x[i] = x[i-1]+ x[i];
        }

        while (m--!=0){
            String[] s2 = br.readLine().split(" ");
            System.out.println(x[Integer.parseInt(s2[1])] - x[Integer.parseInt(s2[0])-1]); //计算区间和
        }
    }
}
