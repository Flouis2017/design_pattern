package com.flouis.design.pattern.creational.singleton;

/**
 * 懒汉式单例模式：在需要单例对象的时候才会去初始化，即延迟加载。
 * 相比于饿汉式，写法复杂，比较难理解，但可以提高系统性能。
 */
public class LazySingleton {

	private static LazySingleton lazySingleton = null;

	private LazySingleton(){}

	/**
	 * 懒汉式创建单例对象，线程不安全
	 */
	public static LazySingleton getInstance(){
		// 此处就是安全隐患的根本原因。假设线程A执行到lazySingleton = new LazySingleton();但在赋值之前又有一个线程B刚好
		// 执行到if (lazySingleton == null)，因为线程A还没赋值上，所以，这时候lazySingleton==null是成立的，那么线程B
		// 也会执行lazySingleton = new LazySingleton(); 因此单例对象就会被创建两次，违背了单例原则。
		if (lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	/**
	 * 对上述经典懒汉式单例方法进行改进 ———— 使用synchronized关键字将方法变为同步(线程安全)方法，即当一个线程执行到该方法时，
	 * 同步锁开启，防止其他线程执行该方法。
	 */
	public synchronized static LazySingleton getInstanceSynchronously(){
		if (lazySingleton == null){
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	/**
	 * 改进版2:
	 * 在改进版1中使用synchronized关键字规避了线程安全的问题，但同步写在一个static方法的声明上，那么同步锁在锁住方法的同时也会锁住这个类，
	 * 此时这个类的其他方法或属性，就会由于同步锁而无法被调用，类的性能将被极大地削弱。
	 * 那么有没有一个种兼顾线程安全和性能的改进，答案是有的，我们使用“双重检查”来进行改进，具体细节参见LazyDoubleCheckSingleton.java
	 */

}
