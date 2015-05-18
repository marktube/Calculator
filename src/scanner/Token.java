package scanner;

public class Token {
	private String label;
	private String value;
	private String type;

	public Token(String v, String t) {
		value = v;
		type = t;
		label = "";
	}

	public String getType() {
		return type;
	}

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

	public void setLabel(String nl) {
		label = nl;
	}
}
