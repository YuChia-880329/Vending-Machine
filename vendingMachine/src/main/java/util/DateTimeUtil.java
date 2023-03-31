package util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	
	public static final String JAVA_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(JAVA_FORMAT_STRING);
	
	
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
		
		return LocalDateTime.parse(dateTimeStr, FORMATTER);
	}
	public static String localDateTimeToString(LocalDateTime localDateTime) {
		
		return localDateTime.format(FORMATTER);
	}
}
