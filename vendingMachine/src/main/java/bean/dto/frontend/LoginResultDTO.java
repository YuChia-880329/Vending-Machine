package bean.dto.frontend;

public class LoginResultDTO {

	private boolean success;

	public LoginResultDTO() {
	}
	public LoginResultDTO(boolean success) {

		this.success = success;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
