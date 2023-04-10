package memory.repository.backend.goodsList.goodsTablePages;

import enumeration.Status;

class SearchParametersObj {

	private Integer idMin;
	private Integer idMax;
	private String name;
	private Integer priceMin;
	private Integer priceMax;
	private Integer quantityMin;
	private Integer quantityMax;
	private Status status;
	
	
	SearchParametersObj() {
	}
	SearchParametersObj(Integer idMin, Integer idMax, String name, Integer priceMin, Integer priceMax,
			Integer quantityMin, Integer quantityMax, Status status) {
		
		this.idMin = idMin;
		this.idMax = idMax;
		this.name = name;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
		this.status = status;
	}
	
	
	Integer getIdMin() {
		return idMin;
	}
	Integer getIdMax() {
		return idMax;
	}
	String getName() {
		return name;
	}
	Integer getPriceMin() {
		return priceMin;
	}
	Integer getPriceMax() {
		return priceMax;
	}
	Integer getQuantityMin() {
		return quantityMin;
	}
	Integer getQuantityMax() {
		return quantityMax;
	}
	Status getStatus() {
		return status;
	}
	
	
	void setIdMin(Integer idMin) {
		this.idMin = idMin;
	}
	void setIdMax(Integer idMax) {
		this.idMax = idMax;
	}
	void setName(String name) {
		this.name = name;
	}
	void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}
	void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
	void setQuantityMin(Integer quantityMin) {
		this.quantityMin = quantityMin;
	}
	void setQuantityMax(Integer quantityMax) {
		this.quantityMax = quantityMax;
	}
	void setStatus(Status status) {
		this.status = status;
	}
}
