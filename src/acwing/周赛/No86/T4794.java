package acwing.周赛.No86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T4794
 * @Description 健身
 * @Author yiling
 * @date 2023/1/14 19:03
 */
public class T4794 {
    static int[] times = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; ++i) {
            int ai = Integer.parseInt(s[i - 1]);
            times[i % 3] += ai;   //chest 1 biceps 2 back 0
        }

        if(times[0]>times[1]&&times[0]>times[2]) System.out.println("back");
        if(times[1]>times[0]&&times[1]>times[2]) System.out.println("chest");
        if(times[2]>times[0]&&times[2]>times[1]) System.out.println("biceps");
    }
}
