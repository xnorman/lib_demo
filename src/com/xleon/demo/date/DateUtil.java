package com.xleon.demo.date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public ArrayList<Date> getDateOfWeek(Date date) {
		ArrayList<Date> list = new ArrayList<Date>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_WEEK, (-1) * c.get(Calendar.DAY_OF_WEEK) + 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		list.add(c.getTime());
		c.add(Calendar.DAY_OF_WEEK, 7 - c.get(Calendar.DAY_OF_WEEK));
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		list.add(c.getTime());
		return list;
	}
	
	public ArrayList<Date> getDateOfMonth(Date date) {
		ArrayList<Date> list = new ArrayList<Date>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		list.add(c.getTime());
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		list.add(c.getTime());
		return list;
	}



	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		DateUtil du = new DateUtil();
		ArrayList<Date> list = du.getDateOfWeek(new Date());
		System.out.println(sdf.format(list.get(0)));
		System.out.println(sdf.format(list.get(1)));
		ArrayList<Date> listm = du.getDateOfMonth(new Date());
		System.out.println(sdf.format(listm.get(0)));
		System.out.println(sdf.format(listm.get(1)));
	}

}
