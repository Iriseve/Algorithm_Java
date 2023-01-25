package others;

/**
 * @ClassName SequentialSearch
 * @Description 顺序查找
 * @Author yiling
 * @date 2022/12/3 13:44
 */
public class SequentialSearch {
    //查找成功返回下标，查找失败返回-1

    //两次判断
    public static int searchKey(int []a,int key){
        int i;
        for(i=a.length-1 ;i >= 0 && a[i] != key ;--i);
        if(i>=0) return i;
        else return -1;
    }

    //增加监视哨，减少判断，用空间换时间
    public static int searchKey2(int []a,int key){
        int i;
        int[] b = new int[a.length + 1];
        b[0] = key;//监视哨

        int j = 1;
        for(i=0;i<a.length;++i){
            b[j] = a[i];
            j++;
        }

        for(i=a.length;b[i] != key;--i);
        return i-1;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();     //获取开始时间

        int []a = {0,1,2,10,3};
        int result = searchKey(a,15);
        //int result = searchKey2(a,15);
        System.out.println(result);

        long overTime = System.nanoTime();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"纳秒");

    }
}
