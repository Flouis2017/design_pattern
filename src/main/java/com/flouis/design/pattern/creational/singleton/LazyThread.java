package com.flouis.design.pattern.creational.singleton;

public class LazyThread implements Runnable {

	public void run(){
//		LazySingleton lazySingleton = LazySingleton.getInstance();
//		LazySingleton lazySingleton = LazySingleton.getInstanceSynchronously();
		LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
		System.out.println(Thread.currentThread().getName() + ": " + lazySingleton);
	}

}
