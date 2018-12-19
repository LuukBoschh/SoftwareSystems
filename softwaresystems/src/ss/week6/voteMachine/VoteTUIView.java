package ss.week6.voteMachine;

import java.util.*;

public class VoteTUIView implements VoteView, Observer {
	VoteMachine stemmachine;
	Scanner in;
	VoteTUIView(VoteMachine stemmachine){
		this.stemmachine = stemmachine;
		this.in = new Scanner(System.in);
	}
	public void start() {
		int choice = -1;
		while (choice != 5) {
			displayMenu();
			choice = readIntWithPrompt("Enter choice:");
			executeChoice(choice);
		}
	}

	private void displayMenu(){
		System.out.println();
		System.out.println("Enter the number denoting the action");
		System.out.println("VOTE......................1");
		System.out.println("ADD party.................2");
		System.out.println("VOTES.....................3");
		System.out.println("PARTIES...................4");
		System.out.println("EXIT......................5");
		System.out.println("HELP......................6");
		
	}
	
	
	
	private void executeChoice(int choice) {
		if(choice == 1) {
			vote();
		} else if(choice == 2) {
			addParty();
		} else if(choice == 3) {
			showVotes(stemmachine.getVotes().getVotes());
		} else if(choice == 4) {
			showParties(stemmachine.getParties().getParties());
		} else if(choice == 5) {
			System.out.println("goodbye");
		} else if(choice == 6) {
			System.out.println("help");
		} else {
			System.out.println("choice not valid!");
		}
	}
	
	
	private int readIntWithPrompt(String prompt) {
		System.out.println(prompt);
		System.out.flush();
		while (!in.hasNextInt()) {
			System.out.println(prompt);
			System.out.flush();
		}
		int input = in.nextInt();
		in.nextLine();
		return input;
		
	}
	
	private String readStringWithPrompt(String prompt) {
		System.out.println(prompt);
		System.out.flush();
		while (!in.hasNext()) {
			System.out.println(prompt);
			System.out.flush();
		}
		String input = in.next();
		in.nextLine();
		return input;
		
	}
	
	private void vote() {
		String stem = readStringWithPrompt("Enter your vote:");
		stemmachine.vote(stem);
	}
	
	private void addParty() {
		String partij = readStringWithPrompt("Add a party: ");
		stemmachine.addParty(partij);
		
	}
		
	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")) {
			System.out.println("there is voted");
		} else {
			System.out.println("A party is added");
		}
		
	}
	@Override
	public void showVotes(Map<String, Integer> votes) {
		System.out.println(votes.toString());
		
	}
	@Override
	public void showParties(List<String> parties) {
		System.out.println(parties.toString());
		
	}
	@Override
	public void showError(String message) {
		// TODO Auto-generated method stub
		
	}
}
