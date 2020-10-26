package com.flouis.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ConcurrentTest {

	@Test
	public void singletonTest(){
		SingletonThread st = SingletonThread.INSTANCE;
		SingletonThread st2 = SingletonThread.INSTANCE;
		System.out.println("st hashCode: " + st.hashCode());
		System.out.println("st2 hashCode: " + st2.hashCode());
		System.out.println("st == st2: " + (st == st2));
	}

	@Test
	public void threadTest() throws Exception{
		long timestamp = System.currentTimeMillis();
		runThreadPool();
		System.out.println((System.currentTimeMillis() - timestamp)/1000 + " sec");

		System.out.println("====================================================");

		long timestamp2 = System.currentTimeMillis();
		runBySequence();
		System.out.println((System.currentTimeMillis() - timestamp2)/1000 + " sec");
	}

	public void runBySequence() throws Exception{
//		Thread.sleep(1000);
//		System.out.println("First");
//		Thread.sleep(2000);
//		System.out.println("Second");
//		Thread.sleep(3000);
//		System.out.println("Third");
//		Thread.sleep(4000);
//		System.out.println("Fourth");

		Thread.sleep(2000);
		System.out.println("First");
		Thread.sleep(2000);
		System.out.println("Second");
		Thread.sleep(2000);
		System.out.println("Third");
		Thread.sleep(2000);
		System.out.println("Fourth");
	}

	public void runThreadPool() throws Exception{
		CountDownLatch countDownLatch = new CountDownLatch(4);
		SingletonThread tp = SingletonThread.INSTANCE;
		tp.startTask(() -> {
			try {
//				Thread.sleep(1000);
				Thread.sleep(2000);
				System.out.println("First");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		tp.startTask(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("Second");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		tp.startTask(() -> {
			try {
//				Thread.sleep(3000);
				Thread.sleep(2000);
				System.out.println("Third");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		tp.startTask(() -> {
			try {
//				Thread.sleep(4000);
				Thread.sleep(2000);
				System.out.println("Fourth");
				countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		countDownLatch.await();
		tp.close();
	}

}
