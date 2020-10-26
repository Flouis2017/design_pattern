package com.flouis.design.pattern.creational.singleton;

/**
 * 饿汉式单例模式：在类加载的时候就初始化单例对象，不进行延迟加载。
 * 相比于懒汉式，通俗易懂，而且是线程安全的(因为实例必须在类加载完成后才能获取，而饿汉式的单例对象就是在类加载时一并完成的)
 * 但由于饿汉式这种“不用也会初始化单例对象”，所以当该单例对象占用较大资源时就会消耗系统整体性能。
 */
public class HungrySingleton {

	// 这里使不使用final关键字根据具体情况而定，如果可以很确定该单例对象是不可修改的，就加上final
	private final static HungrySingleton hungrySingleton;

	// 把单例对象初始化放在静态代码块中可以先于其他成员变量执行，提高效率，实际上和直接初始化没什么差别~
	static {
		hungrySingleton = new HungrySingleton();
	}

	private HungrySingleton(){}

	public static HungrySingleton getInstance(){
		return hungrySingleton;
	}

}
