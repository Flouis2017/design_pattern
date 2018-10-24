package com.flouis.design.pattern.creational.abstractFactory;

import com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl.FECourseFactory;
import com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl.JavaCourseFactory;
import com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl.PythonCourseFactory;
import com.flouis.design.pattern.creational.model.document.Document;
import com.flouis.design.pattern.creational.model.video.Video;
import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void test(){
		CourseFactory courseFactory = new JavaCourseFactory();
		Video video = courseFactory.getVideo();
		Document document = courseFactory.getDocument();
		video.produce();
		document.produce();

		courseFactory = new PythonCourseFactory();
		video = courseFactory.getVideo();
		document = courseFactory.getDocument();
		video.produce();
		document.produce();

		courseFactory = new FECourseFactory();
		video = courseFactory.getVideo();
		document = courseFactory.getDocument();
		video.produce();
		document.produce();

	}

}
