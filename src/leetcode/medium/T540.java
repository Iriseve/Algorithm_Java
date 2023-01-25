package leetcode.medium;

/**
 * @ClassName T540
 * @Description 有序数组中的单一元素
 * @Author yiling
 * @date 2023/1/14 18:41
 */
public class T540 {
    /**
     * 遍历
     */
    //双指针O(n)
    public int singleNonDuplicate1(int[] nums) {
        for(int i =0,j=1;i<nums.length&&j<nums.length;i=i+2,j=j+2){
            if(nums[i]!=nums[j]) return nums[i];
        }
        return nums[nums.length-1];
    }
    //异或应用
    //利用两个相同的数字异或为0，0异或任何数等于他本身，最后遍历一遍就能得到唯一出现的数
    public int singleNonDuplicate2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^=i;
        }
        return res;
    }


    /**
     * 二分+异或，O(logN)
     */
//    public int singleNonDuplicate(int[] nums) {
//        int len = nums.length;
//        if (len == 1) return nums[0];
//        else {
//            int l = 0, r = len-1;
//            while (l < r) {
//                int mid = l + (r - l >> 1);
//                if(nums[mid]>nums[mid-1])
//                    l=mid;
////                else
//
//            }
//            return 0;
//
//
//        }
//    }
}
