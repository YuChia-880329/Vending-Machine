package bean.dto.frontend.obj.memoryDb.msg;

public class NameOBJDTO {

	private int id;
	private String name;

	public NameOBJDTO() {
	}
	public NameOBJDTO(int id, String name) {

		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
