package bean.vo.writeout;

public class PaginationVO {

	private PageTurningVO previousPage;
	private PageVO[] pages;
	private PageTurningVO nextPage;

	public PaginationVO() {
	}
	public PaginationVO(PageTurningVO previousPage, PageVO[] pages, PageTurningVO nextPage) {

		this.previousPage = previousPage;
		this.pages = pages;
		this.nextPage = nextPage;
	}
	
	
	public PageTurningVO getPreviousPage() {
		return previousPage;
	}
	public PageVO[] getPages() {
		return pages;
	}
	public PageTurningVO getNextPage() {
		return nextPage;
	}
	
	
	public void setPreviousPage(PageTurningVO previousPage) {
		this.previousPage = previousPage;
	}
	public void setPages(PageVO[] pages) {
		this.pages = pages;
	}
	public void setNextPage(PageTurningVO nextPage) {
		this.nextPage = nextPage;
	}
}
