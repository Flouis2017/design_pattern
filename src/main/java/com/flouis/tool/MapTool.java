package com.flouis.tool;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author Flouis
 * @date 2018/11/29
 * @description common util class for Map
 **/
public class MapTool {

	/**
	 * Convert an entity into a map
	 *
	 * @param bean
	 * @return Map<String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               Object>
	 */
	public static Map<String, Object> convertToMap(Object bean) {
		Map<String, Object> map = Maps.newHashMap();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor descriptor : descriptors) {
				String key = descriptor.getName();
				if (!"class".equals(key)) {
					Method method = descriptor.getReadMethod();
					Object value = method.invoke(bean);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Convert an Entity List into a Map List
	 * @param beanList
	 * @param <T>
	 * @return
	 */
	public static <T> List<Map<String, Object>> convertToMapList(List<T> beanList) {
		List<Map<String, Object>> list = Lists.newArrayList();
		if (beanList != null && beanList.size()>=1){
			for (T bean : beanList){
				list.add(convertToMap(bean));
			}
		}
		return list;
	}


}
