package com.flouis.design.pattern.creational.singleton;

public class SingletonTest {

	public static void main(String[] args) {

		// 主线程main(单线程)，进行懒汉式创建单例对象
//		LazySingleton lazySingleton = LazySingleton.getInstance();
//		System.out.println(Thread.currentThread().getName() + ": " + lazySingleton);

		Thread t1 = new Thread(new SingletonThread());
		Thread t2 = new Thread(new SingletonThread());
		t1.start();
		t2.start();
		System.out.println("lazy singleton test.");

	}

}
