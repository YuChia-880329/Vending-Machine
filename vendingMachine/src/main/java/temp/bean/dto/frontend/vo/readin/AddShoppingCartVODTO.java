package temp.bean.dto.frontend.vo.readin;

import java.util.List;

import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;

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
