package bean.dto.backend.goodsUpdate.vo.writeout;

public class UpdateInputVODTO {

	private UpdateFormGoodsVODTO updateFormGoods;

	public UpdateInputVODTO() {
	}
	public UpdateInputVODTO(UpdateFormGoodsVODTO updateFormGoods) {

		this.updateFormGoods = updateFormGoods;
	}
	
	
	public UpdateFormGoodsVODTO getUpdateFormGoods() {
		return updateFormGoods;
	}
	
	
	public void setUpdateFormGoods(UpdateFormGoodsVODTO updateFormGoods) {
		this.updateFormGoods = updateFormGoods;
	}
}
