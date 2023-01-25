package lanqiao.Java2022B;

/**
 * @ClassName T2
 * @Description 山
 * @Author yiling
 * @date 2023/1/6 21:39
 */
public class T2 {
    //有一个坑哈 除了是回文数，还有一个是数字先单调不减，后单调不增
    //也就是12121(奇数位数 无单调性)、2112（先单减后单增）、21122112（偶数位数 无单调性）这类数不允许
    public static void main(String[] args) {
        //当数字是偶数位时，容易得到如果想得到回文数，只要看折半位数就可以了，另一半一定对称
        //2022需要从高位为21开始
        //2022222022折半看高五位中最大为20221
        long sum1=20221-21+1;//偶数位的回文数

        //同理奇数位只要看 位数/2(向下取整)个位数，最中间的任意取（也就是0-9一共有十个）
        long sum2=(9999-10+1)*10;
        System.out.println(sum1+sum2);

    }
}
