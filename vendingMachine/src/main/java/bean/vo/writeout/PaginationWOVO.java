package bean.vo.writeout;

import java.util.List;

public class PaginationWOVO {

	private PPageTurningWOVO previousPage;
	private List<PPageWOVO> pages;
	private PPageTurningWOVO nextPage;

	public PaginationWOVO() {
	}
	public PaginationWOVO(PPageTurningWOVO previousPage, List<PPageWOVO> pages, PPageTurningWOVO nextPage) {

		this.previousPage = previousPage;
		this.pages = pages;
		this.nextPage = nextPage;
	}
	
	
	public PPageTurningWOVO getPreviousPage() {
		return previousPage;
	}
	public List<PPageWOVO> getPages() {
		return pages;
	}
	public PPageTurningWOVO getNextPage() {
		return nextPage;
	}
	
	
	public void setPreviousPage(PPageTurningWOVO previousPage) {
		this.previousPage = previousPage;
	}
	public void setPages(List<PPageWOVO> pages) {
		this.pages = pages;
	}
	public void setNextPage(PPageTurningWOVO nextPage) {
		this.nextPage = nextPage;
	}
}
