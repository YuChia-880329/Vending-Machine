package bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout;

import java.util.List;

public class GoodsTableOBJDTO {

	private List<GoodsOBJDTO> goodsList;

	public GoodsTableOBJDTO() {
	}
	public GoodsTableOBJDTO(List<GoodsOBJDTO> goodsList) {

		this.goodsList = goodsList;
	}
	
	
	public List<GoodsOBJDTO> getGoodsList() {
		return goodsList;
	}
	
	
	public void setGoodsList(List<GoodsOBJDTO> goodsList) {
		this.goodsList = goodsList;
	}
}
