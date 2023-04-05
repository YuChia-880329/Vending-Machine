package bean.vo.frontend.writeout;

import bean.vo.writeout.PaginationWOVO;

public class FrontendWOVO {

	private FWelcomeMsgWOVO welcomeMsg;
	private FReceiptWOVO receipt;
	private FGoodsTableWOVO goodsTable;
	private PaginationWOVO pagination;
	
	
	public FrontendWOVO() {
	}
	public FrontendWOVO(FWelcomeMsgWOVO welcomeMsg, FReceiptWOVO receipt, FGoodsTableWOVO goodsTable, PaginationWOVO pagination) {

		this.welcomeMsg = welcomeMsg;
		this.receipt = receipt;
		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public FWelcomeMsgWOVO getWelcomeMsg() {
		return welcomeMsg;
	}
	public FReceiptWOVO getReceipt() {
		return receipt;
	}
	public FGoodsTableWOVO getGoodsTable() {
		return goodsTable;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setWelcomeMsg(FWelcomeMsgWOVO welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
	public void setReceipt(FReceiptWOVO receipt) {
		this.receipt = receipt;
	}
	public void setGoodsTable(FGoodsTableWOVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
