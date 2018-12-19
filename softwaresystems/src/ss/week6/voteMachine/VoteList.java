package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
Map<String, Integer> stemlijst; 
	public VoteList() {
		stemlijst = new HashMap<String,Integer>();
	}
	
	public void addVote(String party) {
		if(stemlijst.keySet().contains(party)) {
		int aantalstemmen = stemlijst.get(party);
		aantalstemmen ++;
		stemlijst.put(party, aantalstemmen);
		setChanged();
		notifyObservers("vote");
		} else {
		stemlijst.put(party, 1);
		setChanged();
		notifyObservers("vote");
		}
	}
	
	public Map<String, Integer> getVotes(){
		return stemlijst;
	}
}
