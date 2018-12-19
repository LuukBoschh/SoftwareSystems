package ss.week5.extra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InsertionSort {
	List<Integer> lijst;
	public static void main(String[] args) {		
		
	List<Integer> lijst = new ArrayList<Integer>(Arrays.asList(4,3,2,1,5,3,66,7,7,4,55,64,2,1,2222,45,6,3));
	List<Integer> lijst2 = new ArrayList<Integer>(Arrays.asList(4,3,2,1,5,3,66,7,7,4,55,64,2,1,2222,45,6,3));
	InsertionSort test = new InsertionSort(lijst);
	InsertionSort test2 = new InsertionSort(lijst2);
	System.out.println(test.apply2());
	System.out.println(test.apply());

	}
	
	public InsertionSort(List<Integer> lijst) {
		this.lijst = lijst;
		
	}


	public List<Integer> apply2(){
			long time1 = System.currentTimeMillis();
			int i = 1;
			while(i<lijst.size()) {
			int j = i;
			while (j > 0 && ( lijst.get(j-1) > lijst.get(j))) {
				int x = lijst.get(j);
				lijst.set(j, lijst.get(j-1));
				lijst.set(j-1, x);
			j = j - 1;
			}
			i = i + 1;
			
			
	}		
			System.out.println("tijd antwoordblad algoritme:" + (time1-System.currentTimeMillis()));
			return lijst;
	}

		


	public List<Integer> apply() {
		long time1 = System.currentTimeMillis();
		for(int pos = 1; pos<lijst.size();pos++) {
			int x = lijst.get(pos);
			for(int i = pos-1; i>=0; i--) {
				if(lijst.get(i) <= x) {
					break;
				}
				if (lijst.get(i) > lijst.get(pos)) {
					lijst.set(pos, lijst.get(i));					
				}
				if (i == 0) {
					lijst.set(0, x);
					break;	
				}
				if(lijst.get(i-1) > x) {
					lijst.set(i, lijst.get(i-1));
				}
			}		
		}		
		System.out.println("tijd eigen algoritme:" + (time1-System.currentTimeMillis()));
		return lijst;		
	}
}

