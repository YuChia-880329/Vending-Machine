package bean.dto.vo.writeout;

import java.util.List;

import enumeration.Has;

public class PaginationWOVODTO {

	private Has hasPreviousPage;
	private List<PPageWOVODTO> pages;
	private Has hasNextPage;

	public PaginationWOVODTO() {
	}
	public PaginationWOVODTO(Has hasPreviousPage, List<PPageWOVODTO> pages, Has hasNextPage) {
		
		this.hasPreviousPage = hasPreviousPage;
		this.pages = pages;
		this.hasNextPage = hasNextPage;
	}
	
	
	public Has getHasPreviousPage() {
		return hasPreviousPage;
	}
	public List<PPageWOVODTO> getPages() {
		return pages;
	}
	public Has getHasNextPage() {
		return hasNextPage;
	}
	
	
	public void setHasPreviousPage(Has hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public void setPages(List<PPageWOVODTO> pages) {
		this.pages = pages;
	}
	public void setHasNextPage(Has hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
