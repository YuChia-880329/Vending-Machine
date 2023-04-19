package bean.vo.frontend.readin;

public class PageParameterVO {

	private String page;
	private String name;

	public PageParameterVO() {
	}
	public PageParameterVO(String page, String name) {

		this.page = page;
		this.name = name;
	}
	
	
	public String getPage() {
		return page;
	}
	public String getName() {
		return name;
	}
	
	
	public void setPage(String page) {
		this.page = page;
	}
	public void setName(String name) {
		this.name = name;
	}
}
