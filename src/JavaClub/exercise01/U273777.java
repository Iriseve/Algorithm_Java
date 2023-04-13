package JavaClub.exercise01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName U273777
 * @Description 024. 字典排列
 * @Author yiling
 * @date 2023/3/25 14:16
 */
public class U273777 {
//    static int[] num = new int[10]; //存放十个数字0~9
//    static boolean[] exist = new boolean[10]; //判断每个数字是否已经存放(默认初始化为false没被存放)
//    static int n = 9;
//    static int flag = 0; //计数器
//    static boolean ok = false;
//
//    static void dfs(int step, long N) {
//        if (flag >= N) {
//            return;
//        }//计数已经完成，后面的就不用走了，直接返回
//
//        //终止条件
//        if (step == n + 1) { //走到最后一个数字啦，搜索结束的标志
//            flag++;
//            if (flag == N) {
//                for (int i = 0; i <= n; i++) {
//                    System.out.print(num[i]);
//                }
//                ok = true;
//                System.out.println();
//            }
//            return;  //返回到上一级
//        }
//
//        for (int i = 0; i <= n; i++) {
//            if (!exist[i]) {
//                num[step] = i;
//                exist[i] = true;
//                dfs(step + 1, N);
//                exist[i] = false;//回溯
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; ++i) {
//            ok = false;
//            flag = 0;
//            int N = Integer.parseInt(br.readLine());
//            dfs(0, N);
//            if (!ok) {
//                System.out.println("WustJavaClub");
//            }
//        }
//    }


//    static int[] flag = new int[10];//标记0~9数字是否已经存在

    //求阶乘
    public static int jiecheng(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    //参数a表示我们需要的是第几个数字
    public static int exist(int a, int[] flag) {
        int f = 0;
        for (int i = 0; i <= 9; i++) {
            if (flag[i] == 0) {
                f++;
                if (f == a) return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int j = 0; j < t; ++j) {
            int[] flag = new int[10];
            int num = Integer.parseInt(br.readLine());
            if (num > 3628800) {
                System.out.println("WustJavaClub");
            } else {
                String x = "";
                int i;
                int q;
                for (i = 9; i >= 0; i--) {
                    int n = jiecheng(i);
                    int a = num / n;
                    int yu = num % n;

                    if (num == 0) {
                        q = exist(1, flag);
                    } else if (yu != 0) {
                        q = exist(a + 1, flag);
                        num -= n * a;
                    } else {
                        q = exist(a, flag);
                        num -= n * (a - 1);
                    }
                    flag[q] = 1;
                    x += q;
                }
                System.out.println(x);
            }
        }
    }
}
