package bean.vo.backend.goodsUpdate.writeout;

import java.util.List;

public class UpdateFormVO {

	private List<GoodsNameOptionVO> goodsNameOptions;
	private UpdateFormGoodsVO currentGoods;

	public UpdateFormVO() {
	}
	public UpdateFormVO(List<GoodsNameOptionVO> goodsNameOptions, UpdateFormGoodsVO currentGoods) {

		this.goodsNameOptions = goodsNameOptions;
		this.currentGoods = currentGoods;
	}
	
	
	public List<GoodsNameOptionVO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	public UpdateFormGoodsVO getCurrentGoods() {
		return currentGoods;
	}
	
	
	public void setGoodsNameOptions(List<GoodsNameOptionVO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
	public void setCurrentGoods(UpdateFormGoodsVO currentGoods) {
		this.currentGoods = currentGoods;
	}
}
