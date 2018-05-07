package com.jyd.util;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * 类名: DateUtils 备注: 时间: 2017年7月24日 下午1:57:14 作者:sylar
 * 
 * @version
 * @since JDK 1.8
 */
public class DateUtils {
	public static String getFormatDate() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		return simpleDateFormat.format(new Date());
	}

	public static String getFormatDateRentId() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");

		return simpleDateFormat.format(new Date());
	}
	public static String DateToStr(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		
		return simpleDateFormat.format(date);
	}
	
}
