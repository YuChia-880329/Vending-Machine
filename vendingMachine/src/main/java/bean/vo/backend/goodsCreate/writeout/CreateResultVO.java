package bean.vo.backend.goodsCreate.writeout;

public class CreateResultVO {

	private CreateMsgVO createMsg;

	public CreateResultVO() {
	}
	public CreateResultVO(CreateMsgVO createMsg) {

		this.createMsg = createMsg;
	}
	
	
	public CreateMsgVO getCreateMsg() {
		return createMsg;
	}
	
	
	public void setCreateMsg(CreateMsgVO createMsg) {
		this.createMsg = createMsg;
	}
}
