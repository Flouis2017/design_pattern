package com.flouis.design.pattern.creational.builder.courseBuilderImpl;

import com.flouis.design.pattern.creational.builder.CourseBuilder;
import com.flouis.design.pattern.creational.model.Course;

public class ActualCourseBuilder implements CourseBuilder {

	private Course course = new Course();

	@Override
	public void buildCourseName(String courseName) {
		this.course.setCourseName(courseName);
	}

	@Override
	public void buildCoursePPT(String coursePPT) {
		this.course.setCoursePPT(coursePPT);
	}

	@Override
	public void buildCourseVideo(String courseVideo) {
		this.course.setCourseVideo(courseVideo);
	}

	@Override
	public void buildCourseDocument(String courseDocument) {
		this.course.setCourseDocument(courseDocument);
	}

	@Override
	public void buildCourseQA(String courseQA) {
		this.course.setCourseQA(courseQA);
	}

	@Override
	public Course makeCourse() {
		return this.course;
	}
}
