package acwing.每日一题2023春季;

import java.util.Scanner;

/**
 * @ClassName T3956
 * @Description 截断数组
 * @Author yiling
 * @date 2023/2/13 18:10
 */
public class T3956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            nums[i] = sc.nextInt();
        }

        //求前缀和
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }

        /**
         * 双指针O(N^2),会爆
         */
//        long res = 0L;
//        if (n >= 3) {
//            for (int i = 1; i <= n - 2; ++i) {
//                for (int j = i + 2; j <= n; ++j) {
//                    if (sums[i] == (sums[j - 1] - sums[i + 1 - 1]) && sums[i] == (sums[n] - sums[j - 1])) {
//                        res++;
//                    }
//                }
//            }
//        }
//        System.out.println(res);

        /**
         * 遍历一个指针就行了,太妙了
         */
        //可以用总和去过滤下，总和如果不能分三段，分出来的三段就一定是不相等的
        //同时这个做法有一点非常重要，就是无论怎么切，总和不会变，那么每段区间的总和也不会变！！
        //也就是说无论两刀在哪里，每个区间的一直都是sums/3!
        if (n < 3 || sums[n] % 3 != 0) {
            System.out.println(0);
            return;
        }
        long res = 0L;
        //以下的j都是指第三段的第一个数字位置
        for (int j = 3, count = 0; j <= n; ++j) {

            //计算第一刀能放在哪些位置
            //第一段区间等于sums/3
            if (sums[j - 2] == sums[n] / 3) {
                count++;
            }
            //再查第二道
            if (sums[n] - sums[j - 1] == sums[n] / 3) {
                res += count;
            }
        }

//        for (int j = n, count = 0; j >= 3; --j) {
//            //先查第二刀
//            if (sums[n] - sums[j - 1] == sums[n] / 3) count++;
//            //再查第一刀
//            if (sums[j - 2] == sums[n] / 3) res += count;
//        }
        System.out.println(res);
    }
}
