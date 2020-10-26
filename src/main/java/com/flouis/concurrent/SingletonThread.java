package com.flouis.concurrent;

import java.util.concurrent.*;

/**
 * @description 使用枚举实现单例 —— 其实就是饿汉式的变相写法，因为enum关键字声明的类，即枚举类默认的构造方法就是private的，
 * 并且枚举常量（饿汉式中的单例对象）自带了public static。
 */
public enum SingletonThread {

	INSTANCE; // 单例对象

	private ExecutorService service;

	// redundant [rɪˈdʌndənt] adj. 多余的，过剩的；被解雇的，失业的；冗长的，累赘的 【有道词典】
	private SingletonThread(){
		init();
	}

	private void init(){
		service = new ThreadPoolExecutor(0, 8, 0L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
	}

	public <T> Future<T> startTask(Callable<T> task){
		return this.service.submit(task);
	}

	public <T> Future<T> startTaskSleep(Callable<T> task){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		return this.service.submit(task);
	}

	public <T> Future<T> startTask(Runnable task, T t){
		return this.service.submit(task, t);
	}

	public void startTask(Runnable task){
		this.service.submit(task);
	}

	public void close(){
		synchronized (service){
			if (service != null){
				this.service.shutdown();
			}
		}
	}


}
