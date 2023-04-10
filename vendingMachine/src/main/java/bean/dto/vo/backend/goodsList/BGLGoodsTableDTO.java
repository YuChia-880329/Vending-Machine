package bean.dto.vo.backend.goodsList;

import java.util.List;

import bean.dto.model.GoodsModelDTO;

public class BGLGoodsTableDTO {

	private List<GoodsModelDTO> goodsList;

	public BGLGoodsTableDTO() {
	}
	public BGLGoodsTableDTO(List<GoodsModelDTO> goodsList) {

		this.goodsList = goodsList;
	}
	
	
	public List<GoodsModelDTO> getGoodsList() {
		return goodsList;
	}
	
	
	public void setGoodsList(List<GoodsModelDTO> goodsList) {
		this.goodsList = goodsList;
	}
}
