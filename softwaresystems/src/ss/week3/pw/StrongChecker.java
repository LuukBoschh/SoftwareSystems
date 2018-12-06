package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	public StrongChecker() {
		
	}
	@Override
	public boolean acceptable(String suggestion) {
		return suggestion.length() >= 6 && !suggestion.contains(" ") && Character.isLetter(suggestion.charAt(0)) && Character.isDigit(suggestion.charAt(suggestion.length()-1));
	}

}
