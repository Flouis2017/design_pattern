package com.flouis.test;

import com.flouis.entity.User;
import com.flouis.tool.MapTool;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Flouis
 * @date 2018/11/29
 **/
public class MapToolTest {

	@Test
	public void testBeanToMap(){
		User user = new User();
		user.setId(24L);
		user.setUsername("Flouis");
		user.setGender(1);
		user.setPhone("13899990000");
		user.setAppCode("23794hfj923jr");
		System.out.println(user.toString());
		Map<String, Object> map = MapTool.convertToMap(user);
		System.out.println(map);
		System.out.println("map.get(\"appCode\") : " + map.get("appCode"));
	}

	@Test
	public void testBeanListToMapList(){
		List<User> userList = Lists.newArrayList();
		User user = new User();
		user.setId(24L);
		user.setUsername("Flouis");
		user.setGender(1);
		user.setPhone("13899990000");
		user.setAppCode("23794hfj923jr");
		userList.add(user);
		User user2 = new User();
		user2.setId(30L);
		user2.setUsername("爱丽丝");
		user2.setGender(0);
		user2.setPhone("13899991111");
		user2.setAppCode("usi2oeirfjonfe");
		userList.add(user2);
		System.out.println(userList);
		List<Map<String, Object>> resList = MapTool.convertToMapList(userList);
		System.out.println(resList);
		System.out.println(resList.get(0).get("username"));
	}

	@Test
	public void mapCopyTest(){
		Map<String, String> strMap = Maps.newHashMap();
		strMap.put("name", "Flouis");
		strMap.put("nationality", "中国");
		strMap.put("gender", "男");
		Map<String, Object> resMap = Maps.newHashMap();
		resMap.putAll(strMap);
		resMap.put("age", 25);
		System.out.println("strMap: " + strMap);
		System.out.println("resMap: " + resMap);
	}

}
