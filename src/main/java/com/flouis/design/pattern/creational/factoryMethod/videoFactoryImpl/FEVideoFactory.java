package com.flouis.design.pattern.creational.factoryMethod.videoFactoryImpl;

import com.flouis.design.pattern.creational.factoryMethod.VideoFactory;
import com.flouis.design.pattern.creational.model.video.FEVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class FEVideoFactory implements VideoFactory {
	@Override
	public Video getVideo() {
		return new FEVideo();
	}
}
