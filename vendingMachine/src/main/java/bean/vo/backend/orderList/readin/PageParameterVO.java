package bean.vo.backend.orderList.readin;

public class PageParameterVO {

	private String page;
	private String customerName;
	private String startDate;
	private String endDate;
	private String goodsName;
	private String goodsPriceMin;
	private String goodsPriceMax;
	private String buyQuantityMin;
	private String buyQuantityMax;
	private String totalPriceMin;
	private String totalPriceMax;
	
	
	public PageParameterVO() {
	}
	public PageParameterVO(String page, String customerName, String startDate, String endDate, String goodsName,
			String goodsPriceMin, String goodsPriceMax, String buyQuantityMin, String buyQuantityMax, String totalPriceMin,
			String totalPriceMax) {

		this.page = page;
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



	public String getPage() {
		return page;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public String getGoodsPriceMin() {
		return goodsPriceMin;
	}
	public String getGoodsPriceMax() {
		return goodsPriceMax;
	}
	public String getBuyQuantityMin() {
		return buyQuantityMin;
	}
	public String getBuyQuantityMax() {
		return buyQuantityMax;
	}
	public String getTotalPriceMin() {
		return totalPriceMin;
	}
	public String getTotalPriceMax() {
		return totalPriceMax;
	}
	
	
	public void setPage(String page) {
		this.page = page;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setGoodsPriceMin(String goodsPriceMin) {
		this.goodsPriceMin = goodsPriceMin;
	}
	public void setGoodsPriceMax(String goodsPriceMax) {
		this.goodsPriceMax = goodsPriceMax;
	}
	public void setBuyQuantityMin(String buyQuantityMin) {
		this.buyQuantityMin = buyQuantityMin;
	}
	public void setBuyQuantityMax(String buyQuantityMax) {
		this.buyQuantityMax = buyQuantityMax;
	}
	public void setTotalPriceMin(String totalPriceMin) {
		this.totalPriceMin = totalPriceMin;
	}
	public void setTotalPriceMax(String totalPriceMax) {
		this.totalPriceMax = totalPriceMax;
	}
}
