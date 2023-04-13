package leetcode.easy;

import java.util.*;

/**
 * @ClassName T2404
 * @Description 2404. 出现最频繁的偶数元素
 * @Author yiling
 * @date 2023/4/13 11:38
 */
public class T2404 {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i :nums){
            if(i%2==0){
                Integer num = map.get(i)==null?1:map.get(i)+1;
                map.put(i,num);
            }
        }
        if(map.size()==0){
            return -1;
        }
//        System.out.println(map);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //自定义排序
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
//        System.out.println(list);
        return list.get(0).getKey();
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,0,0,0,2,4,4,1};
        System.out.println(mostFrequentEven(nums));
    }
}
