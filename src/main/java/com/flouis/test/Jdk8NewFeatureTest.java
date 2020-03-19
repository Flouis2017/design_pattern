package com.flouis.test;

import com.alibaba.fastjson.JSONObject;
import com.flouis.entity.jdk8NewFeature.Employee;
import com.flouis.entity.jdk8NewFeature.Stationery;
import com.flouis.entity.jdk8NewFeature.Student;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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

	private List<Student> getDefaultStudentList(){
		Student s1 = new Student("1001", "莫颜静", "女", 21);
		Student s2 = new Student("1002", "徐上灵", "男", 22);
		Student s3 = new Student("1003", "杨环玉", "女", 20);
		Student s4 = new Student("1004", "范千哲", "男", 25);
		Student s5 = new Student("1005", "刘近民", "男", 26);
		List<Student> studentList = Lists.newArrayList();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		return studentList;
	}

	// 筛选
	private void filterTest(){
		List<Student> studentList = getDefaultStudentList();
		// 删选出女学生：
		List<Student> femaleStudentList = studentList.stream().filter(s -> "女".equals(s.getSex())).collect(Collectors.toList());
		femaleStudentList.forEach(System.out::println);
	}

	// 简单去重
	private void distinctTest(){
		List<String> list = Arrays.asList("111", "222", "333", "111", "333");
		System.out.println(list);
		System.out.println("==============================================");
		list = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list);
	}

	// 对象去重：对象去重必须对(对象)对应的类重写equals和hashCode方法，否则去重是无效的
	private void distinctTest2(){
		try {
			List<Student> studentList = getDefaultStudentList();
			BeanUtils.copyProperties(studentList.get(0), studentList.get(studentList.size() - 1));
			System.out.println(studentList);
			System.out.println("==============================================");
			studentList = studentList.stream().distinct().collect(Collectors.toList());
			System.out.println(studentList);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	// 简单排序
	private void sortTest(){
//		List<Integer> list = Arrays.asList(132, 123, 321, 213, 231, 123);
		List<String> list = Arrays.asList("132", "123", "321", "213", "231", "123");
		System.out.println(list);
		System.out.println("==============================================");
		list = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list);
	}

	// 对象排序
	private void sortTest2(){
		List<Student> studentList = getDefaultStudentList();
		studentList.get(studentList.size() - 1).setAge(16);
		System.out.println(studentList);
		System.out.println("==============================================");
		studentList = studentList.stream()
//				.sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
				.sorted(Comparator.comparingInt(Student::getAge))
				.collect(Collectors.toList());
		System.out.println(studentList);
	}

	// 限制返回个数
	private void limitTest(){
		List<String> list = Arrays.asList("wqer", "asdf", "zxcv");
		System.out.println(list);
		System.out.println("==============================================");
		list = list.stream().limit(2).collect(Collectors.toList());
		System.out.println(list);
	}

	// 忽略前n个元素
	private void skipTest(){
		List<Student> studentList = getDefaultStudentList();
		System.out.println(studentList);
		System.out.println("==============================================");
		List<Student> list = studentList.stream().skip(studentList.size() - 1).collect(Collectors.toList());
		System.out.println(studentList);
		System.out.println(list);
	}

	public Employee toEmployee(Student student){
		Employee employee = new Employee();
		try {
			BeanUtils.copyProperties(employee, student);
		} catch (Exception e){
			e.printStackTrace();
		}
		return employee;
	}

	/*public Employee toEmployee(Student student){
		Employee employee = new Employee();
		employee.setName(student.getName());
		employee.setSex(student.getSex());
		employee.setAge(student.getAge());
		return employee;
	}*/

	// 对象流转换
	private void convertListTest(){
		try {
			List<Student> studentList = getDefaultStudentList();
			System.out.println(studentList);
			System.out.println("==============================================");
			List<Employee> employeeList = studentList.stream().map(s -> toEmployee(s)).collect(Collectors.toList());
			System.out.println(employeeList);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	// 聚合/压缩
	private void reduceTest(){
		List<Student> studentList = getDefaultStudentList();

		// stream().map()可以将一个对象流转为另一个对象流，如下面就是将List<Student>转为了List<String>
		List<String> nameList = studentList.stream().map(s -> s.getName() + " ").collect(Collectors.toList());

		System.out.println(nameList);
		String str = nameList.stream().reduce("学生：", (a, b) -> a + b).trim();
		System.out.println(str);
	}

	// 最小值，最大值同理把stream().min()换成stream().max()即可
	private void minTest(){
		List<Student> studentList = getDefaultStudentList();
		System.out.println(studentList);
		System.out.println("==============================================");
		Student minStudent = studentList.stream()
//				.min((a, b) -> Integer.compare(a.getAge(), b.getAge()))
				.min(Comparator.comparingInt(Student::getAge))
				.get();
		System.out.println(minStudent);
	}

	// 匹配：anyMatch/allMatch/noneMatch
	private void matchTest(){
		List<Student> studentList = getDefaultStudentList();
		boolean anyMatch = studentList.stream().anyMatch(s -> "女".equals(s.getSex()));
		if (anyMatch){
			System.out.println("有女学生");
		}
		boolean allMatch = studentList.stream().allMatch(s -> 18 <= s.getAge());
		if (allMatch){
			System.out.println("所有学生都满18周岁");
		}
		boolean noneMatch = studentList.stream().noneMatch(s -> "克里斯".equals(s.getName()));
		if (noneMatch){
			System.out.println("没有克里斯这个学生");
		}
	}

	@Test
	public void streamTest(){
//		filterTest();
//		distinctTest();
//		distinctTest2();
//		sortTest();
//		sortTest2();
//		limitTest();
//		skipTest();
//		reduceTest();
//		minTest();
		matchTest();
//		convertListTest();
	}

}
