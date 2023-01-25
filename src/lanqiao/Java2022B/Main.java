package lanqiao.Java2022B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * T7测试
 */

public class Main {
	private static long cnt = 0;    //cnt ~ 结果
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i < arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		fun(arr, "", 1);
		System.out.println(cnt % 1000000007);	
	}
    /*
    arr ~ 源数组
    str ~ 获取arr中各元素，并通过增加“，”“；”以分组
    c ~ 层数，判断是否终止调用
    */
	public static void fun(int[] arr,String str,int c) {
		if(c > arr.length) {
			String[] group = str.split(";");	//若干个子数组group
			for(String string : group) {
				String[] nums = string.split(",");	//子数组中包含的各整数nums
				ArrayList<Integer> list = new ArrayList<>();
				for(String num : nums) {
					if(num != "") 
						list.add(Integer.valueOf(num));
				}
				Collections.sort(list);	//排序，以判断是否是“连续的自然数”
				for(int i = 1;i < list.size();i++) {
					if(list.get(i) - list.get(i - 1) != 1) {
						return;	//不符合情况，返回
					}
				}
			}
			cnt++;	//满足题意，结果加一
		}else {
			str += arr[c - 1] + ",";	//获取各整数
			fun(arr, str + ";", c + 1);	//在此处分组，并递归
			if(c != arr.length) {	//当取得最后一个整数时，所谓在此处分组，不分组是同一种情况，故略去其中一个
				fun(arr, str, c + 1);	//在此处不分组，并递归
			}
		}
	}
}
