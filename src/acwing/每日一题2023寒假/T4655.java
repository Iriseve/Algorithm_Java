package acwing.每日一题2023寒假;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @ClassName T4655
 * @Description 重新排序
 * @Author yiling
 * @date 2023/1/6 15:30
 */
public class T4655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer tr = new StreamTokenizer(br);
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];//原数组
        int[] count = new int[n + 10];//记录数字被加次数
        int i;
        for (i = 1; i <= n; ++i) {
            tr.nextToken();
            a[i] = (int) tr.nval;
        }
        int m = Integer.parseInt(br.readLine());
        long sum1 = 0L;//总和需要long,最大10^5*10^6*10^5=10^16
        for (i = 1; i <= m; ++i) {
            tr.nextToken();
            int l = (int) tr.nval;
            tr.nextToken();
            int r = (int) tr.nval;

            //差分操作
            count[l]++;
            count[r + 1]--;
        }

        for (i = 1; i <= n; ++i) {
            count[i] += count[i - 1]; //求前缀和，得到统计元素被加次数的数组
            sum1 += (long) a[i] * count[i];
        }

        Arrays.sort(a, 1, n + 1);
        Arrays.sort(count, 1, n + 1);

        long sum2 = 0L;
        for (i = 1; i <= n; ++i) {
            sum2 += (long) count[i] * a[i];
        }

        System.out.println(sum2 - sum1);
    }
}
