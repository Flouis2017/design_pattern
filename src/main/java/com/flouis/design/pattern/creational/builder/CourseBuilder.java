package com.flouis.design.pattern.creational.builder;

import com.flouis.design.pattern.creational.model.Course;

public interface CourseBuilder {

	void buildCourseName(String courseName);
	void buildCoursePPT(String coursePPT);
	void buildCourseVideo(String courseVideo);
	void buildCourseDocument(String courseDocument);
	void buildCourseQA(String courseQA);

	Course makeCourse();
}
