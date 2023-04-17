package bean.dto.backend.goodsCreate.vo.writeout;

public class CreateResultVODTO {

	private CreateMsgVODTO createMsg;

	public CreateResultVODTO() {
	}
	public CreateResultVODTO(CreateMsgVODTO createMsg) {

		this.createMsg = createMsg;
	}
	
	
	public CreateMsgVODTO getCreateMsg() {
		return createMsg;
	}
	
	public void setCreateMsg(CreateMsgVODTO createMsg) {
		this.createMsg = createMsg;
	}
}
