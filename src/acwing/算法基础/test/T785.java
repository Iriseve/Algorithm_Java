package acwing.算法基础.test;

/**
 * @ClassName T785
 * @Description 快排测试
 * @Author yiling
 * @date 2022/12/20 23:08
 */
public class T785 {
    static int flag = 1;
    static void quick_sort(int q[],int l,int r){
        if(l >= r) return;//数组只有一个元素时直接返回，不需要排序

        // x 分界点x = q[l+r>>1], x = q[(l+r+1)/2]这里取中间值，向下取整
        //i左指针,j右指针
        int x = q[l+r>>1], i = l-1, j = r+1;
        System.out.println(x);
        while (i < j){

            do i++;while (q[i] < x);
            do j--;while (q[j] > x);

            if(i < j){
                //交换左右指针所指的不满足要求的数
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }

        System.out.print("第" + flag + "次： ");
        for (int k = 0; k <q.length;++k)
            System.out.print(q[k] + " ");
        System.out.println("j = " + j);
        flag++;
        quick_sort(q,l,j);
        quick_sort(q,j+1,r);
    }

    public static void main(String[] args) {
        int [] x = {25,18,9,33,67,82,53,95,12,70};
        quick_sort(x,0,x.length-1);
    }
}
