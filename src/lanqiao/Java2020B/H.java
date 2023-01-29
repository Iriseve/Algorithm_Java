package lanqiao.Java2020B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName H
 * @Description 数字三角形
 * @Author yiling
 * @date 2023/1/28 15:56
 */
public class H {

    /**
     * hh找不出状态方程就写暴搜了，显然超时了，过了一半
     */
    static int[][] nums;
    static int res;
    static int left,right;
    static int max=0;

    static void find(int i,int j){
        if(i==0){
            if(Math.abs(left-right)<=1 && res>max)
                max = res;
            return;
        }

        if(j==0){
            res += nums[i-1][j];
            right++;
            find(i-1,j);
            right--;
            res -= nums[i-1][j];
        }else if (j == i) {
            res += nums[i-1][j-1];
            left++;
            find(i-1,j-1);
            left--;
            res -= nums[i-1][j-1];
        }else {
            res += nums[i-1][j-1];
            left++;
            find(i-1,j-1);
            left--;
            res -= nums[i-1][j-1];
            res += nums[i-1][j];
            right++;
            find(i-1,j);
            right--;
            res -= nums[i-1][j];
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        for (int i = 0; i < n; ++i) {
            String[] s = br.readLine().split(" ");
            for(int j =0;j<s.length;++j){
                nums[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i =0;i<n;++i){
            res=nums[n-1][i];
            left=right=0;
            find(n-1,i);

        }
        System.out.println(max);
    }
}
