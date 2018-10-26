package com.flouis.design.pattern.creational.builder;

import com.flouis.design.pattern.creational.model.Course;

public class Coach {

	private CourseBuilder courseBuilder;

	// 通过set方式注入
	public void setCourseBuilder(CourseBuilder courseBuilder){
		this.courseBuilder = courseBuilder;
	}

	public Course makeCourse(String courseName, String coursePPT,
							 String courseVideo, String courseDocument,
							 String courseQA){
		this.courseBuilder.buildCourseName(courseName);
		this.courseBuilder.buildCoursePPT(coursePPT);
		this.courseBuilder.buildCourseVideo(courseVideo);
		this.courseBuilder.buildCourseDocument(courseDocument);
		this.courseBuilder.buildCourseQA(courseQA);
		return this.courseBuilder.makeCourse();
	}
}
