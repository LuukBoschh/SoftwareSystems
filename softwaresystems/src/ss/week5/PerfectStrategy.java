package ss.week5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

// losing = -1, neutral = 0, winning = 1
public class PerfectStrategy implements Strategy {
	
	public int determineMove(Board b, Mark m) {
		int[] result = determineMoverec(b, m);
		return result[1];
		
		
	}
	
	
	public int[] determineMoverec(Board b, Mark m) {
		int qual = 0;
		int[] qualmove = new int[2]; 
		qualmove[0] = -1;
		List<Integer> lijst = new ArrayList<>();
		lijst = isEmpty(b);
		int move = 0;
		for (Integer s: lijst) {
			move = s;
			qual = setmove(b, s, m);
			if (qual >= qualmove[0]) {
				qualmove[0] = qual;
				qualmove[1] = s;
			}
		}
		return qualmove;
		

	}
		
	public int setmove(Board b, int move, Mark m) {
		b.setField(move, m);
		int qual = determineQuality(b, m);
		b.setField(move, Mark.EMPTY);
		return qual;		
	}
		
	public int determineQuality(Board b, Mark m) {
		int qual;
		if (b.isWinner(m) == true) {
			qual = 1;
			return qual;
		} else if (b.isFull()) { 
			qual = 0;
			return qual;
		} else {
			int oppQual = determineMoverec(b, m.other())[0];
			if (oppQual == 1) {
				qual = -1;
			} else if (oppQual == -1) {
				qual = 1;
			} else {
				qual = 0;
				 
			}
			return qual; 
		}
	}
	
	private List<Integer> isEmpty(ss.week5.Board b) {
		int i = 0;
		List<Integer> list = new ArrayList<>();
		while (b.isField(i) ==  true) {
			if (b.isEmptyField(i) ==  true) {
				list.add(i);
				i++;
			} else {
				i++;
			}
		}
		return list;
	}
	
	
	public String getname() {
		return "perfect";
	}
}
