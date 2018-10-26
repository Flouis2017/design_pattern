package com.flouis.design.pattern.creational.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Course2 {

	private String courseName;
	private String coursePPT;
	private String courseVideo;
	private String courseDocument;
	private String courseQA;

	public Course2(CourseBuilder courseBuilder){
		this.courseName = courseBuilder.courseName;
		this.coursePPT = courseBuilder.coursePPT;
		this.courseVideo = courseBuilder.courseVideo;
		this.courseDocument = courseBuilder.courseDocument;
		this.courseQA = courseBuilder.courseQA;
	}

	public static CourseBuilder getCourseBuilder(){
		return new CourseBuilder();
	}

	// 链式调用构造器：内部类、在创建每个元部件后返回构造器本身以此进行链式调用。
	public static class CourseBuilder {

		private String courseName;
		private String coursePPT;
		private String courseVideo;
		private String courseDocument;
		private String courseQA;

		public CourseBuilder buildCourseName(String courseName){
			this.courseName = courseName;
			return this;
		}

		public CourseBuilder buildCoursePPT(String coursePPT) {
			this.coursePPT = coursePPT;
			return this;
		}

		public CourseBuilder buildCourseVideo(String courseVideo) {
			this.courseVideo = courseVideo;
			return this;
		}

		public CourseBuilder buildCourseDocument(String courseDocument) {
			this.courseDocument =courseDocument;
			return this;
		}

		public CourseBuilder buildCourseQA(String courseQA) {
			this.courseQA = courseQA;
			return this;
		}

		public Course2 build() {
			return new Course2(this);
		}
	}

}
