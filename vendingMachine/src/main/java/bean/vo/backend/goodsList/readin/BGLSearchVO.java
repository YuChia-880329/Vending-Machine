package bean.vo.backend.goodsList.readin;

public class BGLSearchVO {

	private String idMin;
	private String idMax;
	private String name;
	private String priceMin;
	private String priceMax;
	private String quantityMin;
	private String quantityMax;
	private String status;
	
	
	public BGLSearchVO() {
	}
	public BGLSearchVO(String idMin, String idMax, String name, String priceMin, String priceMax, String quantityMin,
			String quantityMax, String status) {
		this.idMin = idMin;
		this.idMax = idMax;
		this.name = name;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
		this.status = status;
	}
	
	
	String getIdMin() {
		return idMin;
	}
	String getIdMax() {
		return idMax;
	}
	String getName() {
		return name;
	}
	String getPriceMin() {
		return priceMin;
	}
	String getPriceMax() {
		return priceMax;
	}
	String getQuantityMin() {
		return quantityMin;
	}
	String getQuantityMax() {
		return quantityMax;
	}
	String getStatus() {
		return status;
	}
	
	
	void setIdMin(String idMin) {
		this.idMin = idMin;
	}
	void setIdMax(String idMax) {
		this.idMax = idMax;
	}
	void setName(String name) {
		this.name = name;
	}
	void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}
	void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}
	void setQuantityMin(String quantityMin) {
		this.quantityMin = quantityMin;
	}
	void setQuantityMax(String quantityMax) {
		this.quantityMax = quantityMax;
	}
	void setStatus(String status) {
		this.status = status;
	}
}
