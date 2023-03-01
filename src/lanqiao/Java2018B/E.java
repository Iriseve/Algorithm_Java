package lanqiao.Java2018B;

import java.util.Random;

/**
 * @ClassName E
 * @Description 快速排序
 * @Author yiling
 * @date 2023/2/12 1:06
 */

//以下代码可以从数组a[]中找出第k小的元素。
public class E {
    public static int quickSelect(int a[], int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l; // 随机找一个幸运的下标所指的数做基准数
        int x = a[p]; //基准数
        //将基准数位置的数和右边界所指的数交换
        int tmp = a[p];
        a[p] = a[r];
        a[r] = tmp;
        //定义双指针
        int i = l, j = r;
        //分区过程
        while (i < j) {
            //左指针所指的值确实小于基准值，左指针右移
            while (i < j && a[i] < x) i++;
            //左指针所指的值不再小于基准值啦，应该把它放到右边去
            if (i < j) {
                a[j] = a[i];
                j--;//目前右指针所指的值一定大于等于索引值，位置肯定对的，把右指针左移一个
            }
            //以下同理
            while (i < j && a[j] > x) j--;
            if (i < j) {
                a[i] = a[j];
                i++;
            }
        }
        //中间值附上基准值（注意这里所指的中间不是数列索引的中间呦 是整个数列数值的中间）
        a[i] = x;
        p = i;//此时基准值下标更新啦，基准值到了正确的位置上（这句代码只是为了代码的可解释性更完整吧，实际应该没什么用hhh）

        //此时的i就是基准值正确位置的下标，所以如果和要求的k一致，那直接返回就好了
        if (i - l + 1 == k) return a[i];

        //此时基准值的位置是小于我们要的k的，所以应该去右边分区找对应的第k小
        //因为我们直接去了右边找，所以对应整个数列的k应该变成右边区间的位置了，就是说左边区域的元素都不需要考虑了
        //所以k-(i-l+1)
        // TODO 填空
        if (i - l + 1 < k) return quickSelect(a, i + 1, r, k - (i - l + 1));
            //这里是基准值位置大于k了，所以去左分区找
        else return quickSelect(a, l, i - 1, k);
    }

    public static void main(String args[]) {
        int[] a = {1, 4, 2, 8, 5, 7};
        System.out.println(quickSelect(a, 0, 5, 4));
    }
}
