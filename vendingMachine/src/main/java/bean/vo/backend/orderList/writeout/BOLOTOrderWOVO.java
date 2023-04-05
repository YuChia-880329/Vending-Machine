package bean.vo.backend.orderList.writeout;

public class BOLOTOrderWOVO {

	private String customerName;
	private String date;
	private String goodsName;
	private String goodsPrice;
	private String quantity;
	private String totalPrice;
	
	
	
	public BOLOTOrderWOVO() {
	}
	public BOLOTOrderWOVO(String customerName, String date, String goodsName, String goodsPrice, String quantity,
			String totalPrice) {

		this.customerName = customerName;
		this.date = date;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public String getDate() {
		return date;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
