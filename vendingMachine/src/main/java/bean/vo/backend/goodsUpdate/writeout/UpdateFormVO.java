package bean.vo.backend.goodsUpdate.writeout;

public class UpdateFormVO {

	private GoodsNameOptionVO[] goodsNameOptions;

	public UpdateFormVO() {
	}
	public UpdateFormVO(GoodsNameOptionVO[] goodsNameOptions) {

		this.goodsNameOptions = goodsNameOptions;
	}
	
	
	public GoodsNameOptionVO[] getGoodsNameOptions() {
		return goodsNameOptions;
	}
	
	
	public void setGoodsNameOptions(GoodsNameOptionVO[] goodsNameOptions) {
		this.goodsNameOptions = goodsNameOptions;
	}
}
