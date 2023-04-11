package bean.dto.vo.writeout;

public class PageVODTO {

	private int page;
	private String url;

	public PageVODTO() {
	}
	public PageVODTO(int page, String url) {

		this.page = page;
		this.url = url;
	}
	
	
	public int getPage() {
		return page;
	}
	public String getUrl() {
		return url;
	}
	
	
	public void setPage(int page) {
		this.page = page;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
