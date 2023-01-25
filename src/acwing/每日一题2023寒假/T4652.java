package acwing.每日一题2023寒假;

import java.util.Scanner;

/**
 * @ClassName T4652
 * @Description 纸张尺寸
 * @Author yiling
 * @date 2023/1/6 16:30
 */
public class T4652 {
    static int w = 841;
    static int l = 1189;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(String.valueOf(sc.nextLine().charAt(1)));
        int i;
        for(i=0;i<a;++i){
            if(w>l){
                w=w/2;
            }else {
                l=l/2;
            }
        }
        System.out.println(Math.max(l,w));
        System.out.println(Math.min(l,w));
    }
}
