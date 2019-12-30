package com.flouis.reflection;

@MyAnno
public class Person {

	@MyAnno(myName = "bb")
	private String name;
	private Integer age;

	public static String title = "Null";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(){}

	public Person(String name, Integer age){
		this.setName(name);
		this.setAge(age);
	}

	private String sayHello(){
		System.out.println("Hello!");
		return "Hello!";
	}

	public String toString(){
		return "Person: { name: " + this.name + ", age: " + this.age + ", title: " + title + " }";
	}

}
