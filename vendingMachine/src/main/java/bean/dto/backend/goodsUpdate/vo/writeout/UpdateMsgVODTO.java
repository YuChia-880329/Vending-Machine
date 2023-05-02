package bean.dto.backend.goodsUpdate.vo.writeout;

public class UpdateMsgVODTO {

	private boolean success;
	private int id;
	private String name;

	public UpdateMsgVODTO() {
	}
	public UpdateMsgVODTO(boolean success, int id, String name) {

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
