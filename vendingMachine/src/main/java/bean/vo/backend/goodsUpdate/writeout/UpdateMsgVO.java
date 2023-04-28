package bean.vo.backend.goodsUpdate.writeout;

public class UpdateMsgVO {

	private String success;
	private String id;
	private String name;
	

	public UpdateMsgVO() {
	}
	public UpdateMsgVO(String success, String id, String name) {
	
		this.success = success;
		this.id = id;
		this.name = name;
	}
	
	
	public String getSuccess() {
		return success;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setSuccess(String success) {
		this.success = success;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
