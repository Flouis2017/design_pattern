package com.flouis.test;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

	@Test
	public void bigDecimalTest(){
		BigDecimal bigDecimal = new BigDecimal("0.99");
		System.out.println(bigDecimal);
		System.out.println(bigDecimal.intValue());
	}

}
