package luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @ClassName P1024
 * @Description
 * @Author yiling
 * @date 2023/1/3 18:08
 */
public class P1024 {
    public static double f(double a, double b, double c, double d, double x) {
        return a * x * x * x + b * x * x + c * x + d;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        double a = st.nval;
        st.nextToken();
        double b = st.nval;
        st.nextToken();
        double c = st.nval;
        st.nextToken();
        double d = st.nval;
        int num = 0;

        for (int i = -100; i <= 99; i++) {
            double l = i, r = i + 1;
            if (f(a, b, c, d, l) == 0) {
                System.out.printf("%.2f ", l);
                num++;
            }
            if (f(a, b, c, d, l) * f(a, b, c, d, r) < 0) {
                while (r - l > 1e-4) {
                    double mid = (l + r) / 2;
                    if (f(a, b, c, d, l) * f(a, b, c, d, mid) <= 0)
                        r = mid;
                    else
                        l = mid;
                }
                System.out.printf("%.2f ", l);
                num++;
            }
            if (num == 3) break;
        }

    }
}
