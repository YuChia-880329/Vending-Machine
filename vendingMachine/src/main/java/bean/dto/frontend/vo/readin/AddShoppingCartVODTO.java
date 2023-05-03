package bean.dto.frontend.vo.readin;

import java.util.List;

public class AddShoppingCartVODTO {

	private String currentUrl;
	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;


	public AddShoppingCartVODTO() {
	}
	public AddShoppingCartVODTO(String currentUrl, List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		
		this.currentUrl = currentUrl;
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}


	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
}
