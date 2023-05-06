package bean.dto.frontend.vo.readin;

import java.util.List;

public class AddShoppingCartVODTO {

	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;


	public AddShoppingCartVODTO() {
	}
	public AddShoppingCartVODTO(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	
	
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}


	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
}
