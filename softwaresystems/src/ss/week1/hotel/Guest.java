package ss.week1.hotel;
/**
 * A guest with a name and possibly a assigned hotel room
 * @author Luuk Bosch
 */
public class Guest {
    // ------------------ Instance variables ----------------
    private java.lang.String name;
    private ss.week1.hotel.Room room;
    // ------------------ Constructor ------------------------
    /**
     * Creates a <code>Guest</code> with the given name, without a room.
     */
    public Guest(java.lang.String name ) {
        this.name = name;
        this.room = null;
    }
    // ------------------ Queries --------------------------
    /**
     * Returns the name of this <code>Guest</code>.
     */
    public java.lang.String getName(){
        return name;
    }
    /**
     * Returns the current room of the <code>Guest</code>.
     */
    public ss.week1.hotel.Room getRoom() {
        return room;
    }
     
    /**
     * Rents a Room to this Guest. This is only possible if this Guest does not already have a Room. and the Room to be assigned is not already rented. Also adapts the Guest-reference of the Room.
     */
    public boolean checkin(ss.week1.hotel.Room room) {
        if (room.getGuest() != null){
        	return false;
        }
        if (this.getRoom() == null) {
        	this.room = room;
        	room.setGuest(this);
        	System.out.println("hoi");
        	return true;
        }
        else {
        	return false;
        		
        }
    }
    
    public boolean checkout() {
    	if (this.getRoom() == null) {
    		return false;
    	}
    	else {
    		room.setGuest(null);
    		room = null;
    		return true;
    	}
    }
    public String toString() {
    	name = "Guest  " + name;
    	return name;
    }
}
