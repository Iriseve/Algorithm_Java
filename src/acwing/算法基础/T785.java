package acwing.算法基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @ClassName T785
 * @Description 快速排序模板(主要就是注意边界问题)
 * @Author yiling
 * @date 2022/11/16 19:09
 */
public class T785 {

    static void quick_sort(int[] nums, int l, int r) {
//        Random random = new Random();

//        int nextInt = random.nextInt(r+1); //防止 r = 0的情况
//        int x = nums[nextInt] , i = l-1, j =r + 1;
        int x = nums[(l + r) / 2], i = l - 1, j = r + 1; //因为x取中值也是向下取整 所以还是相当于左边界
        if (l >= r) return;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quick_sort(nums, l, j);
        quick_sort(nums, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int i;
        int[] nums = new int[n];
        for (i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        quick_sort(nums, 0, n - 1);
        System.out.print(nums[0]);
        for (i = 1; i < n; i++) {
            System.out.print(" " + nums[i]);
        }
        br.close();
    }
}
