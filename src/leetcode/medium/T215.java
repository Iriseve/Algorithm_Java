package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @ClassName T215
 * @Description 数组中的第K个最大元素
 * @Author yiling
 * @date 2023/7/16 14:36
 */
public class T215 {
    /**
     * 建立容量为k的最小值堆
     * 特点：在线维护动态数据的最大最小值
     * 时间复杂度：O(nlogk) 调整堆O(logk)
     * 空间复杂度:O(k),一个容量为k的最小堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        //优先队列，先进先出，默认自然排序，即队头最小值、队尾最大值
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            //先放进队列
            queue.offer(num);
            //一旦队列超出容量
            if (queue.size() > k) {
                //就把队头元素（即最小值）poll出去
                queue.poll();
            }
        }
        //最后留下的队头就是第K大元素
        return queue.peek();
    }

    /**
     * 快速选择
     * 利用快排中的轴值计算
     * 特点：确定数据量的情况下寻找第k大的数
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        // 将第k大转变为第n-k+1小，因为是元素下标从0开始，所以就不用+1
        int k_smallest = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k_smallest);
    }

    //交换元素
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //对序列分区操作，并寻找轴值元素的位置
    public int partition(int[] nums, int left, int right, int pivot_index) {
        //轴值元素
        int pivot = nums[pivot_index];
        //先把轴值元素放到最后，则寻找轴值元素的实际位置只需遍历到倒数第二个
        swap(nums, pivot_index, right);
        // 初始化轴值元素的实际位置
        int store_index = left;

        //寻找轴值元素的实际位置
        //即轴值元素左边都小于轴值元素
        //轴值元素右边都得大于轴值元素
        for (int i = left; i < right; ++i) {
            if (nums[i] < pivot) {
                //交换到轴值元t素位置的左边
                swap(nums, store_index, i);
                //轴值指针右移
                store_index++;
            }
        }

        //遍历完以后，store_index就是轴值元素的实际位置
        swap(nums, store_index, right);
        return store_index;
    }

    public int quickSelect(int[] nums, int left, int right, int k_smallest) {
        //只有一个元素，直接返回
        if (left == right) {
            return nums[left];
        }
        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left);
        pivot_index = partition(nums, left, right, pivot_index);
        if (pivot_index == k_smallest) {
            return nums[pivot_index];
        }
        if (pivot_index < k_smallest) {
            return quickSelect(nums, pivot_index + 1, right, k_smallest);
        }
        return quickSelect(nums, left, pivot_index - 1, k_smallest);
    }
}
