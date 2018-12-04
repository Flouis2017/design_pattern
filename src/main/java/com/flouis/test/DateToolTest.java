package com.flouis.test;

import com.flouis.tool.DateTool;
import org.junit.Test;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Flouis
 * @date 2018/12/02
 * @description TODO
 **/
public class DateToolTest {

	@Test
	public void mainTest(){
		Date date = Calendar.getInstance().getTime();
		System.out.println(date);
		String dateStr = DateTool.convertToStr(date);
		System.out.println(dateStr);
		dateStr = DateTool.convertToStr(date, "asdfasdf");
		System.out.println(dateStr);
		dateStr = DateTool.convertToStr(date, "yyyy/MM/dd HH:mm:ss.SS");
		System.out.println(dateStr);

		System.out.println(DateTool.convertToStr(null));
	}

	@Test
	public void mainTest2(){
		String dateStr = "2018-12-01 14:20:50";
		System.out.println(DateTool.convertToDate(dateStr));
		dateStr = "2018/12/01 14:20:50";
		System.out.println(DateTool.convertToDate(dateStr, "yyyy/MM/dd HH:mm:ss"));
		dateStr = "  ";
		System.out.println(DateTool.convertToDate(dateStr));
		dateStr = "asdfasdf";
		System.out.println(DateTool.convertToDate(dateStr));
	}

	@Test
	public void mainTest3(){
		Date date = Calendar.getInstance().getTime();
		System.out.println(DateTool.changeMonth(date,12));
		date = DateTool.changeDay(date, -2);
		System.out.println(DateTool.convertToStr(date));
	}

	@Test
	public void mainTest4(){
		Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
		System.out.println(timestamp.toString().substring(0,19));

		System.out.println(Timestamp.valueOf("2018-11-07 00:28:38"));
//		System.out.println(Timestamp.valueOf("2018/11/07 00:28:38"));
		System.out.println(Timestamp.valueOf(LocalDateTime.now()));

		System.out.println(LocalDateTime.now());
	}

}
