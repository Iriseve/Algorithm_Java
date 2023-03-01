package acwing.每日一题2023春季;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName T1460
 * @Description 我在哪
 * 抽象描述： 找出最短不重复的子序列
 * @Author yiling
 * @date 2023/2/18 17:25
 */
public class T1460 {

    /**
     * 暴力搜索
     * 哈希表+截取字符串
     * O(N^2)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        for (int length = 1; length <= n; ++length) {
            boolean norSame = true;
            HashSet<String> hashSet = new HashSet<>();
            for (int i = 0; i + length <= n; ++i) {
                String str = s.substring(i, i + length);
                if (hashSet.contains(str)) {
                    norSame = false;
                    break;
                }
                hashSet.add(str);
            }
            if(norSame){
                System.out.println(length);
                break;
            }
        }
    }
}
