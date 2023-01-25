package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName T803
 * @Description 区间合并
 * @Author yiling
 * @date 2023/1/13 17:29
 */
public class T803 {

     static class PII implements Comparable<PII> {
        int start, end;

        public PII(int x, int y) {
            start = x;
            end = y;
        }

        @Override
        public int compareTo(PII o) {
            return Integer.compare(start, o.start);
        }
    }

    public static ArrayList<PII> merge(List<PII> lists) {
        ArrayList<PII> res = new ArrayList<>();//用来存放区间合并后的左右区间
        Collections.sort(lists);  //对左端点排序

        int st = (int) -2e9, ed = (int) -2e9;
        for (PII list : lists) {

            if (list.start > ed) { // 对于独立的区间
                if (st != (int) -2e9) res.add(new PII(st, ed)); //将上一个合并完的区间放到结果中
                st = list.start;
                ed = list.end;
            } else {
                ed = Math.max(ed, list.end);//合并区间
            }
        }

        if (st != (int) -2e9) res.add(new PII(st, ed));//将最后一个独立区间放到结果中

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        ArrayList<PII> alls = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);
            alls.add(new PII(l, r));
        }

        ArrayList<PII> mergeList = merge(alls);

        System.out.println(mergeList.size());
    }
}
