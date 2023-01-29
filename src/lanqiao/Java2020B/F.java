package lanqiao.Java2020B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName F
 * @Description 成绩分析
 * @Author yiling
 * @date 2023/1/27 19:32
 */
public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = 100;
        int max = 0;
        double aver = 0;
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            aver += num;
        }

        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", aver / n);
    }

}
