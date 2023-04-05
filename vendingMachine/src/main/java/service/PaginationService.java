package service;

import java.util.ArrayList;
import java.util.List;

import bean.dto.vo.writeout.PPageWOVODTO;
import bean.dto.vo.writeout.PaginationWOVODTO;
import enumeration.Has;
import util.PaginationUtil;

public class PaginationService {

	private static final PaginationService INSTANCE = new PaginationService();
	
	private PaginationService() {
	}
	
	public static PaginationService getInstance() {
		
		return INSTANCE;
	}
	
	public PaginationWOVODTO getPagination(int page, int pagesPerGroup, int maxPage) {
		
		PaginationWOVODTO pagination = new PaginationWOVODTO();
		
		pagination.setHasPreviousPage(hasPreviousPage(page));
		pagination.setPages(pages(page, pagesPerGroup, maxPage));
		pagination.setHasNextPage(hasNextPage(page, maxPage));
		
		return pagination;
	}
	
	private Has hasPreviousPage(int page) {
		
		if(page == 1)
			return Has.FALSE;
		else
			return Has.TRUE;
	}
	
	private List<PPageWOVODTO> pages(int page, int pagesPerGroup, int maxPage){
		
		List<PPageWOVODTO> list = new ArrayList<>();
		
		int basePage = PaginationUtil.getBasePage(page, pagesPerGroup);
		
		int endPage = basePage + pagesPerGroup;
		endPage = ((endPage>maxPage) ? maxPage : endPage);
		
		for(int i=basePage+1; i<=endPage; i++) {
			
			list.add(new PPageWOVODTO(i));
		}
		
		return list;
	}
	
	private Has hasNextPage(int page, int maxPage) {
		
		if(page == maxPage)
			return Has.FALSE;
		else
			return Has.TRUE;
	}
}
