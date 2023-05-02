package bean.dto.frontend.vo.writeout;

public class ReceiptVODTO {

	private boolean hasReceipt;
	private ReceiptContentVODTO receiptContent;
	
	
	public ReceiptVODTO() {
	}
	public ReceiptVODTO(boolean hasReceipt, ReceiptContentVODTO receiptContent) {
		
		this.hasReceipt = hasReceipt;
		this.receiptContent = receiptContent;
	}
	
	
	public boolean getHasReceipt() {
		return hasReceipt;
	}
	public ReceiptContentVODTO getReceiptContent() {
		return receiptContent;
	}
	
	
	public void setHasReceipt(boolean hasReceipt) {
		this.hasReceipt = hasReceipt;
	}
	public void setReceiptContent(ReceiptContentVODTO receiptContent) {
		this.receiptContent = receiptContent;
	}
}
