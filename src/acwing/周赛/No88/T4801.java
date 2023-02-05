package acwing.周赛.No88;

import java.util.Scanner;

/**
 * @ClassName T4801
 * @Description 强连通图
 * @Author yiling
 * @date 2023/1/28 19:19
 */
public class T4801 {
    //顺时针    逆时针
    //>>>>     <<<<<
    //^  v     v   ^
    //^  v     v   ^
    //<<<<     >>>>>
    //任意点可达=>边缘四点可达
    //边缘四点可达=>任意点可达？
    // 边缘四点可达，由于横竖一个方向，边缘的任意点一定可达;
    // 而对于内部点，只要两点都能到达边缘，又因为边缘可达，那么内部两点必定可达
    //而对于内部的点，因为边无限延申且有方向，所以一定能到边缘。由此可证
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        char a = s1.charAt(0), c = s1.charAt(n - 1);
        String s2 = sc.next();
        char b = s2.charAt(0), d = s2.charAt(m - 1);
        if ((a == '>' && b == '^' && c == '<' && d == 'v') || (a == '<' && b == 'v' && c == '>' && d == '^'))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
