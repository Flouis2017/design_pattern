package com.flouis.design.pattern.creational.builder;

import com.flouis.design.pattern.creational.builder.courseBuilderImpl.ActualCourseBuilder;
import com.flouis.design.pattern.creational.model.Course;
import com.flouis.design.pattern.creational.model.Course2;
import org.junit.Test;

public class BuilderTest {

	@Test
	public void test(){
		CourseBuilder courseBuilder = new ActualCourseBuilder();
		Coach coach = new Coach();
		coach.setCourseBuilder(courseBuilder);

		Course course = coach.makeCourse("Java设计模式", "Java设计模式PPT",
				"Java设计模式视频", "Java设计模式文档", "Java设计模式问答");

		System.out.println(course);
	}

	/**
	 * 建造者模式改进：使用链式调用创建，实际开发中经常用到。
	 */
	@Test
	public void test2(){
		Course2 course = Course2.getCourseBuilder().buildCourseName("Java设计模式2").buildCoursePPT("Java设计模式2PPT")
						.buildCourseVideo("Java设计模式2视频").buildCourseDocument("Java设计模式2文档")
						.buildCourseQA("Java设计模式2问答").build();
		System.out.println(course);
	}

}
