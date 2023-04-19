package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

public class FilterParameterOBJDTO {

	private String name;

	public FilterParameterOBJDTO() {
	}
	public FilterParameterOBJDTO(String name) {

		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
