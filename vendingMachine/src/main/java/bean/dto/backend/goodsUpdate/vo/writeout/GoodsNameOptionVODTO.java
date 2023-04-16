package bean.dto.backend.goodsUpdate.vo.writeout;

public class GoodsNameOptionVODTO {

	private int id;
	private String name;
	
	
	public GoodsNameOptionVODTO() {
	}
	public GoodsNameOptionVODTO(int id, String name) {
		
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
