package service.prepare;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.dto.vo.writeout.PageTurningVODTO;
import bean.dto.vo.writeout.PageVODTO;
import bean.dto.vo.writeout.PaginationVODTO;
import util.PaginationUtil;

public class PaginationService {

	private static final PaginationService INSTANCE = new PaginationService();
	
	private PaginationService() {
	}
	
	public static PaginationService getInstance() {
		
		return INSTANCE;
	}
	public PaginationVODTO prepare(int page, int pagesPerPageGroup, int maxPage, Function<Integer, String> urlFctn) {
		
		return prepare(
				page, 
				PaginationUtil.getStartPage(page, pagesPerPageGroup), 
				PaginationUtil.getEndPage(page, pagesPerPageGroup, maxPage), 
				maxPage, 
				urlFctn);
	}
	
	public PaginationVODTO prepare(int page, int startPage, int endPage, int maxPage, Function<Integer, String> urlFctn) {
		
		PaginationVODTO pagination = new PaginationVODTO();
		
		pagination.setPreviousPage(previousPage(page, maxPage, urlFctn));
		pagination.setPages(pages(startPage, endPage, urlFctn));
		pagination.setNextPage(nextPage(page, maxPage, urlFctn));
		
		return pagination;
	}
	
	private PageTurningVODTO previousPage(int page, int maxPage, Function<Integer, String> urlFctn) {
		
		PageTurningVODTO previousPage = new PageTurningVODTO();
		
		if(page==1 || maxPage==0) {
			
			previousPage.setExistence(false);
			previousPage.setUrl(null);
		}else {
			
			previousPage.setExistence(true);
			previousPage.setUrl(urlFctn.apply(page-1));
		}
		
		return previousPage;
	}
	
	private List<PageVODTO> pages(int startPage, int endPage, Function<Integer, String> urlFctn){
		
		List<PageVODTO> list = new ArrayList<>();
		
		for(int i=startPage; i<=endPage; i++) {
			
			PageVODTO page = new PageVODTO();
			
			page.setPage(i);
			page.setUrl(urlFctn.apply(i));
			
			list.add(page);
		}
		
		return list;
	}
	
	private PageTurningVODTO nextPage(int page, int maxPage, Function<Integer, String> urlFctn) {
		
		PageTurningVODTO previousPage = new PageTurningVODTO();
		
		if(page==maxPage || maxPage==0) {
			
			previousPage.setExistence(false);
			previousPage.setUrl(null);
		}else {
			
			previousPage.setExistence(true);
			previousPage.setUrl(urlFctn.apply(page+1));
		}
		
		return previousPage;
	}
}
