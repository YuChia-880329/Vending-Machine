package bean.vo.writeout;

public class PPageWOVO {

	private String page;
	private String url;

	public PPageWOVO() {
	}
	public PPageWOVO(String page, String url) {

		this.page = page;
		this.url = url;
	}
	
	
	public String getPage() {
		return page;
	}
	public String getUrl() {
		return url;
	}

	
	public void setPage(String page) {
		this.page = page;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
