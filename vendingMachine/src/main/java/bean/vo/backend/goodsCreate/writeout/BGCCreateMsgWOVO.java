package bean.vo.backend.goodsCreate.writeout;

public class BGCCreateMsgWOVO {

	private String hasMessage;
	private String id;

	
	public BGCCreateMsgWOVO() {
	}
	public BGCCreateMsgWOVO(String hasMessage, String id) {

		this.hasMessage = hasMessage;
		this.id = id;
	}
	
	
	public String getHasMessage() {
		return hasMessage;
	}
	public String getId() {
		return id;
	}
	
	
	public void setHasMessage(String hasMessage) {
		this.hasMessage = hasMessage;
	}
	public void setId(String id) {
		this.id = id;
	}
}
