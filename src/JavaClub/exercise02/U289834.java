package JavaClub.exercise02;

import java.util.Scanner;

/**
 * @ClassName U289834
 * @Description 数的计算
 * @Author yiling
 * @date 2023/4/1 16:30
 */
public class U289834 {
    static int res = 1;

    static void check(int u) {
        int burden = u/2;
        if(burden==0){
            return;
        }
            for (int i = 1;i<=u/2;++i){
                res++;
                check(i);
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        check(n);
        System.out.println(res);
    }
}
