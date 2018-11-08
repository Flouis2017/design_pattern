package com.flouis.design.pattern.creational.singleton;

public class LazySingleton {

	private static LazySingleton lazySingleton = null;

	private LazySingleton(){}

	/**
	 * 懒汉式创建单例对象，线程不安全
	 */
	public static LazySingleton getInstance(){
		// 此处就是安全隐患的根本原因。假设线程A执行到lazySingleton = new LazySingleton();但在赋值之前又有一个线程B刚好
		// 执行到if (lazySingleton == null)，因为线程A还没赋值上，所以，这时候lazySingleton==null是成立的，那么线程B
		// 也会执行lazySingleton = new LazySingleton(); 最后单例对象是线程B执行lazySingleton = new LazySingleton();
		// 生成出来的单例对象，即线程B创建的单例对象覆盖了线程A创建的单例对象，但是单例对象被创建了两次，违背了单例原则。
		if (lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}
