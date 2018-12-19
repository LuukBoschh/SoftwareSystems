package ss.week6.voteMachine;
import java.util.*;
/**
 * This class provides the ability to add, check and get all the parties of a list
 * @author luuk.bosch
 *
 */
public class PartyList extends Observable{
	List<String> lijst;
	/**
	 * Creates a instance of PartyList
	 */
	public PartyList() {
		lijst = new ArrayList<>();
	}
	/**
	 * Adds a party to the PartyList
	 * @param party is a String of the party
	 */
	public void addParty(String party) {
		lijst.add(party);
		setChanged();
		notifyObservers("party");
	}
	/**
	 * Check if a party is on the list
	 * @param party
	 * @return true if party is on the list, return false if its not
	 */
	public boolean hasParty(String party) {
		return lijst.contains(party);
	
	}
	/**
	 * return all the parties in the list
	 * @return List<String> with parties
	 */
	
	public List<String> getParties() {
		return lijst;
	}
}
			