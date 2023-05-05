package temp.bean.vo.frontend.readin;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;

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
