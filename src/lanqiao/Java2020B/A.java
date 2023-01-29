package lanqiao.Java2020B;

/**
 * @ClassName A
 * @Description 门排制作
 * @Author yiling
 * @date 2023/1/27 15:39
 */
public class A {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 2020; ++i) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '2')
                    sum++;
            }
        }
        System.out.println(sum);
    }

}
