package ss.week5.extra;

import ss.week5.Board;
import ss.week5.Mark;

public class IsWinning {

    public static void main(String[] args) {
    	IsWinning win = new IsWinning();
    	win.test();
    	
    	
    }

	   public IsWinning() {
	    	
	    }

 


public boolean isWinningtest(Board b, Mark m) {
	return ((diagonalDown(b,m)!= -1) || (diagonalUp(b,m)!= -1) || (hasRow(b,m)!= -1) || (hasCol(b,m)!= -1) );
}

public void test() {
	Board b = new Board();
	b.setField(0, Mark.XX);
	b.setField(3, Mark.XX);
	b.setField(6, Mark.XX);

	System.out.println(b.isWinner(Mark.XX));
}

private int diagonalDown(Board b, Mark m) {
	int countdown = 0;
	int leeg = -1;
	for(int i = 0; i<3; i++) {
		if(b.getField(i,i) == m) {
			countdown++;
	}
		else if (b.getField(i,i) == Mark.EMPTY){

			leeg = b.index(i,i);
		}
		
}  
	if(countdown == 2 && leeg != -1)
		return leeg;
	else {
		return -1;
	}
	
}
private int diagonalUp(Board b, Mark m) {
	int countdown = 0;
	int leeg = -1;
	for(int i = 0; i<3; i++) {
		if(b.getField(i,3 -1 - i) == m) {
			countdown++;
			System.out.println(countdown);
	}
		else if(b.getField(i,3 -1 - i) ==  Mark.EMPTY) {
			leeg = b.index(i,3 -1 - i);
		}
		
}  
	if(countdown == 2 && leeg != -1)
		return leeg;
	else {
		return -1;
	}
	
}



public int hasRow(Board b, Mark m) {
	for(int j = 0; j < 3; j++) {
		int row = 0;
		int leeg = -1;
		for(int i = 0;i<3; i++) {
				if(b.getField(i+(3*j)) == m) {
					row +=1;
				}
				else if(b.getField(i+(3*j)) == Mark.EMPTY) {
					leeg = i+3*j;
				}
			}
		if(row ==  2 && leeg !=-1) {
			return leeg;
		}
}
 	return -1;
}


public int hasCol(Board b, Mark m) {
	for(int j = 0; j < 3; j++) {
		int row = 0;
		int leeg = -1;
		for(int i = 0;i<3; i++) {
				if(b.getField(j+(3*i)) == m) {
					row +=1;
				}
				else if(b.getField(j+(3*i)) == Mark.EMPTY) {
					leeg = j+3*i;
				}
			}
		if(row ==  2 && leeg !=-1) {
			return leeg;
		}
}
 	return -1;
}
}


