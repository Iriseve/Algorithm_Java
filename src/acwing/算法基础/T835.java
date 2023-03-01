package acwing.算法基础;

import java.util.Scanner;

/**
 * @ClassName T835
 * @Description Trie字符串统计
 * @Author yiling
 * @date 2023/2/26 21:28
 */
public class T835 {
    static int N = 100000; //字符串长度
    static int[][] son = new int[N][26]; //表示某个结点的子节点
    static int[] cnt = new int[N]; //记录字符串终结点，其下标表示终结点
    static int idx; //idx是结点分配器，始终递增

    //存储字符串
    //son[p][num]表示第p个结点的子节点是num,其值表示这个子节点的结点编号
    static void insert(String s) {
        int p = 0;//初始从根节点开始走，这里根节点是空结点，这个也可以看作第0号结点
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a';
            //结点不存在，则创建新节点
            if (son[p][num] == 0) {
                son[p][num] = ++idx; //分配新结点号
            }
            p = son[p][num]; //指向该新节点
        }
        cnt[p]++; //给终结点赋个值，表示记录的第几个终结点
    }

    //查询字符串
    static int query(String s) {
        int p = 0; //从根节点开始查
        for (int i = 0; i < s.length(); ++i) {
            int num = s.charAt(i) - 'a';
            if (son[p][num] == 0) {
                return 0; //如果该节点不存在，那么不用往下走了，这个子串一定不存在
            }
            //存在，找下一个结点
            p = son[p][num];
        }
        return cnt[p]; //该字符串走完了，去查终结点存不存在，如果为0就是不存在
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- != 0) {
            String action = sc.next();
            String str = sc.next();
            if ("I".equals(action)) {
                insert(str);
            } else {
                System.out.println(query(str));
            }
        }
    }
}
