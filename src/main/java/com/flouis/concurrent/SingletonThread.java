package com.flouis.concurrent;

import java.util.concurrent.*;

public enum SingletonThread {

	INSTANCE;

	ExecutorService service;

	SingletonThread(){
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
