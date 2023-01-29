package lanqiao.Java2020B;

/**
 * @ClassName D
 * @Description 七段码
 * @Author yiling
 * @date 2023/1/27 16:26
 */
public class D {

    /**
     * 枚举，dfs+并查集（判断上是否连通）
     * 非常麻烦，对于一道填空题来说
     * 看不懂可以去看看这个视频或许有点帮助~
     * https://www.bilibili.com/video/BV1KY411h7aX
     */
    static int res;
    static int[][] e = new int[7][7];//相邻边
    static boolean[] light = new boolean[7];//灯是否被点亮
    static int[] foot = new int[7];//7个结点的根节点

    //并查集核心操作
    //初始化根节点，每个点自成一个连通分支
    static void init() {
        for (int i = 0; i < 7; ++i) {
            foot[i] = i;
        }
    }

    //寻找x的根节点
    static int find(int x) {
        if (foot[x] == x) return x;
        return find(foot[x]);
    }

    //合并两个单独分支为一个连通分支
    static boolean join(int x, int y) {
        x = find(x); //寻找x的根节点
        y = find(y); //寻找y的根节点
        if (x == y) return false;//两个点已经被接入连通分支，不需要处理
        else {
            foot[x] = y;
        }
        return true;
    }

    //判断点亮的灯是否是连通分支
    //now表示当前点亮的灯，num表示点亮的灯的编号
    static boolean judge(int[] now, int num) {
        int e_count = num - 1;//如果是连通的情况，那么需要建立边的个数应该等于灯数-1
        init(); //初始化并查集

        //这里注意一下查的是now这个表里的数哈，i、j只是索引
        for (int i = 0; i < num - 1; ++i) {
            for (int j = i + 1; j < num; ++j) { //这里就不用每次从0开始了，e[0][1]和e[1][0]都是在检查相同的灯
                if (e[now[i]][now[j]] == 1) { //表示相邻，可以简历边
                    if (join(now[i],now[j])) //建立新边成功
                        e_count--;
                }
            }
        }
        if (e_count == 0) return true;
        return false;
    }

    //编号num 0，灯max -1
    //num表示当前搜索到的编号，record表示目前记录在册点亮的灯
    static void dfs(int num, int max, int[] record) {
        if(judge(record,num)) res++;

        //这里终止条件就是i到7，这里用循环表示而已，意义上和单独写一个判断是一样的。
        for (int i =max+1;i<7;++i){
            if(!light[i]){
                light[i]=true;
                record[num]=i;//编号为num的灯是i
                dfs(num+1,i,record);
                //record不用还原，下一次会直接覆盖
                light[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        //初始化相邻的边
        e[0][1]=e[0][5]=1;
        e[1][0]=e[1][6]=e[1][2]=1;
        e[2][1]=e[2][6]=e[2][3]=1;
        e[3][4]=e[3][2]=1;
        e[4][5]=e[4][6]=e[4][3]=1;
        e[5][0]=e[5][6]=e[5][4]=1;
        e[6][1]=e[6][4]=e[6][2]=e[6][5]=1;

        int[] record = new int[7];
        dfs(0,-1,record);
        System.out.println(res);
    }


    /**
     * 位运算（判断灯是否亮）模拟+观察排除
     */
//    public static void main(String[] args) {
//        int cnt = 1;
//        //一共有2^7-1中亮灯可能
//        for (int x = 1; x <= 127; x ++)
//        {
//            System.out.println("===="+(cnt ++)+"====");
//            //判断第i-1灯是否亮
//            for (int i = 0; i < 7; i ++)
//            {
//                if(i == 0)
//                {
//                    if((x >> i & 1)==1) System.out.print(" --");
//                    System.out.println();
//                }
//                if(i == 1)
//                {
//                    if((x >> i & 1)==1) System.out.print('|');
//                    else System.out.print(" ");
//                }
//                if(i == 2)
//                {
//                    if((x >> i & 1)==1) System.out.print("  |");
//                    System.out.println();
//                }
//                if(i == 3)
//                {
//                    if((x >> i & 1)==1) System.out.print(" --");
//                    System.out.println();
//                }
//                if(i == 4)
//                {
//                    if((x >> i & 1)==1) System.out.print('|');
//                    else System.out.print(" ");
//                }
//                if(i == 5)
//                {
//                    if((x >> i & 1)==1) System.out.print("  |");
//                    System.out.println();
//                }
//                if(i == 6)
//                {
//                    if((x >> i & 1)==1) System.out.print(" --");
//                    System.out.println();
//                }
//            }
//            System.out.println();
//        }
//    }

}
