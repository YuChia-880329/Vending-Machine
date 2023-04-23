package bean.dto.frontend.vo.readin;

import java.util.List;

public class AddShoppingCartVODTO {

	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;
	private String queryString;

	public AddShoppingCartVODTO() {
	}
	public AddShoppingCartVODTO(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList, String queryString) {
		
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
		this.queryString = queryString;
	}
	
	
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}
	public String getQueryString() {
		return queryString;
	}

	
	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
