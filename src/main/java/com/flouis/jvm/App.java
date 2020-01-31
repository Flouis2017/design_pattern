package com.flouis.jvm;

public class App {

	public int add(){
		int a = 1;
		int b = 2;
		int c = a + b;
		return c;
	}

	public static void main(String[] args) {
		App app = new App();
		int res = app.add();
		System.out.println(res);
	}

}


