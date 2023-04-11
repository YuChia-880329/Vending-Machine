package bean.vo.writeout;

import java.util.List;

public class PaginationVO {

	private PageTurningVO previousPage;
	private List<PageVO> pages;
	private PageTurningVO nextPage;

	public PaginationVO() {
	}
	public PaginationVO(PageTurningVO previousPage, List<PageVO> pages, PageTurningVO nextPage) {

		this.previousPage = previousPage;
		this.pages = pages;
		this.nextPage = nextPage;
	}
	
	
	public PageTurningVO getPreviousPage() {
		return previousPage;
	}
	public List<PageVO> getPages() {
		return pages;
	}
	public PageTurningVO getNextPage() {
		return nextPage;
	}
	
	
	public void setPreviousPage(PageTurningVO previousPage) {
		this.previousPage = previousPage;
	}
	public void setPages(List<PageVO> pages) {
		this.pages = pages;
	}
	public void setNextPage(PageTurningVO nextPage) {
		this.nextPage = nextPage;
	}
}
