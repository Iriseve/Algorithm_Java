package lanqiao.Java2020B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName G
 * @Description 单词检测
 * @Author yiling
 * @date 2023/1/28 15:45
 */
public class G {
    static int[] num = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
            num[str.charAt(i) - 'a']++;
        }
        int max = 0;
        int flag = 0;
        for (int i = 0; i < 26; ++i) {
            if (num[i] > max) {
                max = num[i];
                flag = i;
            }else if(num[i]==max){
                if(i<flag)
                    flag=i;
            }
        }

        System.out.println((char)(flag+'a'));
        System.out.println(max);
    }
}
