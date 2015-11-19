package com.osndroid.cttms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>
 * Title: TimeUtils
 * </p>
 * <p>
 * Description: 时间工具类，可用于时间相关操作
 * </p>
 * <p>
 * Email: adore_art@sina.com
 * </p>
 * 
 * <ul>
 * <li>{@link #getCurrentTimeInLong()} 得到当前时间</li>
 * <li>{@link #getTime(long timeInMillis)} 得到当前时间</li>
 * <li>{@link #getCurrentTimeInLong()} 得到当前时间</li>
 * <li>{@link #getTime(long timeInMillis, SimpleDateFormat dateFormat)}
 * 将long转换为固定格式时间字符串</li>
 * </ul>
 * 
 * @author OsnDorid
 * @date 2015-4-27
 */
public class TimeUtils {

	/**
	 * 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	/**
	 * 时间格式： yyyy-MM-dd
	 */
	public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat(
			"yyyy-MM-dd");

	private TimeUtils() {
		throw new AssertionError();
	}

	/**
	 * 时间转化为字符串
	 * 
	 * @param timeInMillis
	 * @param dateFormat
	 * @return
	 */
	public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
		return dateFormat.format(new Date(timeInMillis));
	}

	/**
	 * 获得当前时间在毫秒，格式 {@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @param timeInMillis
	 * @return
	 */
	public static String getTime(long timeInMillis) {
		return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 获取当前时间在毫秒
	 * 
	 * @return
	 */
	public static long getCurrentTimeInLong() {
		return System.currentTimeMillis();
	}

	/**
	 * 获得当前时间在毫秒，格式 {@link #DEFAULT_DATE_FORMAT}
	 * 
	 * @return
	 */
	public static String getCurrentTimeInString() {
		return getTime(getCurrentTimeInLong());
	}

	/**
	 * 获取当前时间在毫秒
	 * 
	 * @return
	 */
	public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
		return getTime(getCurrentTimeInLong(), dateFormat);
	}


}
