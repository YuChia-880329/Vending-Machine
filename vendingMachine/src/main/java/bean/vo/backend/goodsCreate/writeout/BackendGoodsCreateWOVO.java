package bean.vo.backend.goodsCreate.writeout;

public class BackendGoodsCreateWOVO {

	private BGCCreateMsgWOVO createMsg;

	public BackendGoodsCreateWOVO() {
	}
	public BackendGoodsCreateWOVO(BGCCreateMsgWOVO createMsg) {

		this.createMsg = createMsg;
	}
	
	
	public BGCCreateMsgWOVO getCreateMsg() {
		return createMsg;
	}
	
	public void setCreateMsg(BGCCreateMsgWOVO createForm) {
		this.createMsg = createForm;
	}
}
