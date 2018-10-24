package com.flouis.design.pattern.creational.factoryMethod.videoFactoryImpl;

import com.flouis.design.pattern.creational.factoryMethod.VideoFactory;
import com.flouis.design.pattern.creational.model.video.PythonVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class PythonVideoFactory implements VideoFactory {
	@Override
	public Video getVideo() {
		return new PythonVideo();
	}
}
