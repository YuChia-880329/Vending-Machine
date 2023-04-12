package bean.vo.backend.orderList.writeout;

public class OrderTableRowVO {

	private String customerName;
	private String date;
	private String goodsName;
	private String goodsPrice;
	private String buyQuantity;
	private String totalPrice;
	
	
	
	public OrderTableRowVO() {
	}
	public OrderTableRowVO(String customerName, String date, String goodsName, String goodsPrice, String buyQuantity,
			String totalPrice) {

		this.customerName = customerName;
		this.date = date;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.buyQuantity = buyQuantity;
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
	public String getBuyQuantity() {
		return buyQuantity;
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
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
