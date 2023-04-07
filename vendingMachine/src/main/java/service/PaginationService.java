package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import bean.dto.vo.writeout.PPageTurningWOVODTO;
import bean.dto.vo.writeout.PPageWOVODTO;
import bean.dto.vo.writeout.PaginationWOVODTO;
import enumeration.Has;

public class PaginationService {

	private static final PaginationService INSTANCE = new PaginationService();
	
	private PaginationService() {
	}
	
	public static PaginationService getInstance() {
		
		return INSTANCE;
	}
	
	public PaginationWOVODTO getPagination(int page, int startPage, int endPage, int maxPage, Function<Integer, String> urlFctn) {
		
		PaginationWOVODTO pagination = new PaginationWOVODTO();
		
		pagination.setPreviousPage(previousPage(page, maxPage, urlFctn));
		pagination.setPages(pages(startPage, endPage, urlFctn));
		pagination.setNextPage(nextPage(page, maxPage, urlFctn));
		
		return pagination;
	}
	
	private PPageTurningWOVODTO previousPage(int page, int maxPage, Function<Integer, String> urlFctn) {
		
		PPageTurningWOVODTO previousPage = new PPageTurningWOVODTO();
		
		if(page==1 || maxPage==0) {
			
			previousPage.setExistence(Has.FALSE);
			previousPage.setUrl(null);
		}else {
			
			previousPage.setExistence(Has.TRUE);
			previousPage.setUrl(urlFctn.apply(page-1));
		}
		
		return previousPage;
	}
	
	private List<PPageWOVODTO> pages(int startPage, int endPage, Function<Integer, String> urlFctn){
		
		List<PPageWOVODTO> list = new ArrayList<>();
		
		for(int i=startPage; i<=endPage; i++) {
			
			PPageWOVODTO page = new PPageWOVODTO();
			
			page.setPage(i);
			page.setUrl(urlFctn.apply(i));
			
			list.add(page);
		}
		
		return list;
	}
	
	private PPageTurningWOVODTO nextPage(int page, int maxPage, Function<Integer, String> urlFctn) {
		
		PPageTurningWOVODTO previousPage = new PPageTurningWOVODTO();
		
		if(page==maxPage || maxPage==0) {
			
			previousPage.setExistence(Has.FALSE);
			previousPage.setUrl(null);
		}else {
			
			previousPage.setExistence(Has.TRUE);
			previousPage.setUrl(urlFctn.apply(page+1));
		}
		
		return previousPage;
	}
}
