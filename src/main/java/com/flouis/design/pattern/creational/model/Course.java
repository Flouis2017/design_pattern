package com.flouis.design.pattern.creational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Course {

	private String courseName;
	private String coursePPT;
	private String courseVideo;
	private String courseDocument;
	private String courseQA;

	public Course(){}

}
