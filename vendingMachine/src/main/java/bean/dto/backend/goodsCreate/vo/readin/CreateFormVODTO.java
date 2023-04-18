package bean.dto.backend.goodsCreate.vo.readin;

import javax.servlet.http.Part;

import enumeration.Status;

public class CreateFormVODTO {

	private String name;
	private String description;
	private int price;
	private int quantity;
	private String imageName;
	private Part imagePart;
	private Status status;
	
	
	public CreateFormVODTO() {
	}
	public CreateFormVODTO(String name, String description, int price, int quantity, String imageName, Part imagePart, Status status) {

		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imageName = imageName;
		this.imagePart = imagePart;
		this.status = status;
	}
	
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageName() {
		return imageName;
	}
	public Part getImagePart() {
		return imagePart;
	}
	public Status getStatus() {
		return status;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setImagePart(Part imagePart) {
		this.imagePart = imagePart;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
