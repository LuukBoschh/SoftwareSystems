package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException{
	public String getMessage() {
		return "error: length of command line arguments differ";
	}

}
