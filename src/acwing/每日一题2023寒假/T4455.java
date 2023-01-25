package acwing.每日一题2023寒假;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName T4455
 * @Description 出行计划
 * @Author yiling
 * @date 2023/1/16 20:30
 */
public class T4455 {
    static class travel {
        int t;  //进入时间
        int c;  //有效时间

        public travel(int ti, int ci) {
            t = ti;
            c = ci;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]); //n个出行计划，m个询问，k个等待时间
        ArrayList<travel> list = new ArrayList<>();
        int max = 0;//记录ci的最大值
        for (int i = 1; i <= n; ++i) {
            s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            max = Math.max(c, max);
            list.add(new travel(t, c));
        }


        while (m-- != 0) {
            int[] time = new int[max + 10];
            int qi = Integer.parseInt(br.readLine());
            int get = qi + k; //最大3*10^5
            int count = 0;
            for (int i = 0; i < n; ++i) {
                int c = list.get(i).c;
                if (time[c] == 0) {  //如果为0，表示是一个新的最晚有效期
                    time[c] = get + c - 1;
                }
                if (list.get(i).t <= time[c] && list.get(i).t >= get) {
//                    System.out.print("第" + (i + 1) + "项");
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}

