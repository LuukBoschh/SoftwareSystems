package ss.week5;

public class StrategyTest {
    public static void main(String[] args) {
    StrategyTest t = new StrategyTest();
    t.runtest();
    }
	
	public void runtest() {
		PerfectStrategy test = new PerfectStrategy();
	    Board b = new Board();
	    b.setField(0, Mark.XX);
	    b.setField(8, Mark.OO);
	    b.setField(2, Mark.XX);
	    b.setField(1, Mark.OO);
	    test.determineMove(b,Mark.XX); 
	    }

}
