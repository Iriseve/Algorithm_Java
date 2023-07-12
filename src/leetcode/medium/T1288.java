package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @ClassName T1288
 * @Description
 * @Author yiling
 * @date 2023/7/11 21:11
 */
public class T1288 {
    public int removeCoveredIntervals1(int[][] intervals) {
        //按照区间的start升序排序,start相同则按end降序排列
        //则只需考虑下一个intervals是否应被加入list
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = list.getLast();
            if (intervals[i][1] > cur[1]) {
                list.add(intervals[i]);
            }
        }
        return list.size();
    }

    public int removeCoveredIntervals2(int[][] intervals) {
        //按照区间的start升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = list.getLast();
            if (intervals[i][1] > cur[1]) {
                list.add(intervals[i]);
                //需要考虑当前cur是否比intervals小而被覆盖掉
                //则从list中移除cur
                if (cur[0] == intervals[i][0]) {
                    list.remove(cur);
                }
            }
        }
//        System.out.println(Arrays.deepToString(list.toArray(new int[0][0])));
        return list.size();
    }
}
