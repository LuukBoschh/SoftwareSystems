package ss.week5;
import java.util.ArrayList;
import java.util.List;

import ss.week4.Tower;

public class SmartStrategy implements Strategy {

	
	

	public int determineMove(Board b, Mark m) {
	int i = 0;
	Mark mark_opponent;
	if(m == Mark.XX) {
		mark_opponent  = Mark.OO;
	}
	else {
		mark_opponent  = Mark.XX;
	}
	if(b.getField(4)==Mark.EMPTY) {
		return 4;
	}
	
	else if(diagonalDown(b, m) != -1) {
		return diagonalDown(b,m);
	}
	else if(diagonalUp(b,m) != -1) {
		return diagonalUp(b,m); 
	}
	else if(hasRow(b,m) != -1) {
		return hasRow(b,m); 
	}
	else if(hasCol(b,m) != -1) {
		return hasCol(b,m); 
	}
	//------------------------------------------------------------
	else if(diagonalDown(b, mark_opponent) != -1) {
		return diagonalDown(b,mark_opponent);
	}
	else if(diagonalUp(b,mark_opponent) != -1) {
		return diagonalUp(b,mark_opponent); 
	}
	else if(hasRow(b,mark_opponent) != -1) {
		return hasRow(b,mark_opponent); 
	}
	else if(hasCol(b,mark_opponent) != -1) {
		return hasCol(b,mark_opponent); 
	}
	else {
		System.out.println("Random gekozen!");
		List<Integer> lijst = isEmpty(b);
		int range = lijst.size()-1;
		return lijst.get((int)Math.random()*range);	
		
	}

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
    	}
    		else if(b.getField(i,3 -1 - i) == m) {
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
    
	
	
	private List<Integer> isEmpty(ss.week5.Board b) {
		int i = 0;
		List<Integer> list = new ArrayList<>();
		while(b.isField(i) ==  true) {
			if(b.isEmptyField(i) ==  true) {
				list.add(i);
				i++;
			}
			else {
				i++;
			}
		}
		return list;
	}
	
	public String toString() {
		return "Smart";
	}
	
	public String getname() {
		return "Smart";
		
	}
}
