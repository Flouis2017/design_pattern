package com.flouis.design.pattern.creational.singleton;

/**
 * 静态内部类单例模式
 * 和Double Check一样都是做延迟加载初始化来降低创建单例实例的开销
 */
public class StaticInnerClassSingleton {

	private StaticInnerClassSingleton(){}

	private static class InnerClass{
		private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
	}

	public static StaticInnerClassSingleton getInstance(){
		return InnerClass.staticInnerClassSingleton;
	}

}
