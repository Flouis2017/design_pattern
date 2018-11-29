package com.flouis.tool;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Flouis
 * @date 2018/11/29
 * @description common util class for String
 **/
public class StringTool {

	public static String getString(String arg){
		return StringUtils.isBlank(arg) ? null : arg;
	}

	/*public static void main(String[] args) {
		System.out.println(StringUtils.isEmpty("")); 	// true
		System.out.println(StringUtils.isEmpty("  "));	// false
		System.out.println(StringUtils.isBlank(""));		// true
		System.out.println(StringUtils.isBlank("  "));	// true
	}*/

}
