package com.flouis.design.pattern.creational.factoryMethod;

import com.flouis.design.pattern.creational.factoryMethod.videoFactoryImpl.FEVideoFactory;
import com.flouis.design.pattern.creational.factoryMethod.videoFactoryImpl.JavaVideoFactory;
import com.flouis.design.pattern.creational.factoryMethod.videoFactoryImpl.PythonVideoFactory;
import com.flouis.design.pattern.creational.model.video.Video;
import org.junit.Test;

public class FactoryMethodTest {

	@Test
	public void test(){
		VideoFactory videoFactory = new JavaVideoFactory();
		Video video = videoFactory.getVideo();
		video.produce();

		videoFactory = new PythonVideoFactory();
		video = videoFactory.getVideo();
		video.produce();

		videoFactory = new FEVideoFactory();
		video = videoFactory.getVideo();
		video.produce();
	}

}
