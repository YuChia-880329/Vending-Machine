package enumeration;

public enum Status {

	ON(1, "上架"), OFF(0, "下架");
	
	private int value;
	private String description;
	
	private Status(int value, String description) {
		
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	
	public static Status getByDescription(String description) {
		
		if(description == null)
			return null;
		
		if(ON.getDescription().equals(description))
			return ON;
		else if(OFF.getDescription().equals(description))
			return OFF;
		
		return null;
	}
}
