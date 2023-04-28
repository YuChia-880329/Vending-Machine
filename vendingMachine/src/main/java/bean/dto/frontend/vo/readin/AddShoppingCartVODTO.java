package bean.dto.frontend.vo.readin;

import java.util.List;

public class AddShoppingCartVODTO {

	private String queryString;
	private List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList;


	public AddShoppingCartVODTO() {
	}
	public AddShoppingCartVODTO(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList, String queryString) {
		
		this.queryString = queryString;
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	public List<AddShoppingCartGoodsVODTO> getAddShoppingCartGoodsList() {
		return addShoppingCartGoodsList;
	}


	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public void setAddShoppingCartGoodsList(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList) {
		this.addShoppingCartGoodsList = addShoppingCartGoodsList;
	}
}
