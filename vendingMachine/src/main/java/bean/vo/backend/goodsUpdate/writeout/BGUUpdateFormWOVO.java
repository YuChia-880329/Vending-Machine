package bean.vo.backend.goodsUpdate.writeout;

import java.util.List;

public class BGUUpdateFormWOVO {

	private List<BGUUFGoodsNameOptionWOVO> goodsNameOptions;
	private BGUUFGoodsWOVO currentGoods;

	public BGUUpdateFormWOVO() {
	}
	public BGUUpdateFormWOVO(List<BGUUFGoodsNameOptionWOVO> goodsNameOptions, BGUUFGoodsWOVO currentGoods) {

		this.goodsNameOptions = goodsNameOptions;
		this.currentGoods = currentGoods;
	}
	
	
	public List<BGUUFGoodsNameOptionWOVO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	public BGUUFGoodsWOVO getCurrentGoods() {
		return currentGoods;
	}
	
	
	public void setGoodsNameOptions(List<BGUUFGoodsNameOptionWOVO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
	public void setCurrentGoods(BGUUFGoodsWOVO currentGoods) {
		this.currentGoods = currentGoods;
	}
}
