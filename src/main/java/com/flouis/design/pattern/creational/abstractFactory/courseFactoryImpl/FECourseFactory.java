package com.flouis.design.pattern.creational.abstractFactory.courseFactoryImpl;

import com.flouis.design.pattern.creational.abstractFactory.CourseFactory;
import com.flouis.design.pattern.creational.model.document.Document;
import com.flouis.design.pattern.creational.model.document.FEDocument;
import com.flouis.design.pattern.creational.model.video.FEVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class FECourseFactory implements CourseFactory {
	@Override
	public Video getVideo() {
		return new FEVideo();
	}

	@Override
	public Document getDocument() {
		return new FEDocument();
	}
}
