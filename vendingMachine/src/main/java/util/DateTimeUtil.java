package util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	public static final String JAVA_LOCAL_DATE_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	public static final String JAVA_LOCAL_DATE_FORMAT_STRING = "yyyy-MM-dd";
	
	private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(JAVA_LOCAL_DATE_TIME_FORMAT_STRING);
	private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(JAVA_LOCAL_DATE_FORMAT_STRING);
	
	
	public static Timestamp stringToTimestamp(String dateTimeStr) {
		
		return localDateTimeToTimestamp(stringToLocalDateTime(dateTimeStr));
	}
	public static String timestampToString(Timestamp timestamp) {
		
		return localDateTimeToString(timestampToLocalDateTime(timestamp));
	}
	public static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) {
		
		return timestamp.toLocalDateTime();
	}
	public static Timestamp localDateTimeToTimestamp(LocalDateTime localDateTime) {
		
		return Timestamp.valueOf(localDateTime);
	}
	
	public static LocalDateTime stringToLocalDateTime(String dateTimeStr) {
		
		return LocalDateTime.parse(dateTimeStr, LOCAL_DATE_TIME_FORMATTER);
	}
	public static String localDateTimeToString(LocalDateTime localDateTime) {
		
		return localDateTime.format(LOCAL_DATE_TIME_FORMATTER);
	}
	
	public static LocalDate stringToLocalDate(String dateTimeStr) {
		
		return LocalDate.parse(dateTimeStr, LOCAL_DATE_FORMATTER);
	}
	public static String localDateToString(LocalDate localDate) {
		
		return localDate.format(LOCAL_DATE_FORMATTER);
	}
	
	public static LocalDate localDateTimeToLocalDate(LocalDateTime localDateTime) {
		
		return localDateTime.toLocalDate();
	}
	public static LocalDateTime localDateToLocalDateTime(LocalDate localDate, int hour, int minute, int second) {
		
		return localDate.atTime(hour, minute, second);
	}
	public static LocalDateTime localDateToLocalDateTimeStart(LocalDate localDate) {
		
		return localDateToLocalDateTime(localDate, 0, 0, 0);
	}
	public static LocalDateTime localDateToLocalDateTimeEnd(LocalDate localDate) {
		
		return localDateToLocalDateTime(localDate, 23, 59, 59);
	}
}
