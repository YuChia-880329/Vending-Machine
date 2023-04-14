package bean.vo.backend.goodsUpdate.writeout;

public class BackendGoodsUpdateVO {

	private UpdateMsgVO updateMsg;
	private UpdateFormVO updateForm;

	public BackendGoodsUpdateVO() {
	}
	public BackendGoodsUpdateVO(UpdateMsgVO updateMsg, UpdateFormVO updateForm) {

		this.updateMsg = updateMsg;
		this.updateForm = updateForm;
	}
	
	
	public UpdateMsgVO getUpdateMsg() {
		return updateMsg;
	}
	public UpdateFormVO getUpdateForm() {
		return updateForm;
	}
	
	
	public void setUpdateMsg(UpdateMsgVO updateMsg) {
		this.updateMsg = updateMsg;
	}
	public void setUpdateForm(UpdateFormVO updateForm) {
		this.updateForm = updateForm;
	}
}
