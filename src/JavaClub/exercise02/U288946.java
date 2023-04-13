package JavaClub.exercise02;

import java.util.Scanner;

/**
 * @ClassName U288946
 * @Description Multiple (Medium)
 * @Author yiling
 * @date 2023/4/1 16:47
 */
public class U288946 {
    static int dozens(int i){
        int sum=0;
        for(int j =1;j<=i;++j){
            if(i%j==0){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i =1;i<=n;++i){
            sum +=dozens(i);
        }
        System.out.println(sum);
    }
}
