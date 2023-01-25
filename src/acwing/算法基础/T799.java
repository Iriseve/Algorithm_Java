package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T799
 * @Description 最长连续不重复子序列
 * @Author yiling
 * @date 2023/1/5 23:43
 */
public class T799 {

    static int[] s = new int[100000 + 10]; //记录元素出现个数（空间换时间）

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int i, j;
        for (i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }

        int ans = 0;

//        //朴素做法O(n^2)
//        //i是终点，j是起点
//        for(i=0;i<n;++i){
//            for(j=0;j<=i;++j)
//                //如果满足连续不重复，那么答案就更新
//                if(check(j,i)){
//                    ans = Math.max(ans,i-j+1);
//                }
//        }

        //双指针O(n)
        //i代表终点，j为起点
        //这里i右移，j也跟着右移，j不会左移，所以能将时间复杂度减少为线性
        //j不会左移的原因是当i右移前已经找到了之前的最大无重复元素子序列，如果j在i右移后还能左移，那么之前的最大子序列就可以变得更大，矛盾。所以j只可能右移
        for (i = 0, j = 0; i < n; ++i) {
            s[a[i]]++;//i一右移就代表有新的元素加入子序列
            while (s[a[i]] > 1) { //就代表a[i]这个元素出现了两次
                //此时j就要右移
                s[a[j]]--; //j一旦右移就代表有元素减少
                j++; //右移
            }
            ans = Math.max(ans, i - j + 1); //此时子序列不再有重复元素
        }

        System.out.println(ans);
    }
}
