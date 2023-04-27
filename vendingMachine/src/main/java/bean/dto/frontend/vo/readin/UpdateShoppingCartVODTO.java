package bean.dto.frontend.vo.readin;

import java.util.List;

public class UpdateShoppingCartVODTO {

	private List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList;
	private String queryString;
	
	
	public UpdateShoppingCartVODTO() {
	}
	public UpdateShoppingCartVODTO(List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList, String queryString) {

		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
		this.queryString = queryString;
	}
	
	
	public List<UpdateShoppingCartGoodsVODTO> getUpdateShoppingCartGoodsList() {
		return updateShoppingCartGoodsList;
	}
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setUpdateShoppingCartGoodsList(List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsList) {
		this.updateShoppingCartGoodsList = updateShoppingCartGoodsList;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
