package ss.week3.pw;

public class BasicChecker implements Checker {
	public static final String INITPASS = "appel";
	public BasicChecker(){
		}
	public boolean acceptable(String suggestion) {
		return (suggestion.length() >= 6 && !suggestion.contains(" "));
	}
	
	public String generatePassword(){
	return INITPASS;
	}

}
