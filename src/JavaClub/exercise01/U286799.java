package JavaClub.exercise01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName U286799
 * @Description A Xor B Problem
 * @Author yiling
 * @date 2023/3/18 14:17
 */
public class U286799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            long x = sc.nextLong();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Long, Integer> cnt : map.entrySet()) {
            res += (long) cnt.getValue() * cnt.getValue();
        }
        System.out.println(res);
    }
}
