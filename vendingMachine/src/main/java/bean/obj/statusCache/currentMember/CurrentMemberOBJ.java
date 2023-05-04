package bean.obj.statusCache.currentMember;

public class CurrentMemberOBJ {

	private String id;
	private String name;
	
	
	public CurrentMemberOBJ() {
	}
	public CurrentMemberOBJ(String id, String name) {

		this.id = id;
		this.name = name;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
