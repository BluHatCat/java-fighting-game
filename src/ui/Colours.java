package ui;

/**
 * 
 */
public enum Colours {
	RESET("\u001B[0m"),
	GREY("\u001B[90m"),
	RED("\u001B[31m"),
	GREEN("\u001B[32m"),
	YELLOW("\u001B[33m");
	
	private final String ansiCode;

	Colours(String ansiCode){
		this.ansiCode = ansiCode;
	}
	
	public String code() {
		return ansiCode;
	}

}
