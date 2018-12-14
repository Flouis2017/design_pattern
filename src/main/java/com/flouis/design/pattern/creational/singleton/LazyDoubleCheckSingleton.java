package com.flouis.design.pattern.creational.singleton;

/**
 * @author Flouis
 * @date 2018/11/09
 * @description
 **/
public class LazyDoubleCheckSingleton {

	private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;
	private LazyDoubleCheckSingleton(){}

	public static LazyDoubleCheckSingleton getInstance(){
		if (lazyDoubleCheckSingleton == null){
			synchronized (LazyDoubleCheckSingleton.class){
				if (lazyDoubleCheckSingleton == null){
					lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
				}
			}
		}
		return lazyDoubleCheckSingleton;
	}

}
