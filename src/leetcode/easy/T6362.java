package leetcode.easy;


import java.util.*;

/**
 * @ClassName T6362
 * @Description 合并两个二维数组 - 求和法
 * 出自第 333 场周赛
 * @Author yiling
 * @date 2023/2/19 10:33
 */
public class T6362 {
    public static int[][] check(int[][] nums1, int[][] nums2) {
        HashSet<Integer> set = new HashSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        for (; i < nums1.length; ++i) {
            int a = nums1[i][0], b = nums2[i][0];
            if (set.contains(b)) {
                map.put(b, nums2[i][1] + map.get(b));
            } else {
                map.put(b, nums2[i][1]);
            }
            set.add(b);
            if (set.contains(a)) {
                map.put(a, nums1[i][1] + map.get(a));
            } else {
                map.put(a, nums1[i][1]);
            }
            set.add(a);

        }
        for (; i < nums2.length; ++i) {
            if (set.contains(nums2[i][0])) {
                map.put(nums2[i][0], nums2[i][1] + map.get(nums2[i][0]));
            } else {
                map.put(nums2[i][0], nums2[i][1]);
            }
            set.add(nums2[i][0]);
        }
        int[][] ints = new int[set.size()][2];
        int j = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ints[j][0] = entry.getKey();
            ints[j++][1] = entry.getValue();
        }
        return ints;
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 >= length2) {
            return check(nums2, nums1);
        } else {
            return check(nums1, nums2);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{2, 4}, {3, 6}, {5, 5}};
        int[][] b = {{1, 3}, {4, 3}};
        mergeArrays(a, b);
    }
}
