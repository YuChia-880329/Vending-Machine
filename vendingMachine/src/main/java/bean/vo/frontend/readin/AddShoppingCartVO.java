package bean.vo.frontend.readin;

public class AddShoppingCartVO {

	private AddShoppingCartGoodsVO[] addShoppingCartGoodsArray;


	public AddShoppingCartVO() {
	}
	public AddShoppingCartVO(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
	
	
	public AddShoppingCartGoodsVO[] getAddShoppingCartGoodsArray() {
		return addShoppingCartGoodsArray;
	}


	public void setAddShoppingCartGoodsArray(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
}
