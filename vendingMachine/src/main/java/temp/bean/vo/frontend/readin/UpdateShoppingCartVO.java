package temp.bean.vo.frontend.readin;

import bean.vo.frontend.readin.UpdateShoppingCartGoodsVO;

public class UpdateShoppingCartVO {

	private UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray;

	
	
	public UpdateShoppingCartVO() {
	}
	public UpdateShoppingCartVO(UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray) {

		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
	}
	
	
	public UpdateShoppingCartGoodsVO[] getUpdateShoppingCartGoodsArray() {
		return updateShoppingCartGoodsArray;
	}

	
	
	public void setUpdateShoppingCartGoodsArray(UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray) {
		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
	}
}
