package bean.dto.backend.goodsUpdate.vo.writeout;

public class UpdateResultVODTO {

	private UpdateMsgVODTO updateMsg;
	private UpdateResultFormVODTO updateResultForm;

	public UpdateResultVODTO() {
	}
	public UpdateResultVODTO(UpdateMsgVODTO updateMsg, UpdateResultFormVODTO updateResultForm) {
		
		this.updateMsg = updateMsg;
		this.updateResultForm = updateResultForm;
	}
	
	
	public UpdateMsgVODTO getUpdateMsg() {
		return updateMsg;
	}
	public UpdateResultFormVODTO getUpdateResultForm() {
		return updateResultForm;
	}

	
	public void setUpdateMsg(UpdateMsgVODTO updateMsg) {
		this.updateMsg = updateMsg;
	}
	public void setUpdateResultForm(UpdateResultFormVODTO updateResultForm) {
		this.updateResultForm = updateResultForm;
	}
}
