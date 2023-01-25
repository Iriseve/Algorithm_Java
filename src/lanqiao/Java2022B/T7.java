package lanqiao.Java2022B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName T7
 * @Description 数组切分
 * @Author yiling
 * @date 2023/1/10 14:46
 */
public class T7 {
    static int []arr;
    static int N;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        arr = new int[N+1];
        int[] f = new int[N + 1];//记录切分数组的情况
        String[] s = br.readLine().split(" ");
        for(int i =1;i<=N;++i){
            arr[i]=Integer.parseInt(s[i-1]);
        }

        f[0] = 1;//通过f[0]初始化

        int max,min;


        for(int i =1;i<=N;++i){
            max=min=arr[i];
            for(int j=i;j>=1;--j){
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);

                //f[i]表示前i个数的切分情况！！注意是前面所有数的切分情况总和！！
                //如果[j,i]内元素连续，那么对当前f[i]进行状态更新
                if((max-min)==(i-j)){
                    f[i]=(f[i]+f[j-1])%MOD;
                }
            }
        }
        System.out.println(f[N]);
    }




       //非正解！！！
//    //判断[l,r]内元素是否连续
//    public static boolean check(int l,int r){
//        int[] a = new int[r - l + 1];
//        int len = r-l+1;
//        for(int i=0;i<len;++i){
//            a[i]=arr[l++];
//        }
//        Arrays.sort(a);
//        for(int i=1;i<a.length;++i){
//            if(a[i]>(a[i-1]+1)) return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        arr = new int[n];
//        String[] s = br.readLine().split(" ");
//        for(int i=0;i<n;i++){
//            arr[i]=Integer.parseInt(s[i]);
//        }
//
//        int res=0;
//        for(int l=0;l<n-1;++l){
//            for(int r=l+1;r<n;++r){
//                if(check(l,r)) {
//                    res++;
//                }
//            }
//        }
//        System.out.println((res+1)%1000000007);
//    }
}
