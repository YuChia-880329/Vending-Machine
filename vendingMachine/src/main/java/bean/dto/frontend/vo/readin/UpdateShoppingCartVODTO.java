package bean.dto.frontend.vo.readin;

import java.util.List;

public class UpdateShoppingCartVODTO {

	private List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList;
	
	
	public UpdateShoppingCartVODTO() {
	}
	public UpdateShoppingCartVODTO(List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList) {

		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
	}
	
	
	public List<UpdateShoppingCartGoodsVODTO> getUpdateShoppingCartGoodsList() {
		return updateShoppingCartGoodsList;
	}
	
	
	public void setUpdateShoppingCartGoodsList(List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList) {
		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
	}
}
