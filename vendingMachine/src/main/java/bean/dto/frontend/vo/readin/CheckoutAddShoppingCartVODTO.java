package bean.dto.frontend.vo.readin;

import java.util.List;

public class CheckoutAddShoppingCartVODTO {

	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;

	public CheckoutAddShoppingCartVODTO() {
	}
	public CheckoutAddShoppingCartVODTO(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {

		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	
	
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}
	
	
	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
}
