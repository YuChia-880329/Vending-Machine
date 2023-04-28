package bean.obj.frontend.cache.receiptContent;

public class BoughtGoodsMsgOBJ {

	private String name;
	private int price;
	private int buyQuantity;
	
	
	public BoughtGoodsMsgOBJ() {
	}
	public BoughtGoodsMsgOBJ(String name, int price, int buyQuantity) {

		this.name = name;
		this.price = price;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
