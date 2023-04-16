package enumeration;

public enum Has {

	TRUE(true, "true", 1), FALSE(false, "false", 0);
	
	private boolean value;
	private String description;
	private int code;
	
	
	private Has(boolean value, String description, int code) {
		this.value = value;
		this.description = description;
		this.code = code;
	}


	public boolean isValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public int getCode() {
		
		return code;
	}
	
	public static Has getByDescription(String description) {
		
		if(description == null)
			return null;
		
		if(TRUE.getDescription().equals(description))
			return TRUE;
		else if(FALSE.getDescription().equals(description))
			return FALSE;
		
		return null;
	}
	public static Has getByCode(int code) {
		
		if(code == 1)
			return TRUE;
		else if(code == 0)
			return FALSE;
		else
			return null;
	}
}
