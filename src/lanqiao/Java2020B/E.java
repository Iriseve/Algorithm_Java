package lanqiao.Java2020B;

/**
 * @ClassName E
 * @Description 排序
 * @Author yiling
 * @date 2023/1/27 18:15
 */
public class E {
    /**
     * 人脑推测
     */
    //冒泡排序（升序），每一轮排序将最大的那个放最后面
    //所以对于同一序列，完全倒序所交换的次数一定是最多的。
    //冒牌排序最多交换次数（完全倒序的情况下）为
    // (N-1)+(N-2)+...+1=N*(N-1)/2次
    //当交换次数为100时，至少需要15个字母即onmlkjihgfedcba
    //但15个字母完全乱序交换次数为105次，多了5次
    //怎么才能不交换呢？那就是正序满足规律的时候可以不交换了。这样的情况有很多，但想要字典序最小，就最好改变首字母。
    //所以把第6个字母拿到最前面，即jonmlkihgfedcba。
    //在这种情况下，j在前5轮都是不会动的，即减少了五次交换。
    public static void main(String[] args) {
        System.out.println("jonmlkihgfedcba");
    }

}
