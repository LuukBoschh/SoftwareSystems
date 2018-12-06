package ss.week3.pw;

public class Password {
	public static final java.lang.String INITIAL = "appel";
	protected String pass;
	private Checker check;
	String factoryPassword = "appel";
	
	
	public Password(Checker check) {
		this.check = check;
		this.pass = factoryPassword;
	}
	
	public Password() {
		this(new BasicChecker());
	}
	

	public boolean acceptable(String suggestion) {
		return check.acceptable(suggestion);
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
