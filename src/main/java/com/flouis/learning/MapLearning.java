package com.flouis.learning;

import com.google.common.collect.Maps;

import java.util.Map;

public class MapLearning {


	public static void main(String[] args) {
		Map<String, Object> map1 = Maps.newHashMap();
		map1.put("name", "Flouis");
		map1.put("age", 25);
		map1.put("gender", "Male");
		map1.put("city", "福建厦门");
		map1.put("userId", 10000L);
		map1.put("state", 1);
		map1.put("mobile", null);
//		map1.put(null, "xxx");
		System.out.println(map1);

		// TreeMap默认将键值对以键升序进行存储
		Map<String, Object> map2 = Maps.newTreeMap();
		for (Map.Entry<String, Object> entry : map1.entrySet()){
			map2.put(entry.getKey(), entry.getValue());
		}
		System.out.println(map2);

		for (Map.Entry<String, Object> entry : map2.entrySet()){
			System.out.println(entry.getValue());
		}

//		Map map3 = Maps.newLinkedHashMap();
//		Map map4 = Maps.newConcurrentMap();
//		Map map5 = Maps.newIdentityHashMap();
	}

}
