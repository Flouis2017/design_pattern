package com.flouis.design.pattern.creational.simpleFactory;

import com.flouis.design.pattern.creational.model.video.JavaVideo;
import com.flouis.design.pattern.creational.model.video.PythonVideo;
import com.flouis.design.pattern.creational.model.video.Video;
import org.junit.Test;

public class SimpleFactoryTest {

	@Test
	public void test(){
//		原始创建Java对象
//		Video video = new JavaVideo();
//		video.produce();
//		video = new PythonVideo();
//		video.produce();

		// 使用(朴素)简单工厂生产对象
		/*Video video = VideoSimpleFactory.getVideo("java");
		if (video == null){
			System.out.println("尚无该Video实例");
			return;
		}
		video.produce();*/

		// 使用(反射)简单工厂生产对象
		Video video = VideoSimpleFactory.getVideo(JavaVideo.class);
		video.produce();
		video = VideoSimpleFactory.getVideo(PythonVideo.class);
		video.produce();

	}

}
