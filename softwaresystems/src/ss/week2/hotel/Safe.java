package ss.week2.hotel;

/*
 * public invariant 
 */
public class Safe {
	String code;
	Password password;
	boolean active;
	boolean open_close;

	public Safe() {
		code = "activate";
		password = new Password();
		active = false;
		open_close = false;
	}

	public boolean activate(String password) {
		active = true;
		return (code.equals(password));

	}

// @ensures isActive() == false && isOpen() == false;
	public void deactivate() {
		active = false;
		open_close = false;
	}

// requires
// @ensures 
	public void open(String typen) {
		if ((active == true) && password.testWord(typen)) {
			open_close = true;

		}
	}

//@ensures isOpen() == false;
	public void close() {
		open_close = false;
	}

//@ensures \result == true || \result == false;
	/* pure */public boolean isActive() {
		return (active == true);
	}

//@ensures \result == true || \result == false;	
	/* pure */public boolean isOpen() {
		return (open_close == true);
	}

	/* pure */public Password getPassword() {
		return password;

	}
}
