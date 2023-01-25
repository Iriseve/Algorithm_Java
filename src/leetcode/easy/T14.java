package leetcode.easy;

/**
 * @ClassName easy.T14
 * @Description
 * @Author yiling
 * @date 2022/11/11 16:49
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder();
        int size = strs.length;
        int i,j,flag = 0,e = 1;
        String builder = strs[0];
        for(i = 1;i<size;++i){
            if(strs[i].length()<builder.length())
                builder = strs[i];
        }
        for(i = 0;i<builder.length();++i){
            for(j = 0;j<size;++j){
                if(strs[0].charAt(i)!=strs[j].charAt(i)){
                    e = 0;break;
                }
            }
            if(e==0){
                break;
            }else{
                flag++;
            }
        }
        for(i = 0;i<flag;++i){
            str.append(strs[0].charAt(i));
        }
        return String.valueOf(str);
    }
}
