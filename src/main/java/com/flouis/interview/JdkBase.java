package com.flouis.interview;

import org.junit.Test;


public class JdkBase {

	@Test
	public void intTest(){
		Integer a = new Integer(3);
		Integer d = new Integer(3);
		Integer b = 3;
		int c = 3;
		System.out.println(a == b); // false
		System.out.println(a == d); // false
		System.out.println(c == b); // true
		System.out.println(a+d);	// 6


		Integer f1 = -128;
		System.out.println("f1 hashCode:" + f1.hashCode());
		Integer f2 = -128;
		System.out.println("f2 hashCode:" + f2.hashCode());
		Integer f3 = 128;
		System.out.println("f3 hashCode:" + f3.hashCode());
		Integer f4 = 128;
		System.out.println("f4 hashCode:" + f4.hashCode());
		Integer f5 = 10000;
		System.out.println("f5 hashCode:" + f5.hashCode());

		System.out.println(f1 == f2); // true
		System.out.println(f3 == f4); // false

	}

	public static void main(String[] args) {
		String a = "Spring";
		System.out.println(a.hashCode()); // -1811812819
		a = "Summer";
		System.out.println(a.hashCode()); // -1807340593

		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(stringBuffer.hashCode()); // 1329552164
		stringBuffer.append("One");
		System.out.println(stringBuffer.hashCode()); // 1329552164

		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(stringBuilder.hashCode()); // 363771819
		stringBuilder.append("Two");
		System.out.println(stringBuilder.hashCode()); // 363771819



	}

}
