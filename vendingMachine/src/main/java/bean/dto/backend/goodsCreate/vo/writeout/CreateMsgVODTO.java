package bean.dto.backend.goodsCreate.vo.writeout;

public class CreateMsgVODTO {

	private boolean success;
	private int id;
	private String name;

	public CreateMsgVODTO() {
	}
	public CreateMsgVODTO(boolean success, int id, String name) {

		this.success = success;
		this.id = id;
		this.name = name;
	}
	
	
	public boolean getSuccess() {
		return success;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
