package leetcode.easy;


/**
 * @ClassName T27
 * @Description 移除元素
 * @Author yiling
 * @date 2023/7/12 13:52
 */
public class T27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int len = removeElement(nums, val);
        System.out.println(len);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双指针优化
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement3(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = 0;
        while (right < len) {
            if (nums[right] != val) {
                nums[left++] = nums[right++];
            } else {
                right++;
            }
        }
        return left;
    }


    /**
     * 非原地，复制一份再给原数组赋值
     */
    public int removeElement1(int[] nums, int val) {
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                res[i++] = num;
            }
        }
        for (int j = 0; j < i; ++j) {
            nums[j] = res[j];
        }
        return i;
    }
}
