package bean.dto.frontend.vo.readin;

import java.util.List;

public class CheckoutVODTO {

	private String queryString;
	private CheckoutFormVODTO checkoutForm;
	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;
	
	
	public CheckoutVODTO() {
	}
	public CheckoutVODTO(String queryString, CheckoutFormVODTO checkoutForm, List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {

		this.queryString = queryString;
		this.checkoutForm = checkoutForm;
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	public CheckoutFormVODTO getCheckoutForm() {
		return checkoutForm;
	}
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}
	
	

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public void setCheckoutForm(CheckoutFormVODTO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
}
