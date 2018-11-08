package com.flouis.test;

import org.junit.Test;

import java.util.*;


public class MapTraverse {

	@Test
	public void test(){

		Map<String, String> testMap = new HashMap<>();
		testMap.put("aaa", "qwer");
		testMap.put("bbb", "asdf");
		testMap.put("ccc", "zxcv");
		testMap.put("ddd", "wasd");
		List keyList = getAllKeys(testMap);
		System.out.println("keys: " + keyList); // keys: [aaa, ccc, bbb, ddd]
		List valueList = getAllValues(testMap);
		System.out.println("values:" + valueList); // values:[qwer, zxcv, asdf, wasd]

		List<Map> resList = mapToListByKeyset(testMap);
		System.out.println(resList); // [{aaa=qwer}, {ccc=zxcv}, {bbb=asdf}, {ddd=wasd}]

		List<Map<String, String>> resList2 = mapToListByEntryset(testMap);
		System.out.println(resList2); // [{aaa=qwer}, {ccc=zxcv}, {bbb=asdf}, {ddd=wasd}]

		List<Map<String, String>> resList3 = mapToListByIterator(testMap);
		System.out.println(resList3); // [{aaa=qwer}, {bbb=asdf}, {ddd=wasd}]

	}

	public static List getAllKeys(Map map){
		List keyList = new ArrayList();
		for (Object key : map.keySet()){
			keyList.add(key);
		}
		return keyList;
	}


	public static List getAllValues(Map map){
		List valueList = new ArrayList();
		for (Object value : map.values()){
			valueList.add(value);
		}
		return valueList;
	}

	// 遍历Map，返回一个List<Map>
	// 方法一：先使用keySet获取到key，再用get(key)获取到value，但是这种方法效率最低，不推荐使用
	public static List<Map> mapToListByKeyset(Map map){
		List<Map> resList = new ArrayList<>();
		for (Object key : map.keySet()){
			Map tempMap = new HashMap();
			tempMap.put(key, map.get(key));
			resList.add(tempMap);
		}
		return resList;
	}

	// 方法二：通过Map接口的entrySet遍历，性能优于上面，这种方法也是最常用的map遍历方法：
	public static List<Map<String, String>> mapToListByEntryset(Map<String, String> map){
		List<Map<String, String>> resList = new ArrayList<>();
		for (Map.Entry<String, String> entry : map.entrySet()){
			Map tempMap = new HashMap();
			tempMap.put(entry.getKey(), entry.getValue());
			resList.add(tempMap);
		}
		return resList;
	}

	// 方法三：使用迭代器对map进行遍历(如果需要删除元素，可以使用迭代器中remove方法进行移出，其他所有方法都不允许在遍历的时候删除元素)
	public static List<Map<String, String>> mapToListByIterator(Map<String, String> map){
		List<Map<String, String>> resList = new ArrayList<>();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			if ("ccc".equals( entry.getKey() )){
				it.remove();
			} else {
				Map<String, String> tempMap = new HashMap<>();
				tempMap.put(entry.getKey(), entry.getValue());
				resList.add(tempMap);
			}
		}
		return resList;
	}



}
