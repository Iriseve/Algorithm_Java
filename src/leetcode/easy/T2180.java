package leetcode.easy;

/**
 * @ClassName T2180
 * @Description
 * @Author yiling
 * @date 2023/1/6 13:23
 */
public class T2180 {
    public int sum(int x){
        int sum=0;
        while(x!=0){
            sum+= x%10;
            x=x/10;
        }
        return sum;
    }
    public int countEven(int num) {
        int res=0;
        int a;
        for(int i=1;i<=num;++i){
            a=sum(i);
            if(a%2==0)
                res++;
        }
        return res;
    }
}
