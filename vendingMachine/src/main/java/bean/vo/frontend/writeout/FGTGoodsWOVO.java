package bean.vo.frontend.writeout;

public class FGTGoodsWOVO {

	private String id;
	private String idForPage;
	private String name;
	private String price;
	private String imageName;
	private String buyQuantity;
	private String inStockQuantity;
	
	
	public FGTGoodsWOVO() {
	}
	public FGTGoodsWOVO(String id, String idForPage, String name, String price, String imageName, String buyQuantity,
			String inStockQuantity) {

		this.id = id;
		this.idForPage = idForPage;
		this.name = name;
		this.price = price;
		this.imageName = imageName;
		this.buyQuantity = buyQuantity;
		this.inStockQuantity = inStockQuantity;
	}
	
	
	public String getId() {
		return id;
	}
	public String getIdForPage() {
		return idForPage;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getImageName() {
		return imageName;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	public String getInStockQuantity() {
		return inStockQuantity;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setIdForPage(String idForPage) {
		this.idForPage = idForPage;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setInStockQuantity(String inStockQuantity) {
		this.inStockQuantity = inStockQuantity;
	}
}
