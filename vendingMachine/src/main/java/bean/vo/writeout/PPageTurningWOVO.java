package bean.vo.writeout;

public class PPageTurningWOVO {

	private String existence;
	private String url;
	
	
	public PPageTurningWOVO() {
	}
	public PPageTurningWOVO(String existence, String url) {

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
