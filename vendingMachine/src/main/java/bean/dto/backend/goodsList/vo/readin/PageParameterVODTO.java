package bean.dto.backend.goodsList.vo.readin;

import enumeration.Status;

public class PageParameterVODTO {

	private Integer page;
	private Integer idMin;
	private Integer idMax;
	private String name;
	private Integer priceMin;
	private Integer priceMax;
	private Integer quantityMin;
	private Integer quantityMax;
	private Status status;
	
	
	public PageParameterVODTO() {
	}
	public PageParameterVODTO(Integer page, Integer idMin, Integer idMax, String name, Integer priceMin,
			Integer priceMax, Integer quantityMin, Integer quantityMax, Status status) {

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
	
	
	public Integer getPage() {
		return page;
	}
	public Integer getIdMin() {
		return idMin;
	}
	public Integer getIdMax() {
		return idMax;
	}
	public String getName() {
		return name;
	}
	public Integer getPriceMin() {
		return priceMin;
	}
	public Integer getPriceMax() {
		return priceMax;
	}
	public Integer getQuantityMin() {
		return quantityMin;
	}
	public Integer getQuantityMax() {
		return quantityMax;
	}
	public Status getStatus() {
		return status;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setIdMin(Integer idMin) {
		this.idMin = idMin;
	}
	public void setIdMax(Integer idMax) {
		this.idMax = idMax;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}
	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
	}
	public void setQuantityMin(Integer quantityMin) {
		this.quantityMin = quantityMin;
	}
	public void setQuantityMax(Integer quantityMax) {
		this.quantityMax = quantityMax;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
