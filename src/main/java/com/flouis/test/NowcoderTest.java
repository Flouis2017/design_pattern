package com.flouis.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NowcoderTest {

	public static void main(String[] args) {

//		_1();
//		_2();
		String a = "asdfw";
		String b = String.format("%-8s", a).replace(" ", "0");
		System.out.println(b);

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

		if (str.length() > 100){
			str = str.substring(0, 100);
		}
		if (str2.length() > 100){
			str2 = str2.substring(0, 100);
		}

	}

}
