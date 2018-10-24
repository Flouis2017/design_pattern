package com.flouis.design.pattern.creational.abstractFactory;

import com.flouis.design.pattern.creational.model.document.Document;
import com.flouis.design.pattern.creational.model.video.Video;

/**
 * 课程抽象工厂接口
 */
public interface CourseFactory {

	Video getVideo();

	Document getDocument();

}
