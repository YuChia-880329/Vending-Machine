package bean.vo.backend.goodsUpdate.writeout;

public class UpdateMsgVO {

	private String hasMsg;
	private String msg;

	public UpdateMsgVO() {
	}
	public UpdateMsgVO(String hasMsg, String msg) {

		this.hasMsg = hasMsg;
		this.msg = msg;
	}
	
	public String getHasMsg() {
		return hasMsg;
	}
	public String getMsg() {
		return msg;
	}
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
