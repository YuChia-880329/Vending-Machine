package bean.dto.frontend.vo.writeout;

import enumeration.Has;

public class ReceiptVODTO {

	private Has hasReceipt;
	private ReceiptContentVODTO receiptContent;
	
	
	public ReceiptVODTO() {
	}
	public ReceiptVODTO(Has hasReceipt, ReceiptContentVODTO receiptContent) {
		
		this.hasReceipt = hasReceipt;
		this.receiptContent = receiptContent;
	}
	
	
	public Has getHasReceipt() {
		return hasReceipt;
	}
	public ReceiptContentVODTO getReceiptContent() {
		return receiptContent;
	}
	
	
	public void setHasReceipt(Has hasReceipt) {
		this.hasReceipt = hasReceipt;
	}
	public void setReceiptContent(ReceiptContentVODTO receiptContent) {
		this.receiptContent = receiptContent;
	}
}
