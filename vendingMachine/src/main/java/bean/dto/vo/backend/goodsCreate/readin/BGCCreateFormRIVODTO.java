package bean.dto.vo.backend.goodsCreate.readin;

import javax.servlet.http.Part;

import enumeration.Status;

public class BGCCreateFormRIVODTO {

	private String name;
	private int price;
	private int quantity;
	private String imageName;
	private Part imagePart;
	private Status status;
	
	
	public BGCCreateFormRIVODTO() {
	}
	public BGCCreateFormRIVODTO(String name, int price, int quantity, String imageName, Part imagePart, Status status) {

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
