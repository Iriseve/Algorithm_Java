package leetcode.medium;

import java.util.HashMap;

/**
 * @ClassName week1
 * @Description
 * @Author yiling
 * @date 2022/10/30 13:31
 */

public class T03 {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int length = s.length();
        int start = 0;
        int end = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<length;i++){
            if(!map.containsKey(s.charAt(i))){//没出现过
                map.put(s.charAt(i),i);
                end++;
            }else{
                if(map.get(s.charAt(i))<start){//是在前一个重复值之前的 不需要管
                    map.put(s.charAt(i),i);
                    end++;
                }else{
                    len = Math.max(len,end-start+1);
                    end++;
                    start = map.get(s.charAt(i))+1;
                    map.put(s.charAt(i),i);//覆盖旧值
                }
            }
        }
        return len;
    }
}
