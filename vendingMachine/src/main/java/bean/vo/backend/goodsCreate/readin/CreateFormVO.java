package bean.vo.backend.goodsCreate.readin;

import javax.servlet.http.Part;

public class CreateFormVO {

	private String name;
	private String price;
	private String quantity;
	private String imageName;
	private Part imagePart;
	private String status;
	
	
	public CreateFormVO() {
	}
	public CreateFormVO(String name, String price, String quantity, String imageName, Part imagePart,
			String status) {

		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imageName = imageName;
		this.imagePart = imagePart;
		this.status = status;
	}
	
	
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getImageName() {
		return imageName;
	}
	public Part getImagePart() {
		return imagePart;
	}
	public String getStatus() {
		return status;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setImagePart(Part imagePart) {
		this.imagePart = imagePart;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
