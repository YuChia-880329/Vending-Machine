package bean.vo.frontend.writeout;

public class ReceiptVO {

	private String hasReceipt;
	private ReceiptContentVO receiptContent;
	
	
	public ReceiptVO() {
	}
	public ReceiptVO(String hasReceipt, ReceiptContentVO receiptContent) {

		this.hasReceipt = hasReceipt;
		this.receiptContent = receiptContent;
	}
	
	
	public String getHasReceipt() {
		return hasReceipt;
	}
	public ReceiptContentVO getReceiptContent() {
		return receiptContent;
	}
	
	
	public void setHasReceipt(String hasReceipt) {
		this.hasReceipt = hasReceipt;
	}
	public void setReceiptContent(ReceiptContentVO receiptContent) {
		this.receiptContent = receiptContent;
	}
}
