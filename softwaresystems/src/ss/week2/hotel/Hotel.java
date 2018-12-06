package ss.week2.hotel;
import ss.week2.hotel.Guest;
/**
 * Builds a hotel with two rooms and two guests. 
 * For the checkin of a guest a password is needed
 */


import ss.week2.hotel.Room;
public class Hotel {
	Room room1;
	Room room2;
	Guest guest1; 
	Guest guest2 ;
	Password wachtwoord;
	String name;
	
	public Hotel(String name) {
		room1 = new Room(101);
		room2 = new Room(102);
		wachtwoord = new Password();
		this.name = name;	
	}
	
/**
 * Method that can be used to checkin new <code>Guest</code>
 * @param password is the password needed for the checkin
 * @param guestname is the name of the guest that needs to be checked in.
 * @return returns <code>Room</code>  of the new guest. 
 */
public Room checkIn(String password, String guestname) {
	if((!wachtwoord.testWord(password))) {
	return null;
	}
	if(room1.getGuest() == null) {
		guest1 = new Guest(guestname);
		guest1.checkin(room1);
		return room1;
	}
	if(room2.getGuest() == null) {
		guest2 = new Guest(guestname);
		guest2.checkin(room2);
		return room2;
	}
	else {
		System.out.println("isfull");
		return null;
}
}
/**
 * Method used to checkout <code>Guest</code>
 * @param name of the guest that wants to checkout
 */

public void checkOut(String name){
    if (room1.getGuest() != null && room1.getGuest().getName().equals(name)){
        this.room1.getSafe().deactivate();
        this.room1.getGuest().checkout();
    }
    if (this.room2.getGuest() != null && this.room1.getGuest().getName().equals(name)){
        this.room2.getSafe().deactivate();
        this.room2.getGuest().checkout();
  
    }
}

	
/**
 * Method that returns free room
 * @return <code>Room</code> if a room is available and null if no room is available. 
 */
public Room getFreeRoom() {
	if (room1.getGuest() == null)
		return room1;
	if (room2.getGuest() == null)
		return room2;
	else
		return null;
}
/**
 * Returns the room of the given <code>Guest</code>
 * @param name of <code>Guest</code>
 * @return <code>Room</code>
 */
public Room getRoom(String name) {
	if(room1.getGuest() != null && room1.getGuest().getName().equals(name)){
	return room1;
	}
	if(room2.getGuest() != null && room2.getGuest().getName().equals(name)){ 
	return room2;
	}
	else {
	return null;
	}
}
/**
 * Returns password of hotel
 * @return <code>Password</code>
 */
public Password getPassword() {
	return wachtwoord;
}
/**
 * Returns information about the hotel
 */
public String toString() {
	String text = "Major Gowen";
return text;
}
}