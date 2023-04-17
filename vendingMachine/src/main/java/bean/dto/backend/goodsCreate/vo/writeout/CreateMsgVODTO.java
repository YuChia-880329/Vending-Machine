package bean.dto.backend.goodsCreate.vo.writeout;

public class CreateMsgVODTO {

	private String msg;

	
	public CreateMsgVODTO() {
	}
	public CreateMsgVODTO(String msg) {

		this.msg = msg;
	}
	

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
