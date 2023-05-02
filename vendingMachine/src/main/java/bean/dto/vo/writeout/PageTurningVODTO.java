package bean.dto.vo.writeout;

public class PageTurningVODTO {

	private boolean existence;
	private String url;
	
	public PageTurningVODTO() {
	}
	public PageTurningVODTO(boolean existence, String url) {

		this.existence = existence;
		this.url = url;
	}
	
	
	public boolean getExistence() {
		return existence;
	}
	public String getUrl() {
		return url;
	}
	
	
	public void setExistence(boolean existence) {
		this.existence = existence;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
