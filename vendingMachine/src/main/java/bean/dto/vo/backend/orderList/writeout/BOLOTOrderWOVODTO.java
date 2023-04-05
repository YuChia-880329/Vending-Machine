package bean.dto.vo.backend.orderList.writeout;

public class BOLOTOrderWOVODTO {

	private String customerName;
	private String date;
	private String goodsName;
	private int goodsPrice;
	private int quantity;
	private int totalPrice;
	
	
	
	public BOLOTOrderWOVODTO() {
	}
	public BOLOTOrderWOVODTO(String customerName, String date, String goodsName, int goodsPrice, int quantity,
			int totalPrice) {

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
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getTotalPrice() {
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
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
