package bean.dto.vo.writeout;

import enumeration.Has;

public class PPageTurningWOVODTO {

	private Has existence;
	private String url;
	
	public PPageTurningWOVODTO() {
	}
	public PPageTurningWOVODTO(Has existence, String url) {

		this.existence = existence;
		this.url = url;
	}
	
	
	public Has getExistence() {
		return existence;
	}
	public String getUrl() {
		return url;
	}
	
	
	public void setExistence(Has existence) {
		this.existence = existence;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
