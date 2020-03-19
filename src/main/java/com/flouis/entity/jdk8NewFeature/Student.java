package com.flouis.entity.jdk8NewFeature;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private String studentId;
	private String name;
	private String sex;
	private Integer age;
	private List<Stationery> stationeryList = Lists.newArrayList();

	public Student(String studentId, String name, String sex, Integer age){
		this.setStudentId(studentId);
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
	}

	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(this.studentId, student.getStudentId()) &&
				Objects.equals(this.name, student.getName()) &&
				Objects.equals(this.sex, student.getSex()) &&
				Objects.equals(this.age, student.getAge());
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.studentId, this.name, this.sex, this.age);
	}

}
