package com.flouis.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Optimus Prime", 30);
		Person.title = "Warrior";
		try {
			System.out.println("before--> " + person.toString());
			test(person);
			System.out.println("after--> " + person.toString());
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void test(Object object) throws Exception{
		Class c = object.getClass();
		if ("com.flouis.reflection.Person".equals(c.getName())){
			// getField获取映射类中公有属性
			Field title = c.getField("title");
			System.out.println(title.get(object));
			title.set(object, "Scout");

			// getDeclaredField获取映射类中声明的属性——包括公有私有
			Field age = c.getDeclaredField("age");
			age.setAccessible(true);
			System.out.println(age.get(object));

			// getMethod获取映射类中公有方法
			Method setName = c.getMethod("setName", String.class);
			setName.invoke(object, "Bumble Bee");
			Method setAge = c.getMethod("setAge", Integer.class);
			setAge.invoke(object, 25);

			Method sayHello = c.getDeclaredMethod("sayHello");
			sayHello.setAccessible(true);
			sayHello.invoke(object);

			// 获取映射类注解
			Class cc = c.getDeclaredAnnotation(MyAnno.class).annotationType();
//			Method showMyName = cc.getDeclaredMethod("myName");
			Method showMyName = cc.getMethod("myName");
			System.out.println("MyAnno myName: " + showMyName.getDefaultValue());

			Field name = c.getDeclaredField("name");
			name.setAccessible(true);
			String myName = name.getDeclaredAnnotation(MyAnno.class).myName();
			System.out.println("MyAnno myName: " + myName);
		}
	}

}
