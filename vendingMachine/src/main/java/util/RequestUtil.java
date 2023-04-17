package util;

import java.util.HashMap;
import java.util.Map;

public class RequestUtil {

	public static Map<String, String> getRequestBodyMap(String requestBodyStr){
		
		String[] strs = requestBodyStr.trim().split("&");
		
		Map<String, String> map = new HashMap<>();
		for(String str : strs) {
			
			String[] pair = str.split("=");
			map.put(pair[0], pair[1]);
		}
		
		return map;
	}
}
