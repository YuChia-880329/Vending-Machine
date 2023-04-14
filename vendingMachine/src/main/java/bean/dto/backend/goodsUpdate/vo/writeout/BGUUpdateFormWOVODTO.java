package bean.dto.backend.goodsUpdate.vo.writeout;

import java.util.List;

public class BGUUpdateFormWOVODTO {

	private List<BGUUFGoodsNameOptionWOVODTO> goodsNameOptions;
	private BGUUFGoodsWOVODTO currentGoods;

	public BGUUpdateFormWOVODTO() {
	}
	public BGUUpdateFormWOVODTO(List<BGUUFGoodsNameOptionWOVODTO> goodsNameOptions, BGUUFGoodsWOVODTO currentGoods) {

		this.goodsNameOptions = goodsNameOptions;
		this.currentGoods = currentGoods;
	}
	
	
	public List<BGUUFGoodsNameOptionWOVODTO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	public BGUUFGoodsWOVODTO getCurrentGoods() {
		return currentGoods;
	}
	
	
	public void setGoodsNameOptions(List<BGUUFGoodsNameOptionWOVODTO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
	public void setCurrentGoods(BGUUFGoodsWOVODTO currentGoods) {
		this.currentGoods = currentGoods;
	}
}
