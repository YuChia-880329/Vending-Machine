package bean.vo.backend.goodsUpdate.writeout;

public class UpdateResultVO {

	private UpdateMsgVO updateMsg;

	public UpdateResultVO() {
	}
	public UpdateResultVO(UpdateMsgVO updateMsg) {

		this.updateMsg = updateMsg;
	}
	
	
	public UpdateMsgVO getUpdateMsg() {
		return updateMsg;
	}
	
	
	public void setUpdateMsg(UpdateMsgVO updateMsg) {
		this.updateMsg = updateMsg;
	}
}
