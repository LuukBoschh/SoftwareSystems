package ss.week5;

public class Bestmove {
	int bestmove;
	int bestqual;

	public Bestmove() {
		bestmove = -8;
		bestqual = -9;
	}
	public void compare(int qual, int move) {
		if(qual > bestqual) {
			bestqual = qual;
			bestmove = move;
		}
	}
	public int getBestMove() {
		return bestmove;
	}
	public int getBestQual() {
		return bestqual;
	}
	public void resetBestMove() {
		bestmove = -8;
		bestqual = -1;
	}
	public void Setmove(int move) {
		bestmove = move;
	}
}
