package bean.dto.vo.backend.orderList.readin;

import java.time.LocalDateTime;

public class BOLPageParameterRIVODTO {

	private Integer page;
	private String customerName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String goodsName;
	private Integer goodsPriceMin;
	private Integer goodsPriceMax;
	private Integer quantityMin;
	private Integer quantityMax;
	private Integer totalPriceMin;
	private Integer totalPriceMax;
	
	
	public BOLPageParameterRIVODTO() {
	}
	public BOLPageParameterRIVODTO(Integer page, String customerName, LocalDateTime startDate, LocalDateTime endDate,
			String goodsName, Integer goodsPriceMin, Integer goodsPriceMax, Integer quantityMin, Integer quantityMax,
			Integer totalPriceMin, Integer totalPriceMax) {

		this.page = page;
		this.customerName = customerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goodsName = goodsName;
		this.goodsPriceMin = goodsPriceMin;
		this.goodsPriceMax = goodsPriceMax;
		this.quantityMin = quantityMin;
		this.quantityMax = quantityMax;
		this.totalPriceMin = totalPriceMin;
		this.totalPriceMax = totalPriceMax;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public String getCustomerName() {
		return customerName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public Integer getGoodsPriceMin() {
		return goodsPriceMin;
	}
	public Integer getGoodsPriceMax() {
		return goodsPriceMax;
	}
	public Integer getQuantityMin() {
		return quantityMin;
	}
	public Integer getQuantityMax() {
		return quantityMax;
	}
	public Integer getTotalPriceMin() {
		return totalPriceMin;
	}
	public Integer getTotalPriceMax() {
		return totalPriceMax;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setGoodsPriceMin(Integer goodsPriceMin) {
		this.goodsPriceMin = goodsPriceMin;
	}
	public void setGoodsPriceMax(Integer goodsPriceMax) {
		this.goodsPriceMax = goodsPriceMax;
	}
	public void setQuantityMin(Integer quantityMin) {
		this.quantityMin = quantityMin;
	}
	public void setQuantityMax(Integer quantityMax) {
		this.quantityMax = quantityMax;
	}
	public void setTotalPriceMin(Integer totalPriceMin) {
		this.totalPriceMin = totalPriceMin;
	}
	public void setTotalPriceMax(Integer totalPriceMax) {
		this.totalPriceMax = totalPriceMax;
	}
}
