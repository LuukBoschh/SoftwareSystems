package ss.week4.hotel;

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item{	
double price;

/**
 * PricedSafe is a extends safe so that it can implement Bill.Item in way that it can be used to put on a bill 
 * @param price is the price of the room for one night requires price >= 0
 */

public PricedSafe(double price) {
	super();
	this.price = price;
}

//Returns the price of the room
public double getAmount() {
	return price;
}

//Returns the name of the room?????
public String getString() {
	return "Safe";
	
}

public String toString() {
	return "the price of the safe is:" + price;
}

}

