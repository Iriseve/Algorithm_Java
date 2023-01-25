package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T787
 * @Description 归并排序
 * @Author yiling
 * @date 2022/12/4 22:05
 */
public class T787 {

    static void mergeSort(int[] q,int l,int r){
        if(l >= r) return; //如果数组里只有一个 直接返回
        int[] temp = new int[r-l+1]; //注意这里不要直接用q数组的长度创建新数组，会TLE
        int mid = l + r >>1;//位运算>>相当于/2

        mergeSort(q,l,mid);//递归排序左边
        mergeSort(q,mid+1,r);//递归排序右边

        //注意以下归并的过程其实就是排序的过程
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r)  //设置区间边界
            if(q[i] <= q[j]) temp[k ++ ] = q[i ++];
            else temp[k ++ ] = q[j ++ ];
        //一个数组遍历完了，直接插入剩下的
        while (i <= mid) temp[k ++ ] = q[i ++ ];
        while (j <= r) temp[k ++ ] = q[j ++ ];
        //复制回原数组
        for(i = l, j = 0; i <= r; i ++, j ++)
            q[i] = temp[j];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] q = new int[n];
        int i;
        for( i = 0;i < n;++i )
            q[i] = Integer.parseInt(s[i]);

        mergeSort(q,0,n-1);

        for( i = 0;i < n;++i)
            System.out.print(q[i] + " ");


    }
}
