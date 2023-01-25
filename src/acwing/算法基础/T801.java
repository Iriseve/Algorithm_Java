package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T801
 * @Description 二进制中1的个数
 * @Author yiling
 * @date 2023/1/12 17:49
 */
public class T801 {
    public static int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        while(n--!=0){
            int x = sc.nextInt();
            int res = 0;

            while (x!=0){
                x-=lowbit(x); //每次减去x的最后一位1
                res++;
            }
            System.out.print(res+" ");
        }
    }
}
