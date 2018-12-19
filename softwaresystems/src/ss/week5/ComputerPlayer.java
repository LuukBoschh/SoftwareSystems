package ss.week5;

public class ComputerPlayer extends Player {
	Strategy strategy;
	
	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.toString() + "-" + mark.toString(), mark);
		this.strategy = strategy;
		
	}

	public ComputerPlayer(Mark mark) {
	super("Naive" + "-" + mark.toString(), mark);
	strategy = new NaiveStrategy();
	
}
	@Override
    public int determineMove(Board board) {
		return strategy.determineMove(board, this.getMark());
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public String toString() {
		return "smart";
	}
}
