package bean.vo.backend.goodsUpdate.writeout;

import java.util.List;

public class UpdateFormVO {

	private List<GoodsNameOptionVO> goodsNameOptions;

	public UpdateFormVO() {
	}
	public UpdateFormVO(List<GoodsNameOptionVO> goodsNameOptions) {

		this.goodsNameOptions = goodsNameOptions;
	}
	
	
	public List<GoodsNameOptionVO> getGoodsNameOptions() {
		return goodsNameOptions;
	}
	
	
	public void setGoodsNameOptions(List<GoodsNameOptionVO> goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
}
