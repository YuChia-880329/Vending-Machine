package bean.vo.login.writeout;

public class BackgroundVO {

	private String imagePath;

	public BackgroundVO() {
	}
	public BackgroundVO(String imagePath) {

		this.imagePath = imagePath;
	}
	
	
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
