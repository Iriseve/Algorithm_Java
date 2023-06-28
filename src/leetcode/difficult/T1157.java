package leetcode.difficult;

/**
 * @ClassName T1157
 * @Description 子数组中占绝大多数的元素
 * @Author yiling
 * @date 2023/4/16 20:22
 */
public class T1157 {
    /**
     * 暴力计数器
     */
    class MajorityChecker {
        private int[] b;

        public MajorityChecker(int[] arr) {
            b = new int[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                b[i] = arr[i];
            }
        }

        public int query(int left, int right, int threshold) {
            int[] a = new int[2 * 10000 + 5];
            int max = 0;
            for (int i = left; i <= right; ++i) {
                if (b[i] > max) {
                    max = b[i];
                }
                a[b[i]]++;
            }
            for (int i = 0; i < max+2; ++i){
                if(a[i]>=threshold){
                    return i;
                }
            }
            return -1;
        }
    }
}
