package leetcode.medium;

/**
 * @ClassName T633
 * @Description
 * @Author yiling
 * @date 2022/12/7 15:05
 */
public class T633 {

    //用枚举的方法
    public static boolean judgeSquareSum(int c) {
        long a; // 注意这里用long，否则a*a会溢出
        for (a = 0; a * a <= c; ++a) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) return true;
        }
        return false;
    }

    //二分,这道题可以但没必要hhhh
    public static boolean judgeSquareSum1(int c) {
        long a;
        //这里假设a<b
        for (a = 0; a * a <= c; ++a) {
            //右边界最大一定小于等于c的开方
            // 如果c的开方不是整数，就向下取整，不可能向上取整（这样直接就超出范围了）
            long l = a, r = (long) Math.sqrt(c);
            while (l <= r) {
                long mid = l + r >> 1;
                long sum = a * a + mid * mid;
                if (sum == c) return true;
                else if (sum < c) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }

    //双指针
    //可以参考这个题解
    // https://leetcode.cn/problems/sum-of-square-numbers/solution/shuang-zhi-zhen-de-ben-zhi-er-wei-ju-zhe-ebn3/
    public static boolean judgeSquareSum2(int c) {
        //假设a<b
        //初始化最大区间
        long a = 0, b = (long) Math.sqrt(c);
        //因为这里是指针一个一个移，所以最终找不到的时候即a b互换位置，相当于接下来的情况都查过了
        //也就是如果当a=b都没找到目标值 那就是找不到了
        while (a <= b) {
            long sum = a * a + b * b;
            if (sum == c) return true;
            else if (sum < c) ++a;
            else --b;
        }
        return false;
    }

    public static void main(String[] args) {
        long begin = System.nanoTime();

        System.out.println(judgeSquareSum1(5));

        long end = System.nanoTime();
        System.out.println("用时" + (end - begin) + "纳秒");
    }
}
