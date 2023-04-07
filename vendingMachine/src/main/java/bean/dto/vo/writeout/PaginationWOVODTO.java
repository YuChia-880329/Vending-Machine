package bean.dto.vo.writeout;

import java.util.List;

public class PaginationWOVODTO {

	private PPageTurningWOVODTO previousPage;
	private List<PPageWOVODTO> pages;
	private PPageTurningWOVODTO nextPage;

	public PaginationWOVODTO() {
	}
	public PaginationWOVODTO(PPageTurningWOVODTO previousPage, List<PPageWOVODTO> pages, PPageTurningWOVODTO nextPage) {
		
		this.previousPage = previousPage;
		this.pages = pages;
		this.nextPage = nextPage;
	}
	
	
	public PPageTurningWOVODTO getPreviousPage() {
		return previousPage;
	}
	public List<PPageWOVODTO> getPages() {
		return pages;
	}
	public PPageTurningWOVODTO getNextPage() {
		return nextPage;
	}
	
	
	public void setPreviousPage(PPageTurningWOVODTO previousPage) {
		this.previousPage = previousPage;
	}
	public void setPages(List<PPageWOVODTO> pages) {
		this.pages = pages;
	}
	public void setNextPage(PPageTurningWOVODTO nextPage) {
		this.nextPage = nextPage;
	}
}
