package bean.dto.frontend.vo.writeout;

import java.util.List;

public class ShoppingCartVODTO {

	private int goodsCount;
	private List<ShoppingCartGoodsVODTO> shoppingCartGoodsList;

	public ShoppingCartVODTO() {
	}
	public ShoppingCartVODTO(int goodsCount, List<ShoppingCartGoodsVODTO> shoppingCartGoodsList) {

		this.goodsCount = goodsCount;
		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
	
	
	
	public int getGoodsCount() {
		return goodsCount;
	}
	public List<ShoppingCartGoodsVODTO> getShoppingCartGoodsList() {
		return shoppingCartGoodsList;
	}
	
	
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public void setShoppingCartGoodsList(List<ShoppingCartGoodsVODTO> shoppingCartGoodsList) {
		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
}
