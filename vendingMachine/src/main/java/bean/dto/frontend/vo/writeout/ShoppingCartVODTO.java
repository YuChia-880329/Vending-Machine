package bean.dto.frontend.vo.writeout;

import java.util.List;

public class ShoppingCartVODTO {

	private int goodsCount;
	private List<ShoppingCartGoodsVODTO> shoppingCartGoodsList;
	private int totalPrice;

	public ShoppingCartVODTO() {
	}
	public ShoppingCartVODTO(int goodsCount, List<ShoppingCartGoodsVODTO> shoppingCartGoodsList, int totalPrice) {

		this.goodsCount = goodsCount;
		this.shoppingCartGoodsList = shoppingCartGoodsList;
		this.totalPrice = totalPrice;
	}
	
	
	
	public int getGoodsCount() {
		return goodsCount;
	}
	public List<ShoppingCartGoodsVODTO> getShoppingCartGoodsList() {
		return shoppingCartGoodsList;
	}
	public int getTotalPrice() {
		return totalPrice;
	}

	
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public void setShoppingCartGoodsList(List<ShoppingCartGoodsVODTO> shoppingCartGoodsList) {
		this.shoppingCartGoodsList = shoppingCartGoodsList;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
