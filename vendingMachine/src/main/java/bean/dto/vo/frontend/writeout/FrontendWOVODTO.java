package bean.dto.vo.frontend.writeout;

import bean.dto.vo.writeout.PaginationVODTO;

public class FrontendWOVODTO {

	private FWelcomeMsgWOVODTO welcomeMsg;
	private FReceiptWOVODTO receipt;
	private FGoodsTableWOVODTO goodsTable;
	private PaginationVODTO pagination;
	
	
	public FrontendWOVODTO() {
	}
	public FrontendWOVODTO(FWelcomeMsgWOVODTO welcomeMsg, FReceiptWOVODTO receipt, FGoodsTableWOVODTO goodsTable, PaginationVODTO pagination) {

		this.welcomeMsg = welcomeMsg;
		this.receipt = receipt;
		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public FWelcomeMsgWOVODTO getWelcomeMsg() {
		return welcomeMsg;
	}
	public FReceiptWOVODTO getReceipt() {
		return receipt;
	}
	public FGoodsTableWOVODTO getGoodsTable() {
		return goodsTable;
	}
	public PaginationVODTO getPagination() {
		return pagination;
	}
	
	
	public void setWelcomeMsg(FWelcomeMsgWOVODTO welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
	public void setReceipt(FReceiptWOVODTO receipt) {
		this.receipt = receipt;
	}
	public void setGoodsTable(FGoodsTableWOVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationVODTO pagination) {
		this.pagination = pagination;
	}
}
