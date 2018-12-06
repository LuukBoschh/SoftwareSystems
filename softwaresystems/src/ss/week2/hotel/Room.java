package ss.week2.hotel;

/**
 * Hotel room with number and possibly a guest.
 * 
 * @author Arend Rensink
 */

public class Room {
    // ------------------ Instance variables ----------------
    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------
    public Room(int no, Safe safe) {
    	number = no;
    	this.safe = safe;
    }
    
    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int number) {
    	this(number, new Safe());
    }
    
    

    // ------------------ Queries --------------------------
    /**
     * Returns the number of this <code>Room</code>.
     * @return the number of this <code>Room</code>;
     *     <code>null</code> if this <code>Room</code> 
     *     does not exist.
     */
    public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    public Guest getGuest() {
    	return guest;
    }
    
    /**
     * Returns the safe in this <code>Room</code>.
     * @return the safe of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         has no safe.
     */
    public Safe getSafe() {
    	return safe;
    }

    // ------------------ Commands --------------------------
    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest gast) {
    	guest = gast;
    	
    }
}
