package com.flouis.test;

import org.junit.Test;

import java.util.*;

public class MyTest {

	@Test
	public void MainTest(){

		// 冒泡排序
		/*Integer[] arr = {36, 28, 45, 13, 67, 37, 18, 56};
		bubbleSort(arr);
		for (int x : arr){
			System.out.print(x+" ");
		}*/

//		System.out.println( isPossible(5,4,1,9) );

		List<String> userCities = new ArrayList<>();
		userCities.add("Shanghai->Beijing->Tianjing->Chongqing");
		userCities.add("Hangzhou->Shanghai->Suzhou->Xiamen->Nanjing");
		System.out.println( getFavoriteCities(userCities) );

		// 按照字典顺序对字符串进行比较、排序
		/*String[] strArr = {"qwer", "zxcv", "asdf"};
		System.out.println(strArr[0].compareTo(strArr[1]) > 0);
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));*/



	}



	public static List bubbleSort(List<Integer> list){
		int temp;
		Integer[] arr = (Integer[]) list.toArray(new Integer[0]);
		// 做多少轮排序（最多length-1轮）
		for (int i = 0; i < arr.length - 1; i++) {
			// 每一轮比较多少个
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// 交换次序
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return Arrays.asList(arr);
	}

	/**
	 * 冒泡排序算法
	 */
	public static void bubbleSort(Integer[] list) {
		int temp;
		// 做多少轮排序（最多length-1轮）
		for (int i = 0; i < list.length - 1; i++) {
			// 每一轮比较多少个
			for (int j = 0; j < list.length - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					// 交换次序
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}


	public static String isPossible(int a, int b, int c, int d) {
		String res = "No";
		// sort first:
		int temp;
		int[] arr = {a, b, c, d};
		for (int i = 0; i < arr.length - 1; i++) {
			// 每一轮比较多少个
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// 交换次序
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// deal business:
		if (arr[0] + arr[1] == arr[2] && arr[1] + arr[2] == arr[3]){
			res = "Yes";
		}

		return res;
	}


	public static String getFavoriteCities(List<String> userCities) {
		StringBuffer res = new StringBuffer();
		res.setLength(0);
		Map<String, Integer> tmpMap = new HashMap<>();
		List<String> cityList = new ArrayList<>();

		for (int i = 0; i < userCities.size(); i++){
			String[] cityArr = userCities.get(i).split("->");
			for (String x : cityArr){
				cityList.add(x);
			}
		}

		for (String city : cityList){
			if (tmpMap.containsKey(city)){
				// get record num:
				int num = tmpMap.get(city);
				num++;
				tmpMap.put(city, num);
			} else {
				tmpMap.put(city, 1);
			}
		}

//		System.out.println(tmpMap);

		// sort
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		Iterator<Map.Entry<String, Integer>> entryIterator = tmpMap.entrySet().iterator();
		while (entryIterator.hasNext()){
			Map.Entry<String, Integer> entry = entryIterator.next();
			list.add(entry);
		}
//		System.out.println("Before sorting:");
//		System.out.println(list);

		// customized sorting:
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() > o2.getValue()){
					return -1;
				} else if (o1.getValue() < o2.getValue()){
					return 1;
				} else {
					return o1.getKey().compareToIgnoreCase(o2.getKey()) > 0 ? 1 : -1;
				}
			}
		});
//		System.out.println("After sorting:");
//		System.out.println(list);

		Map.Entry[] arr = new Map.Entry[list.size()];
		for (int i=0; i<list.size(); i++){
			arr[i] = list.get(i);
		}
		if (arr.length == 0 ){
			res.append("");
		} else if (arr.length == 1) {
			res.append(arr[0].getKey()).append(" ").append(arr[0].getValue());
		} else {
			res.append(list.toString());
		}
		return res.toString();
	}


}
