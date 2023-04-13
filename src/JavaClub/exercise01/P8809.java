package JavaClub.exercise01;

import java.util.Scanner;

/**
 * @ClassName P8809
 * @Description [蓝桥杯 2022 国 C] 近似 GCD
 * @Author yiling
 * @date 2023/3/25 15:26
 */
public class P8809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), g = sc.nextInt(); //n数组个数，g最大公约数
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            //求输入的数是否需要修改，即它是否属于g最大公约数的倍数
            //这里可能会有个疑问：如果输入比g小（余数就是它本身），那肯定需要被改变；
            //但如果比g大，又全是g的倍数，那g只能是公约数而不是最大公约数，但这种情况只需改变一个数为g就可以把最大公约数降下来啦！
            int num = sc.nextInt() % g == 0 ? 0 : 1; //如果不是g的倍数，那么它就需要被修改，用1来标记
            a[i] = a[i - 1] + num; //求前缀和
        }
        long ans = 0L;

        /**
         * 双指针求区间
         */
        //循环遍历左端点,由于最小区间长度为2，所以左端点最多到n-1
//        for (int l = 1, r = 2; l < n; ++l) {
//            //找到以l为端点，符合修改最多一个数的最大区间（即再多一个数，需要修改的数就要变成两个了）
//            while (r <= n && a[r] - a[l - 1] <= 1) { //利用区间和来判断该区间有多少个需要被修改的数
//                ++r;
//            }
//            ans += r - (l + 1); //[l,l+1]区间长2,[l,l+2]区间长3,.....,[l,r]区间长r-l+1
//        }

        /**
         * 二分
         */
//        for (int i = 1; i < n; ++i) {
//            int l = i + 1, r = n + 1;
//            //找到第一个右端点，使得区间需要改变的值大于1
//            while (l < r) {
//                int mid = (l + r) / 2;
//                if (a[mid] - a[i - 1] <= 1) {
//                    l = mid + 1;
//                } else {
//                    r = mid;
//                }
//            }
//            if (a[l - 1] - a[i - 1] > 1) {
//                continue;
//            }
//            ans += l - 1 - (i + 1) + 1;
//        }

        for (int i = 1; i < n; ++i) {
            int l = i + 1, r = n;
            //找到最后一个满足题意最多只修改一个元素的区间右端点
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (a[mid] - a[i - 1] > 1) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (a[l] - a[i - 1] > 1) {
                continue;
            }
            ans += l - (i + 1) + 1;
        }

        System.out.println(ans);
    }
}
