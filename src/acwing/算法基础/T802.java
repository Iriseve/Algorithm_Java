package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName T802
 * @Description 区间和
 * @Author yiling
 * @date 2023/1/12 22:42
 */

// 主要思想就是题目给的区间是2*10^9,所以直接用前缀和肯定不行
// 但实际上会用到的区间长度最大只有2*m+n=3*10^5
// 所以可以离散化后再用前缀和
public class T802 {
    static int N = 300010;

    static int[] a; //存放被加元素的数组
    static int[] s; //前缀和数组

    static List<Integer> alls = new ArrayList<>();//存放所有被操作的区间
    static List<PII> adds = new ArrayList<>(), query = new ArrayList<>();//存放操作

    //通过PII对象包装一对操作
    static class PII {
        int x1, x2;

        PII(int a, int b) {
            x1 = a;
            x2 = b;
        }
    }

    //通过二分查找 当前的下标x的映射为第几个
    static int find(int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x)
                r = mid;
            else
                l = mid + 1;

        }
        return r + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

        //储存 被加下标和数
        for (int i = 0; i < n; ++i) {
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]), c = Integer.parseInt(str[1]);
            alls.add(x);
            adds.add(new PII(x, c));
        }

        //存储查询求和区间
        for (int i = 0; i < m; ++i) {
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]), r = Integer.parseInt(str[1]);
            alls.add(l);
            alls.add(r);
            query.add(new PII(l, r));
        }

        //去重
        alls = new ArrayList<>(new HashSet<>(alls));
        //排序
        Collections.sort(alls);

        a = new int[alls.size()+1];
        s = new int[alls.size()+1];

        //处理插入
        for (PII item : adds) {
            int x = find(item.x1);//找到下标在alls中对应的位置
            a[x] += item.x2;
        }

        //预处理前缀和
        for (int i = 1; i <= alls.size(); ++i) {
            s[i] = s[i - 1] + a[i];
        }

        //处理询问
        for (PII item : query) {
            int l = find(item.x1), r = find(item.x2);
            System.out.println(s[r] - s[l - 1]);
        }

    }

}
