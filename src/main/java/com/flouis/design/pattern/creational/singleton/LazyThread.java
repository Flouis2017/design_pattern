package com.flouis.design.pattern.creational.singleton;

public class LazyThread implements Runnable {

	public void run(){
		LazySingleton lazySingleton = LazySingleton.getInstance();
		System.out.println(Thread.currentThread().getName() + ": " + lazySingleton);
	}

}
