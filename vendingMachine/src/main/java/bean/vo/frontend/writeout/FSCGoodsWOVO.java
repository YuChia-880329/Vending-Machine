package bean.vo.frontend.writeout;

public class FSCGoodsWOVO {

	private String name;
	private String buyQuantity;
	private String price;
	
	
	public FSCGoodsWOVO() {
	}
	public FSCGoodsWOVO(String name, String buyQuantity, String price) {

		this.name = name;
		this.buyQuantity = buyQuantity;
		this.price = price;
	}



	public String getName() {
		return name;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	public String getPrice() {
		return price;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
