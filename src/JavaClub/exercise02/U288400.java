package JavaClub.exercise02;

import java.util.Scanner;

/**
 * @ClassName U288400
 * @Description 白鼠试毒
 * @Author yiling
 * @date 2023/4/1 14:24
 */
public class U288400 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double num = Math.log(n) / Math.log(2);
        String[] v = Double.toString(num).split("\\.");
        if (!v[1].equals("0")) {
            System.out.println((int) num + 1);
        } else {
            System.out.println((int) num);
        }
    }
}
