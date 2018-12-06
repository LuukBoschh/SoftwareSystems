package ss.week4.hotel;

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item  {
	double price_room;
	
	/**
	 * creates room that can be put on a bill.
	 * @param no Number of the room	
	 * @param price_room Price of the room
	 * @param price_safe Price of the safe
	 */
	public PricedRoom(int no, double price_room, double price_safe) {
		super(no, new PricedSafe(price_safe));
		this.price_room = price_room;
	}
	
	//Returns the price of the room
	public double getAmount() {
		return price_room;
	}
	//Returns description of the item
	public String getString() {
		return"Room";
	}
	//Returns Readable interpretation of the item.
	public String toString() {
		return "the price of the room is:" + price_room;
		
	}

}
