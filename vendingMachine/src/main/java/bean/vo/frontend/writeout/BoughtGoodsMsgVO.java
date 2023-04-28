package bean.vo.frontend.writeout;

public class BoughtGoodsMsgVO {

	private String name;
	private String price;
	private String buyQuantity;
	
	
	public BoughtGoodsMsgVO() {
	}
	public BoughtGoodsMsgVO(String name, String price, String buyQuantity) {

		this.name = name;
		this.price = price;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
