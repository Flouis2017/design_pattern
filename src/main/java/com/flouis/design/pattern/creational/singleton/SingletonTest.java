package com.flouis.design.pattern.creational.singleton;

import org.junit.Test;

public class SingletonTest {

	@Test
	public void test() {

		// 主线程main(单线程)，进行懒汉式创建单例对象
//		LazySingleton lazySingleton = LazySingleton.getInstance();
//		System.out.println(Thread.currentThread().getName() + ": " + lazySingleton);

		Thread t1 = new Thread(new SingletonThread());
		Thread t2 = new Thread(new SingletonThread());
		t1.start();
		t2.start();
		System.out.println("lazy singleton test.");

	}

	@Test
	public void test2(){
		HungrySingleton one = HungrySingleton.getInstance();
		HungrySingleton two = HungrySingleton.getInstance();
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		System.out.println(one == two);
		System.out.println(one.equals(two));
		System.out.println("========================================================\n");

		StringBuilder asb = new StringBuilder("xxx");
		StringBuilder bsb = new StringBuilder("xxx");
		System.out.println(asb.hashCode());
		System.out.println(bsb.hashCode());
		System.out.println(asb == bsb);
		System.out.println(asb.equals(bsb));
		System.out.println("========================================================\n");

		String astr = new String("hello");
		String bstr = new String("hello");
		System.out.println(astr.hashCode());
		System.out.println(bstr.hashCode());
		System.out.println(astr == bstr);
		System.out.println(astr.equals(bstr));
		System.out.println("========================================================\n");

		Integer ai = new Integer(100000);
		Integer bi = new Integer(100000);
		System.out.println(ai.hashCode());
		System.out.println(bi.hashCode());
		System.out.println(ai == bi);
		System.out.println(ai.equals(bi));
	}

}
