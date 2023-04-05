package util;

public class PaginationUtil {

	public static int getMaxPage(int dataNumber, int dataPerPage) {
		
		if(dataNumber == 0)
			return 0;
		
		return (dataNumber-1)/dataPerPage + 1;
	}
	public static int getBasePage(int page, int pagesPerGroup) {
		
		return ((page-1)/pagesPerGroup) * pagesPerGroup;
	}
	
	
}
