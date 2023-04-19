package bean.vo.frontend.writeout;

import bean.vo.writeout.PaginationVO;

public class FrontendVO {

	private WelcomePartVO welcomePart;
	private GoodsTablePageVO goodsTablePage;
	private PaginationVO pagination;
	
	
	public FrontendVO() {
	}
	public FrontendVO(WelcomePartVO welcomePart, GoodsTablePageVO goodsTablePage, PaginationVO pagination) {

		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.pagination = pagination;
	}
	
	
	public WelcomePartVO getWelcomePart() {
		return welcomePart;
	}
	public GoodsTablePageVO getGoodsTablePage() {
		return goodsTablePage;
	}
	public PaginationVO getPagination() {
		return pagination;
	}
	
	
	public void setWelcomePart(WelcomePartVO welcomePart) {
		this.welcomePart = welcomePart;
	}
	public void setGoodsTablePage(GoodsTablePageVO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setPagination(PaginationVO pagination) {
		this.pagination = pagination;
	}
}
