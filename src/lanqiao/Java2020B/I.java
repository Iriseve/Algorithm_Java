package lanqiao.Java2020B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;

/**
 * @ClassName I
 * @Description 子串分值和
 * @Author yiling
 * @date 2023/1/28 17:11
 */
public class I {

    /**
     *继续暴力，过了6个
     */
    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        tokenizer.nextToken();
        String str = tokenizer.sval;
        long num = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0;i<str.length();++i){
            hashSet.clear();
            for (int j = i;j<str.length();++j){
                hashSet.add(str.charAt(j));
                num +=hashSet.size();
            }
        }
        System.out.println(num);
    }
}
