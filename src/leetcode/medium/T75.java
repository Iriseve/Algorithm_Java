package leetcode.medium;

import java.util.Arrays;

/**
 * @ClassName T75
 * @Description 颜色分类
 * @Author yiling
 * @date 2023/7/14 11:29
 */
public class T75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }


    /**
     * 双指针
     * 借助快排partition分区过程的一趟扫描法
     * 设置循环不变量
     * [0,l) --> 0
     * [l,i) --> 1
     * (r,length-1]  --> 2
     * 注意循环不变量的初始值需要使区间为空，则初始化是不存在0、1、2
     * 以及循环终止条件是使区间完全覆盖 此时i>r
     * !!这里借助的就是指针i来观察所指元素的区间
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] == 2) {
                // 在第三个区间
                swap(nums, i, r);
                // r指针后面的都是2，所以交换完后，r指针得向前移动一位
                r--;
            } else if (nums[i] == 0) {
                //在第一个区间
                swap(nums, i, l);
                // l指针前面的都是0，所以把0交换到第一个区间后。l向后移动一位
                l++;
                //i一定>=i，所以也向后移动一位
                //或者说，i是扫描指针，从左向右扫描，扫描完当前元素后，向右移动一位
                //至于为什么nums[i]==2交换完以后不向右移，因为交换完以后确定的是2的位置是对的，但2是在i后面，而此时i指向的元素并不能保证位置正确，所以不移动
                i++;
            } else {
                //在第二个区间
                //1一定出现在i指针左边的位置，i指针观察到的位置元素是正确的，所以i可以后移。
                i++;
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void sortColors1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 原始快排
     * 实际不需要递归
     */
    public static void quickSort(int[] a, int l, int r) {
        if (l == r) {
            return;
        }

        int x = a[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (a[i] < x);
            do {
                j--;
            } while (a[j] > x);
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        quickSort(a, l, j);
        quickSort(a, j + 1, r);
    }


}
