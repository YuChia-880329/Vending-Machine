package bean.dto.frontend.vo.writeout;

import java.util.List;

public class ShoppingCartVODTO {

	private List<ShoppingCartGoodsVODTO> shoppingCartGoodsList;

	public ShoppingCartVODTO() {
	}
	public ShoppingCartVODTO(List<ShoppingCartGoodsVODTO> shoppingCartGoodsList) {

		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
	
	
	public List<ShoppingCartGoodsVODTO> getShoppingCartGoodsList() {
		return shoppingCartGoodsList;
	}
	
	
	public void setShoppingCartGoodsList(List<ShoppingCartGoodsVODTO> shoppingCartGoodsList) {
		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
}
