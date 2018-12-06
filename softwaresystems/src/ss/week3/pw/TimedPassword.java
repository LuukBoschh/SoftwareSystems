package ss.week3.pw;

public class TimedPassword extends Password {
private long validTime;
long time1;


public TimedPassword(long validTime) {
	super();
	this.validTime = validTime;
	time1 = System.currentTimeMillis();
}

public TimedPassword() {
	super();
	time1 = System.currentTimeMillis();
	validTime = 4000;
}

public boolean isExpired() {
	return  System.currentTimeMillis() - time1 > validTime;
 }

@Override
public boolean setWord(String oldpass, String newpass) {
	if (testWord(oldpass) && acceptable(newpass)) {
		pass = newpass;
		time1 = System.currentTimeMillis();
		return true;
	} else {
		return false;
	}

}

}
 