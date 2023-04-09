package util;

public class PaginationUtil {

	public static int getMaxPage(int dataNumber, int datasPerPage) {
		
		if(dataNumber == 0)
			return 1;
		
		return (dataNumber-1)/datasPerPage + 1;
	}
	
	public static int getStartPage(int page, int pagesPerPageGroup) {
		
		return getBasePage(page, pagesPerPageGroup) + 1;
	}
	public static int getEndPage(int page, int pagesPerPageGroup, int maxPage) {
		
		int endPage = getBasePage(page, pagesPerPageGroup) + pagesPerPageGroup;
		
		return (endPage<maxPage ? endPage : maxPage);
	}
	
	private static int getBasePage(int page, int pagesPerGroup) {
		
		return ((page-1)/pagesPerGroup) * pagesPerGroup;
	}
	
	
}
