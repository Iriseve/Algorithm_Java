package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName T179
 * @Description 最大数
 * @Author yiling
 * @date 2023/7/13 11:39
 */
public class T179 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    /**
     * 使用字符串拼接比较大小
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + ""); //加“”相当于字符串拼接，这里直接用空字符串进行拼接
        }
        list.sort((o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        if (builder.charAt(0) == '0') {
            return "0";
        }
        return builder.toString();

    }
}