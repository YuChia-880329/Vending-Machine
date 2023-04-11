package bean.vo.writeout;

public class PageTurningVO {

	private String existence;
	private String url;
	
	
	public PageTurningVO() {
	}
	public PageTurningVO(String existence, String url) {

		this.existence = existence;
		this.url = url;
	}
	
	
	public String getExistence() {
		return existence;
	}
	public String getUrl() {
		return url;
	}
	
	
	public void setExistence(String existence) {
		this.existence = existence;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
