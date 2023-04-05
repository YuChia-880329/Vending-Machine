package bean.vo.writeout;

import java.util.List;

public class PaginationWOVO {

	private String hasPreviousPage;
	private List<PPageWOVO> pages;
	private String hasNextPage;

	public PaginationWOVO() {
	}
	public PaginationWOVO(String hasPreviousPage, List<PPageWOVO> pages, String hasNextPage) {

		this.hasPreviousPage = hasPreviousPage;
		this.pages = pages;
		this.hasNextPage = hasNextPage;
	}
	
	
	public String getHasPreviousPage() {
		return hasPreviousPage;
	}
	public List<PPageWOVO> getPages() {
		return pages;
	}
	public String getHasNextPage() {
		return hasNextPage;
	}
	
	
	public void setHasPreviousPage(String hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public void setPages(List<PPageWOVO> pages) {
		this.pages = pages;
	}
	public void setHasNextPage(String hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
}
