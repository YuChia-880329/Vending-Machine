package bean.dto.vo.frontend.writeout;

public class FGTGoodsWOVODTO {

	private int id;
	private int idForPage;
	private String name;
	private int price;
	private String imageName;
	private int buyQuantity;
	private int inStockQuantity;
	
	
	public FGTGoodsWOVODTO() {
	}
	public FGTGoodsWOVODTO(int id, int idForPage, String name, int price, String imageName, int buyQuantity,
			int inStockQuantity) {

		this.id = id;
		this.idForPage = idForPage;
		this.name = name;
		this.price = price;
		this.imageName = imageName;
		this.buyQuantity = buyQuantity;
		this.inStockQuantity = inStockQuantity;
	}
	
	
	public int getId() {
		return id;
	}
	public int getIdForPage() {
		return idForPage;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImageName() {
		return imageName;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public int getInStockQuantity() {
		return inStockQuantity;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setIdForPage(int idForPage) {
		this.idForPage = idForPage;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setInStockQuantity(int inStockQuantity) {
		this.inStockQuantity = inStockQuantity;
	}
}
