package enumeration;

public enum Has {

	TRUE(true, "true"), FALSE(false, "false");
	
	private boolean value;
	private String description;
	
	
	private Has(boolean value, String description) {
		this.value = value;
		this.description = description;
	}


	public boolean isValue() {
		return value;
	}
	public String getDescription() {
		return description;
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
}
