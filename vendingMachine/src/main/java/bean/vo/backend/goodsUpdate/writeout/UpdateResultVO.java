package bean.vo.backend.goodsUpdate.writeout;

public class UpdateResultVO {

	private UpdateMsgVO updateMsg;
	private UpdateResultFormVO updateResultForm;

	public UpdateResultVO() {
	}
	public UpdateResultVO(UpdateMsgVO updateMsg, UpdateResultFormVO updateResultForm) {

		this.updateMsg = updateMsg;
		this.updateResultForm = updateResultForm;
	}
	
	
	public UpdateMsgVO getUpdateMsg() {
		return updateMsg;
	}
	public UpdateResultFormVO getUpdateResultForm() {
		return updateResultForm;
	}

	
	public void setUpdateMsg(UpdateMsgVO updateMsg) {
		this.updateMsg = updateMsg;
	}
	public void setUpdateResultForm(UpdateResultFormVO updateResultForm) {
		this.updateResultForm = updateResultForm;
	}
}
