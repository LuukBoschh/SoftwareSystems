package ss.week6.voteMachine;

public class VoteMachine {
	PartyList partijlijst;
	VoteList stemlijst;
	public static void main(String[] args) {
		VoteMachine stem = new VoteMachine();
		stem.start();
	}
	public VoteMachine() {
		partijlijst = new PartyList();
		stemlijst = new VoteList();
	}
	
	public void start() {
		VoteTUIView view = new VoteTUIView(this);
		stemlijst.addObserver(view);
		partijlijst.addObserver(view);
		view.start();
	}
	
	public void addParty(String party) {
		partijlijst.addParty(party);
	}
	
	public void vote(String party) {
		if (partijlijst.hasParty(party)) {
			stemlijst.addVote(party);
		} else {
			System.out.println("Party is not on the list!");
		}
	}
	
	public PartyList getParties() {
		return partijlijst;
	}
	
	public VoteList getVotes() {
		return stemlijst;
	}
	
	
}
