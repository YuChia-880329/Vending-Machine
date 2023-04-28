package bean.dto.backend.goodsUpdate.vo.writeout;

import enumeration.Has;

public class UpdateMsgVODTO {

	private Has success;
	private int id;
	private String name;

	public UpdateMsgVODTO() {
	}
	public UpdateMsgVODTO(Has success, int id, String name) {

		this.success = success;
		this.id = id;
		this.name = name;
	}
	
	
	public Has getSuccess() {
		return success;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setSuccess(Has success) {
		this.success = success;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
