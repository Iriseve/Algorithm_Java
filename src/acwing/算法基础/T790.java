package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T790
 * @Description 数的三次方根
 * @Author yiling
 * @date 2022/12/7 0:59
 */
public class T790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double l = 0, r, mid;

        if (n >= 0) {
            l = 0;
            r = 10000;
        } else {
            l = -10000;
            r = 0;

        }
        while (r - l >= 1e-8) {
            mid = (l + r) / 2;
            if (mid * mid * mid >= n) r = mid;
            else l = mid;

        }

        System.out.println(String.format("%.6f", l));

    }
}
