package bean.dto.backend.goodsUpdate.vo.writeout;

public class UpdateResultVODTO {

	private UpdateMsgVODTO updateMsg;

	public UpdateResultVODTO() {
	}
	public UpdateResultVODTO(UpdateMsgVODTO updateMsg) {
		
		this.updateMsg = updateMsg;
	}
	
	
	public UpdateMsgVODTO getUpdateMsg() {
		return updateMsg;
	}
	
	
	public void setUpdateMsg(UpdateMsgVODTO updateMsg) {
		this.updateMsg = updateMsg;
	}
}
