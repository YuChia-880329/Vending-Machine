package bean.dto.vo.frontend.readin;

public class FPageParameterRIVODTO {

	private Integer page;
	private String name;

	public FPageParameterRIVODTO() {
	}
	public FPageParameterRIVODTO(Integer page, String name) {

		this.page = page;
		this.name = name;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public String getName() {
		return name;
	}
	
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setName(String name) {
		this.name = name;
	}
}
