package leetcode.easy;

/**
 * @ClassName easy.T13
 * @Description
 * @Author yiling
 * @date 2022/11/10 15:24
 */
public class T13 {
    public int find(char s){
        int str = 0;
        switch (s){
            case 'I': str = 1;break;
            case 'V': str = 5;break;
            case 'X': str = 10;break;
            case 'L': str = 50;break;
            case 'C': str = 100;break;
            case 'D': str = 500;break;
            case 'M': str = 1000;break;
        }
        return  str;
    }
    public int romanToInt(String s) {
        int num=0;//最大为15*1000
        int[] str = new int[15];
        int i;
        for(i = 0;i<s.length();){
            if (s.charAt(i) == 'I' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'V') {
                    str[i] = 4;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'X') {
                    str[i] = 9;
                    i = i + 2;
                } else {
                    str[i] = find(s.charAt(i));
                    i++;
                }
            } else if (s.charAt(i) == 'X' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'L') {
                    str[i] = 40;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'C') {
                    str[i] = 90;
                    i = i + 2;
                } else {
                    str[i] = find(s.charAt(i));
                    i++;
                }
            }  else if (s.charAt(i) == 'C' && i != s.length() - 1) {
                if (s.charAt(i + 1) == 'D') {
                    str[i] = 400;
                    i = i + 2;
                } else if (s.charAt(i + 1) == 'M') {
                    str[i] = 900;
                    i = i + 2;
                } else {
                    str[i] = find(s.charAt(i));
                    i++;
                }
            } else {
                str[i] = find(s.charAt(i));
                i++;
            }

        }
        for (i = 0; i<s.length();++i){
            num += str[i];
        }
        return num;
    }
}
