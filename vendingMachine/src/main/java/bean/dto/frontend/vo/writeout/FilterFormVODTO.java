package bean.dto.frontend.vo.writeout;

public class FilterFormVODTO {

	private String name;

	public FilterFormVODTO() {
	}
	public FilterFormVODTO(String name) {

		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
}
