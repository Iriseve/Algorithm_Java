package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @ClassName T56
 * @Description 合并区间
 * @Author yiling
 * @date 2023/7/11 19:20
 */
public class T56 {
    public static void main(String[] args) {
        int[][] a = {{1, 4}, {2, 3}};
        System.out.println(Arrays.deepToString(merge(a)));
    }

    public static int[][] merge(int[][] intervals) {
        //按照每段区间的start进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]); // 加入第一个区间
        for (int i = 1; i < intervals.length; i++) {
            //得到当前区间的指针
            int[] cur = list.getLast();
            //当前区间的end如果大于下一个未合并区间的start
            //则合并，合并后当前区间的end取之前和现在end的最大值
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 处理下一个待合并区间
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][0]);
    }
}


