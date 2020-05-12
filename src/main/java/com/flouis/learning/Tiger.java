package com.flouis.learning;

public class Tiger extends CatFamily{

	public void eat(){
		System.out.println("I'm tiger, I can eat~");
	}

	public void birth(){
		System.out.println("give birth to baby tiger~");
	}

	public static void main(String[] args) {
		Tiger tiger = new Tiger();
		tiger.birth();
		tiger.eat();
		tiger.move();
		tiger.sleep();

		System.out.println("=========================");

		Animal tiger2 = new Tiger();
		tiger2.birth();
		tiger2.eat();
		tiger2.move();
		tiger2.sleep();
	}

}
