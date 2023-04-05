package bean.dto.vo.backend.goodsUpdate.writeout;

public class BackendGoodsUpdateWOVODTO {

	private BGUUpdateMsgWOVODTO updateMsg;
	private BGUUpdateFormWOVODTO updateForm;

	public BackendGoodsUpdateWOVODTO() {
	}
	public BackendGoodsUpdateWOVODTO(BGUUpdateMsgWOVODTO updateMsg, BGUUpdateFormWOVODTO updateForm) {

		this.updateMsg = updateMsg;
		this.updateForm = updateForm;
	}
	
	
	public BGUUpdateMsgWOVODTO getUpdateMsg() {
		return updateMsg;
	}
	public BGUUpdateFormWOVODTO getUpdateForm() {
		return updateForm;
	}
	
	
	public void setUpdateMsg(BGUUpdateMsgWOVODTO updateMsg) {
		this.updateMsg = updateMsg;
	}
	public void setUpdateForm(BGUUpdateFormWOVODTO updateForm) {
		this.updateForm = updateForm;
	}
}
