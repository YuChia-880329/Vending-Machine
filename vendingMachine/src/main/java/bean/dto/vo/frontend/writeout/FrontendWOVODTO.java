package bean.dto.vo.frontend.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;
import bean.vo.writeout.PaginationWOVO;

public class FrontendWOVODTO {

	private FWelcomeMsgWOVODTO welcomeMsg;
	private FReceiptWOVODTO receipt;
	private FGoodsTableWOVODTO goodsTable;
	private PaginationWOVODTO pagination;
	
	
	public FrontendWOVODTO() {
	}
	public FrontendWOVODTO(FWelcomeMsgWOVODTO welcomeMsg, FReceiptWOVODTO receipt, FGoodsTableWOVODTO goodsTable, PaginationWOVODTO pagination) {

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
	public PaginationWOVODTO getPagination() {
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
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
