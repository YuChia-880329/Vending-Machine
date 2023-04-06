package service;

import java.util.ArrayList;
import java.util.List;

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
	
	public PaginationWOVODTO getPagination(int page, int startPage, int endPage, int maxPage) {
		
		PaginationWOVODTO pagination = new PaginationWOVODTO();
		
		pagination.setHasPreviousPage(hasPreviousPage(page, maxPage));
		pagination.setPages(pages(startPage, endPage));
		pagination.setHasNextPage(hasNextPage(page, maxPage));
		
		return pagination;
	}
	
	private Has hasPreviousPage(int page, int maxPage) {
		
		if(page==1 || maxPage==0)
			return Has.FALSE;
		else
			return Has.TRUE;
	}
	
	private List<PPageWOVODTO> pages(int startPage, int endPage){
		
		List<PPageWOVODTO> list = new ArrayList<>();
		
		for(int i=startPage; i<=endPage; i++) {
			
			list.add(new PPageWOVODTO(i));
		}
		
		return list;
	}
	
	private Has hasNextPage(int page, int maxPage) {
		
		if(page==maxPage || maxPage==0)
			return Has.FALSE;
		else
			return Has.TRUE;
	}
}
