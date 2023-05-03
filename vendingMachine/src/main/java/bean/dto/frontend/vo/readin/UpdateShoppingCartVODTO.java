package bean.dto.frontend.vo.readin;

import java.util.List;

public class UpdateShoppingCartVODTO {

	private String currentUrl;
	private List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList;
	
	
	public UpdateShoppingCartVODTO() {
	}
	public UpdateShoppingCartVODTO(String currentUrl, List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList) {

		this.currentUrl = currentUrl;
		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public List<UpdateShoppingCartGoodsVODTO> getUpdateShoppingCartGoodsList() {
		return updateShoppingCartGoodsList;
	}
	
	
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setUpdateShoppingCartGoodsList(List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList) {
		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
	}
}
