package lanqiao.Java2022B;

import java.util.*;

/**
 * @ClassName T3
 * @Description 字符统计
 * @Author yiling
 * @date 2023/1/6 23:04
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i;
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (i = 0; i < s.length(); ++i) {
            String s1 = String.valueOf(s.charAt(i));
            Integer count = map.get(s1);
            if (count != null) {
                map.put(s1, ++count);
            } else
                map.put(s1, 1);
        }

        // 降序比较器
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                return o2.getValue() - o1.getValue();
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, valueComparator);
        Map.Entry<String, Integer> entry1 = list.get(0);
        Integer value = entry1.getValue();
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue().equals(value)) {
                System.out.print(entry.getKey());
            } else
                break;
        }
    }
}
