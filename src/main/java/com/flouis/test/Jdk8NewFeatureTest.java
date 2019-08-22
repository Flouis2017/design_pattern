package com.flouis.test;

import com.alibaba.fastjson.JSONObject;
import com.flouis.entity.jdk8NewFeature.Stationery;
import com.flouis.entity.jdk8NewFeature.Student;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Jdk8NewFeatureTest {

	@Test
	public void test(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("string", "xxxxxxyyyy");
		System.out.println(jsonObject.toJSONString());
	}

	@Test
	public void optionalTest(){
		List<Student> studentList = Lists.newArrayList(
			new Student("1001", "小明", "男", 18, Stationery.getDefaultList(2)),
			new Student("1002", "小红", "女", 17, Stationery.getDefaultList(1)),
			new Student("1003", "小美", "女", 16, Stationery.getDefaultList(3))
		);

//		System.out.println(studentList.toString());

		Optional.ofNullable(studentList).orElse(Collections.emptyList())
				.forEach(System.out::println);

	}

}
