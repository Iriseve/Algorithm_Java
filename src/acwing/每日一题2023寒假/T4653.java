package acwing.每日一题2023寒假;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName T4653
 * @Description 数位排序
 * @Author yiling
 * @date 2023/1/4 21:12
 */
public class T4653 {

    //求数位和
    public static int sum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //这里为了统一下标和数值 从1~n
        Integer[] a = new Integer[n + 1];//原数数组
        for (int i = 1; i < n + 1; ++i)
            a[i] = i;

        //注意一下，这里数组是引用类型，默认初始化为空，所以一定得从1开始，否则会报空指针异常
        Arrays.sort(a, 1, n, new Comparator<Integer>() {
            //注意这里方法参数列表不能直接写o1,o2（和原方法参数列表一样）会有问题
            @Override
            public int compare(Integer i, Integer j) {
                int sum1 = sum(i);
                int sum2 = sum(j);
                return sum1 == sum2 ? i - j : sum1 - sum2;
            }
        });

        System.out.println(a[m]);
    }

}
