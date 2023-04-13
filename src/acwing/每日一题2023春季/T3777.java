package acwing.每日一题2023春季;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName T3777
 * @Description 砖块
 * @Author yiling
 * @date 2023/4/7 14:59
 */
public class T3777 {
    static int n;

    //翻转颜色
    static void reverse(char[] s, int i) {
        if (s[i] == 'W') {
            s[i] = 'B';
        } else {
            s[i] = 'W';
        }
    }

    static boolean check(char[] s, char colour) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            if (s[i] != colour) {
                reverse(s, i);
                reverse(s, i + 1);
                list.add(i);
            }
        }
        //最后一个字符元素只可能被前面的元素一起翻转，所以最后只要检查他和目标颜色是否一致，不一致就说明该数组没办法颜色一致
        if (s[n - 1] != colour) {
            return false;
        }
        System.out.println(list.size());
        if (list.size() != 0) {
            for (Integer i : list) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            n = scanner.nextInt();
            char[] s = scanner.next().toCharArray();
            char[] chars = Arrays.copyOf(s, n);//记得复制一次，原来的数组已经被第一次检查修改过啦
            //检查要么全黑，要么全白
            if (!check(s, 'W') && !check(chars, 'B')) {
                System.out.println(-1);
            }
        }
    }
}
