package com.flouis.test;

import org.junit.Test;

import java.util.Random;

public class RandomTest {

	@Test
	public void randomTest(){
		System.out.println("Test TortoiseGit pull");
		System.out.println(getRandom(1, 10));
	}

	public Integer getRandom(int min, int max){
		Random random = new Random();
		int res = random.nextInt(max) % (max - min + 1) + min;
		return res;
	}

}
