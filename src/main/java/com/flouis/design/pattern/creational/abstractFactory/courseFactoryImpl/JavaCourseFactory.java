package com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl;

import com.flouis.design.pattern.creational.abstractFactory.CourseFactory;
import com.flouis.design.pattern.creational.model.document.Document;
import com.flouis.design.pattern.creational.model.document.JavaDocument;
import com.flouis.design.pattern.creational.model.video.JavaVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class JavaCourseFactory implements CourseFactory {

	@Override
	public Video getVideo() {
		return new JavaVideo();
	}

	@Override
	public Document getDocument() {
		return new JavaDocument();
	}

}
