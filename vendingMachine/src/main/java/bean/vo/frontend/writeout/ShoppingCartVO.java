package bean.vo.frontend.writeout;

import java.util.List;

public class ShoppingCartVO {

	private List<ShoppingCartGoodsVO> shoppingCartGoodsList;

	public ShoppingCartVO() {
	}
	public ShoppingCartVO(List<ShoppingCartGoodsVO> shoppingCartGoodsList) {

		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
	
	
	public List<ShoppingCartGoodsVO> getShoppingCartGoodsList() {
		return shoppingCartGoodsList;
	}
	
	
	public void setShoppingCartGoodsList(List<ShoppingCartGoodsVO> shoppingCartGoodsList) {
		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
}
