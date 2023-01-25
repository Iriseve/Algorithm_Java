package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName powMod
 * @Description
 * @Author yiling
 * @date 2022/11/28 15:43
 */
public class powMod {
    public static long pow_MOD(long a ,long b,long MOD){
        a=a % MOD;
        long result=1;
        for(;b != 0; b = b>>1){
            if((b&1)==1) result = result * a % MOD;
            a=a*a % MOD;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            String[] s = br.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            long p = Long.parseLong(s[2]);
            System.out.println(pow_MOD(a,b,p));
        }

    }
}
