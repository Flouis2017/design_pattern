package com.flouis.learning;

public abstract class CatFamily implements Animal {

	public void eat(){
		System.out.println("I can eat!");
	}

	public void move(){
		System.out.println("I can move!");
	}

	public void sleep(){
		System.out.println("I can sleep!");
	}

	public void birth(){
		System.out.println("birth!");
	}

	public CatFamily(){}

}
