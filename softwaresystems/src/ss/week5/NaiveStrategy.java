package ss.week5;

import java.util.ArrayList;
import java.util.List;
public class NaiveStrategy implements Strategy {
	@Override
	public int determineMove(ss.week5.Board b, ss.week5.Mark m) {
		List<Integer> lijst = isEmpty(b);
		int range = lijst.size()-1;
		return lijst.get((int)Math.random()*range);		
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
	
	public String getname() {
		return("Naive");
	}


	

	
}
