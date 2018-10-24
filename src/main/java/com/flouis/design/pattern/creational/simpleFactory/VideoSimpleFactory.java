package com.flouis.design.pattern.creational.simpleFactory;

import com.flouis.design.pattern.creational.model.video.JavaVideo;
import com.flouis.design.pattern.creational.model.video.PythonVideo;
import com.flouis.design.pattern.creational.model.video.Video;

public class VideoSimpleFactory {


	// 最朴素的简单工厂生产方法，通过type获取相应的对象实例。
	// 弊端：如果新增其他Video实现类，必须对该方法进行修改 —— 违反软件设计的“开闭原则”：对扩展开放对修改关闭
	public static Video getVideo(String type){
		if ("java".equalsIgnoreCase(type)){
			return new JavaVideo();
		} else if ("python".equalsIgnoreCase(type)){
			return new PythonVideo();
		}
		return null;
	}

	// 使用反射机制改进简单工厂生产方法：
	public static Video getVideo(Class clazz) {
		Video video = null;
		try {
			video = (Video) Class.forName(clazz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}

}
