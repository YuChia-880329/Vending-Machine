package util;

public class PaginationUtil {

	public static int getMaxPage(int dataNumber, int dataPerPage) {
		
		if(dataNumber == 0)
			return 1;
		
		return (dataNumber-1)/dataPerPage + 1;
	}
	
	public static int getStartPage(int page, int pagesPerGroup) {
		
		return getBasePage(page, pagesPerGroup) + 1;
	}
	public static int getEndPage(int page, int pagesPerGroup, int maxPage) {
		
		int endPage = getBasePage(page, pagesPerGroup) + pagesPerGroup;
		
		return (endPage<maxPage ? endPage : maxPage);
	}
	
	private static int getBasePage(int page, int pagesPerGroup) {
		
		return ((page-1)/pagesPerGroup) * pagesPerGroup;
	}
	
	
}
