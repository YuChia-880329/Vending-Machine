package bean.vo.backend.goodsList.readin;

public class BGLPageParameterRIVO {

	private String page;
	private String idMin;
	private String idMax;
	private String name;
	private String priceMin;
	private String priceMax;
	private String quantityMin;
	private String quantityMax;
	private String status;
	
	
	public BGLPageParameterRIVO() {
	}
	public BGLPageParameterRIVO(String page, String idMin, String idMax, String name, String priceMin, String priceMax,
			String quantityMin, String quantityMax, String status) {
		
		this.page = page;
		this.idMin = idMin;
		this.idMax = idMax;
		this.name = name;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
		this.status = status;
	}
	
	
	public String getPage() {
		return page;
	}
	public String getIdMin() {
		return idMin;
	}
	public String getIdMax() {
		return idMax;
	}
	public String getName() {
		return name;
	}
	public String getPriceMin() {
		return priceMin;
	}
	public String getPriceMax() {
		return priceMax;
	}
	public String getQuantityMin() {
		return quantityMin;
	}
	public String getQuantityMax() {
		return quantityMax;
	}
	public String getStatus() {
		return status;
	}
	
	
	public void setPage(String page) {
		this.page = page;
	}
	public void setIdMin(String idMin) {
		this.idMin = idMin;
	}
	public void setIdMax(String idMax) {
		this.idMax = idMax;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}
	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}
	public void setQuantityMin(String quantityMin) {
		this.quantityMin = quantityMin;
	}
	public void setQuantityMax(String quantityMax) {
		this.quantityMax = quantityMax;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
