package ss.week3.bill;

public class Appel implements Bill.Item {
	String string = "appel";
	double price = 2.50;
	public Appel() {
		
	}
	public double getAmount() {
		return price;
	}
	public String getString() {
		return string;
	}

}
