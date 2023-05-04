package bean.dto.login.vo.writeout;

public class BackgroundVODTO {

	private String imagePath;

	public BackgroundVODTO() {
	}
	public BackgroundVODTO(String imagePath) {

		this.imagePath = imagePath;
	}
	
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
