package com.flouis.design.pattern.creational.singleton;

public class SingletonThread implements Runnable {

	public void run(){
//		LazySingleton lazySingleton = LazySingleton.getInstance();
//		LazySingleton lazySingleton = LazySingleton.getInstanceSynchronously();
//		LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
//		StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
		HungrySingleton instance = HungrySingleton.getInstance();
		System.out.println(Thread.currentThread().getName() + ": " + instance);
	}

}
