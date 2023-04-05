package bean.vo.backend.goodsUpdate.writeout;

public class BackendGoodsUpdateWOVO {

	private BGUUpdateMsgWOVO updateMsg;
	private BGUUpdateFormWOVO updateForm;

	public BackendGoodsUpdateWOVO() {
	}
	public BackendGoodsUpdateWOVO(BGUUpdateMsgWOVO updateMsg, BGUUpdateFormWOVO updateForm) {

		this.updateMsg = updateMsg;
		this.updateForm = updateForm;
	}
	
	
	public BGUUpdateMsgWOVO getUpdateMsg() {
		return updateMsg;
	}
	public BGUUpdateFormWOVO getUpdateForm() {
		return updateForm;
	}
	
	
	public void setUpdateMsg(BGUUpdateMsgWOVO updateMsg) {
		this.updateMsg = updateMsg;
	}
	public void setUpdateForm(BGUUpdateFormWOVO updateForm) {
		this.updateForm = updateForm;
	}
}
