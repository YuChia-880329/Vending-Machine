package bean.vo.frontend.readin;

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
