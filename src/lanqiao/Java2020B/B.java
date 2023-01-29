package lanqiao.Java2020B;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName B
 * @Description 寻找20020
 * @Author yiling
 * @date 2023/1/27 15:56
 */
public class B {
    static int count = 0;
    static char[][] str = new char[300][300];

    //以str[x][y]为起点看有没有2020
    //因为该点作为起点，所以只要考虑向右 下 右下即可，左 上 左上都会在遍历点的时候计算到。
    static void countNum(int x, int y) {
        if (str[x][y] != '2')
            return;
        //向右
        if (y + 3 < 300) {
            if (str[x][y + 1] == '0' && str[x][y + 2] == '2' && str[x][y + 3] == '0')
                count++;
        }

        //向下
        if (x + 3 < 300) {
            if (str[x + 1][y] == '0' && str[x + 2][y] == '2' && str[x + 3][y] == '0')
                count++;
        }

        //往下对角线
        if (x + 3 < 300 && y + 3 < 300) {
            if (str[x + 1][y + 1] == '0' && str[x + 2][y + 2] == '2' && str[x + 3][y + 3] == '0')
                count++;
        }

    }

    //直接暴力枚举，原来想着能不能用kmp减少时间，不过数据就300*300,想多了
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < str.length; ++i) {
            str[i] = br.readLine().toCharArray(); //readLine()遇换行结束
        }

//        Scanner sc = new Scanner(new File("src/lanqiao/Java2020B/2020.txt"));  // Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < str.length; i++) {
//            str[i] = sc.nextLine().toCharArray();
//        }

        for (int i = 0; i < 300; ++i) {
            for (int j = 0; j < 300; ++j)
                countNum(i, j);
        }

        System.out.println(count);

    }
}
