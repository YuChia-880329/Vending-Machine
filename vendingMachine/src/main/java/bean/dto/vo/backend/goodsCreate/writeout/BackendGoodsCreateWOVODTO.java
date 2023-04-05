package bean.dto.vo.backend.goodsCreate.writeout;

public class BackendGoodsCreateWOVODTO {

	private BGCCreateMsgWOVODTO createMsg;

	public BackendGoodsCreateWOVODTO() {
	}
	public BackendGoodsCreateWOVODTO(BGCCreateMsgWOVODTO createMsg) {

		this.createMsg = createMsg;
	}
	
	
	public BGCCreateMsgWOVODTO getCreateMsg() {
		return createMsg;
	}
	
	public void setCreateMsg(BGCCreateMsgWOVODTO createForm) {
		this.createMsg = createForm;
	}
}
