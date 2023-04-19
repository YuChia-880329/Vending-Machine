package bean.dto.frontend.vo.readin;

public class PageParameterVODTO {

	private Integer page;
	private String name;

	public PageParameterVODTO() {
	}
	public PageParameterVODTO(Integer page, String name) {

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
