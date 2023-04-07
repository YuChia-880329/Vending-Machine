package util;

public class URLUtil {

	public static String concatParameter(String url, String paramName, String param, boolean firstParam) {
		
		if(!hasParameter(param))
			return url;
		
		if(firstParam)
			url = StringConcatUtil.concate(url, "?");
		else
			url = StringConcatUtil.concate(url, "&");
		
		return StringConcatUtil.concate(url, paramName, "=", param);
	}
	
	public static boolean isFirstParam(String param, boolean isFirstParam) {
		
		if(isFirstParam && hasParameter(param))
			return false;
		return isFirstParam;
	}
	
	private static boolean hasParameter(String param) {
		
		return param!=null && !"".equals(param);
	}

}
