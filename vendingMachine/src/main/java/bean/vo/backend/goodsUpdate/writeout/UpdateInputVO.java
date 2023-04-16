package bean.vo.backend.goodsUpdate.writeout;

public class UpdateInputVO {

	private UpdateFormGoodsVO updateFormGoods;

	public UpdateInputVO() {
	}
	public UpdateInputVO(UpdateFormGoodsVO updateFormGoods) {

		this.updateFormGoods = updateFormGoods;
	}
	
	
	public UpdateFormGoodsVO getUpdateFormGoods() {
		return updateFormGoods;
	}
	
	public void setUpdateFormGoods(UpdateFormGoodsVO updateFormGoods) {
		this.updateFormGoods = updateFormGoods;
	}
}
