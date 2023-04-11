package bean.dto.vo.writeout;

import java.util.List;

public class PaginationVODTO {

	private PageTurningVODTO previousPage;
	private List<PageVODTO> pages;
	private PageTurningVODTO nextPage;

	public PaginationVODTO() {
	}
	public PaginationVODTO(PageTurningVODTO previousPage, List<PageVODTO> pages, PageTurningVODTO nextPage) {
		
		this.previousPage = previousPage;
		this.pages = pages;
		this.nextPage = nextPage;
	}
	
	
	public PageTurningVODTO getPreviousPage() {
		return previousPage;
	}
	public List<PageVODTO> getPages() {
		return pages;
	}
	public PageTurningVODTO getNextPage() {
		return nextPage;
	}
	
	
	public void setPreviousPage(PageTurningVODTO previousPage) {
		this.previousPage = previousPage;
	}
	public void setPages(List<PageVODTO> pages) {
		this.pages = pages;
	}
	public void setNextPage(PageTurningVODTO nextPage) {
		this.nextPage = nextPage;
	}
}
