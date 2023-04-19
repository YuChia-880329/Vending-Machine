package bean.dto.frontend.vo.writeout;

import bean.dto.vo.writeout.PaginationVODTO;

public class FrontendVODTO {

	private WelcomePartVODTO welcomePart;
	private GoodsTablePageVODTO goodsTablePage;
	private PaginationVODTO pagination;
	
	
	public FrontendVODTO() {
	}
	public FrontendVODTO(WelcomePartVODTO welcomePart, GoodsTablePageVODTO goodsTablePage, PaginationVODTO pagination) {

		this.welcomePart = welcomePart;
		this.goodsTablePage = goodsTablePage;
		this.pagination = pagination;
	}
	
	
	public WelcomePartVODTO getWelcomePart() {
		return welcomePart;
	}
	public GoodsTablePageVODTO getGoodsTablePage() {
		return goodsTablePage;
	}
	public PaginationVODTO getPagination() {
		return pagination;
	}
	
	
	public void setWelcomePart(WelcomePartVODTO welcomePart) {
		this.welcomePart = welcomePart;
	}
	public void setGoodsTablePage(GoodsTablePageVODTO goodsTablePage) {
		this.goodsTablePage = goodsTablePage;
	}
	public void setPagination(PaginationVODTO pagination) {
		this.pagination = pagination;
	}
}
