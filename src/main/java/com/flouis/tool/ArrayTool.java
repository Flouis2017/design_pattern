package com.flouis.tool;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class ArrayTool {

	/**
	 * 获取一个数组连续元素的下标区间，如：[a,b,b,c,d,e,e,e,f,g]，返回[[1,2],[5,7]]
	 */
	public static List<List<Integer>> findContinuousIndexes(List<String> list){
		List<List<Integer>> resList = Lists.newArrayList();
		for ( int i = 0, j = 1; j < list.size(); j++){
			if ( !list.get(i).equals( list.get(j) ) ){
				if ( j - i > 1 ){
					setIndexList(i, j - 1, resList);
					i = j;
				} else {
					i++;
				}
			} else {
				if ( j == list.size() - 1 ){
					setIndexList(i, j, resList);
				}
			}
		}
		return resList;
	}

	public static void setIndexList(int x, int y, List<List<Integer>> list){
		List<Integer> subList = Lists.newArrayList();
		subList.add(x);
		subList.add(y);
		list.add(subList);
	}

	public static void main(String[] args) {
		String[] arr = new String[]{"a","b","b","c","d","e","e","e","f","f"};
		List<String> list = Arrays.asList(arr);
		System.out.println(findContinuousIndexes(list));
	}

}
