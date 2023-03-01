package acwing.每日一题2023春季;

import java.util.Scanner;

/**
 * @ClassName T3768
 * @Description 字符串删减
 * @Author yiling
 * @date 2023/2/18 21:21
 */
public class T3768 {
    /**
     * 抽象描述：有多少个xxx子串
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String s = sc.next();
//        long res = 0L;
//        for (int i = 0; i < n - 2; ++i) {
//            String str = s.substring(i, i+3);
//            if ("xxx".equals(str)) {
//                res++;
//            }
//        }
//        System.out.println(res);
//    }

    /**
     * 模拟
     * 只会删除x，不会删除其他字母
     * 所以只要找出每段连续x的长度，使他小于3即可
     * 找区间长度：双指针
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int res = 0;
        //i左指针，j右指针
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'x') {
                int j = i;
                while (j < n && s.charAt(j) == 'x') {
                    j++;
                }
                //连续x的区间长度
                int length = (j - 1) - i + 1;
                //整个区间只要两个x，其他全都要删掉
                res += Math.max(length - 2, 0);
                //修改左指针到j的位置，因为下一次会自增，所以先减1
                i = j - 1;
            }
        }
        System.out.println(res);
    }
}
