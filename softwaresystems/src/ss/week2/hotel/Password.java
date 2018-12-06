package ss.week2.hotel;

public class Password {
	public static final java.lang.String INITIAL = "safe123";
	private String suggestion;
	private String pass;
	private String newpass;
	private String oldpass;
	private String test;

	public Password() {
		pass = INITIAL;
	}

	public boolean acceptable(String suggestion) {
		return (suggestion.length() >= 6 && !suggestion.contains(" "));
	}

	public boolean testWord(String test) {
		return (pass.equals(test));
	}

	public boolean setWord(String oldpass, String newpass) {
		if (testWord(oldpass) && acceptable(newpass)) {
			pass = newpass;
			return true;
		} else {
			return false;
		}

	}
}
