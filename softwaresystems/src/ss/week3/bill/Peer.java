package ss.week3.bill;

public class Peer implements Bill.Item {
	String string = "peer";
	double price = 3.50;
	public Peer() {
		
	}
	public double getAmount() {
		return price;
	}
	public String getString() {
		return string;
	}

}
