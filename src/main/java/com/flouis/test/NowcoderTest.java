package com.flouis.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NowcoderTest {

	public static void main(String[] args) {

//		_1();
//		_2();
//		_3();
//		_4();
//		_5(); // $bo*y gi!r#l # --》 l r gi y bo
//		String a = "123456789";
//		String b = String.format("%-8s", a).replace(" ", "0");
//		System.out.println(__3(a));
	}

	// 字符串最后一个单词的长度
	public static void _1 (){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String [] arr = str.split("\\s+");
		System.out.println(arr[arr.length - 1].length());
	}

	// 计算字符个数
	public static void _2(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		char ch = sc.nextLine().toUpperCase().charAt(0);
		char[] chArr = str.toCharArray();
		int cnt = 0;
		for (char x : chArr){
			if (x == ch){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	// 字符串分隔
	public static void _3(){
		List<String> resList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String str2 = sc.nextLine();
		resList.addAll(__3(str));
		resList.addAll(__3(str2));
		for (String x : resList){
			System.out.println(x);
		}
	}

	public static List<String> __3(String str){
		List<String> list = new ArrayList<>();
		int len = str.length();
		if (len == 0){
			return list;
		}
		if (len > 100){
			str = str.substring(0, 100);
		}
		int num = len / 8;
		int offNum = len % 8;
		for (int i = 0; i < num; i++){
			list.add(str.substring(i*8, (i+1)*8));
		}
		if (offNum >= 1){
			String lastSubStr = str.substring(num*8, len);
			lastSubStr = String.format("%-8s", lastSubStr).replace(" ", "0");
			list.add(lastSubStr);
		}
		return list;
	}

	// 字符串反转
	public static void _4(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] chArr = str.toCharArray();
		for (int i = chArr.length - 1; i >= 0; i--){
			System.out.print(chArr[i]);
		}
	}

	// 【中级】单词倒排
	public static void _5(){
		Scanner sc = new Scanner(System.in);
		String res = "";
		String[] strArr = sc.nextLine().trim().split("[^a-zA-Z]");
		for (int i=strArr.length - 1; i >= 0; i--){
			res += strArr[i] + " ";
		}
		res = res.trim();
		System.out.println(res);
	}

}
