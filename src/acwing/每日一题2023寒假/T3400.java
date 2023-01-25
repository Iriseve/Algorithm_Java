package acwing.每日一题2023寒假;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @ClassName T3400
 * @Description 统计次数
 * @Author yiling
 * @date 2022/12/27 14:29
 */
public class T3400 {
    static int countNum(int n, int k) {
        int q = 10;
        int flag = 0;
        while (n != 0) {
            if (n % q == k)
                flag++;
            n = n / q;
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        int flag = 0;
        int i;
        for (i = 1; i <= n; ++i) {
            flag += countNum(i, k);
        }
        System.out.println(flag);

    }
}
