package bean.vo.backend.goodsUpdate.writeout;

import java.util.List;

public class UpdateFormVO {

	private List<GoodsNameOptionVO> goodsNameOptions;
	private GoodsVO currentGoods;

	public UpdateFormVO() {
	}
	public UpdateFormVO(List<GoodsNameOptionVO> goodsNameOptions, GoodsVO currentGoods) {

		this.goodsNameOptions = goodsNameOptions;
		this.currentGoods = currentGoods;
	}
	
	
	public List<GoodsNameOptionVO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	public GoodsVO getCurrentGoods() {
		return currentGoods;
	}
	
	
	public void setGoodsNameOptions(List<GoodsNameOptionVO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
	public void setCurrentGoods(GoodsVO currentGoods) {
		this.currentGoods = currentGoods;
	}
}
