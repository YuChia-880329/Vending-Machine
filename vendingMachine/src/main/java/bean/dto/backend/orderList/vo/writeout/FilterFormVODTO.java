package bean.dto.backend.orderList.vo.writeout;

import java.time.LocalDate;

public class FilterFormVODTO {

	private String customerName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String goodsName;
	private Integer goodsPriceMin;
	private Integer goodsPriceMax;
	private Integer buyQuantityMin;
	private Integer buyQuantityMax;
	private Integer totalPriceMin;
	private Integer totalPriceMax;
	
	
	public FilterFormVODTO() {
	}
	public FilterFormVODTO(String customerName, LocalDate startDate, LocalDate endDate, String goodsName,
			Integer goodsPriceMin, Integer goodsPriceMax, Integer buyQuantityMin, Integer buyQuantityMax,
			Integer totalPriceMin, Integer totalPriceMax) {

		this.customerName = customerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goodsName = goodsName;
		this.goodsPriceMin = goodsPriceMin;
		this.goodsPriceMax = goodsPriceMax;
		this.buyQuantityMin = buyQuantityMin;
		this.buyQuantityMax = buyQuantityMax;
		this.totalPriceMin = totalPriceMin;
		this.totalPriceMax = totalPriceMax;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public LocalDate getEndDate() {
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
	public Integer getBuyQuantityMin() {
		return buyQuantityMin;
	}
	public Integer getBuyQuantityMax() {
		return buyQuantityMax;
	}
	public Integer getTotalPriceMin() {
		return totalPriceMin;
	}
	public Integer getTotalPriceMax() {
		return totalPriceMax;
	}
	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(LocalDate endDate) {
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
	public void setBuyQuantityMin(Integer buyQuantityMin) {
		this.buyQuantityMin = buyQuantityMin;
	}
	public void setBuyQuantityMax(Integer buyQuantityMax) {
		this.buyQuantityMax = buyQuantityMax;
	}
	public void setTotalPriceMin(Integer totalPriceMin) {
		this.totalPriceMin = totalPriceMin;
	}
	public void setTotalPriceMax(Integer totalPriceMax) {
		this.totalPriceMax = totalPriceMax;
	}
}
