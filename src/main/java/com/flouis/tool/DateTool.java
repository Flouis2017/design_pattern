package com.flouis.tool;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Flouis
 * @date 2018/12/02
 * @description common util class for Date
 **/
public class DateTool {

	public final static String SQL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String convertToStr(Date date){
		if (date == null){
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(SQL_TIME_FORMAT);
			return sdf.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static String convertToStr(Date date, String dateFormat){
		if (date == null){
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.format(date);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static Date convertToDate(String dateStr){
		if (StringUtils.isBlank(dateStr)){
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(SQL_TIME_FORMAT);
			return sdf.parse(dateStr);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static Date convertToDate(String dateStr, String dateFormat){
		if (StringUtils.isBlank(dateStr)){
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			return sdf.parse(dateStr);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static Date changeMonth(Date date, int offset){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + offset);
		return calendar.getTime();
	}

	public static Date changeDay(Date date, int offset){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_YEAR,
				calendar.get(Calendar.DAY_OF_YEAR) + offset);
		return calendar.getTime();
	}


}
