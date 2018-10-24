package com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl;

import com.flouis.design.pattern.creational.abstractFactory.CourseFactory;
import com.flouis.design.pattern.creational.model.document.Document;
import com.flouis.design.pattern.creational.model.document.PythonDocument;
import com.flouis.design.pattern.creational.model.video.PythonVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class PythonCourseFactory implements CourseFactory {

	@Override
	public Video getVideo() {
		return new PythonVideo();
	}

	@Override
	public Document getDocument() {
		return new PythonDocument();
	}

}
