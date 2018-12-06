package ss.week4;

import java.util.Arrays;
/**
 * Creates a class that contains a array with integers
 * @author luuk.bosch
 *
 */
public class MoveUp {
	int [] lijst;
	public static void main(String[] args) {
		
		MoveUp test = new MoveUp(new int[]{1,2,3,4,5,6,7,8,9,10});
		test.innerProduct(new int[]{1,2,3,4,5,6,7,8,9,10});
		test.move();

	}
	// Creates a instance of MoveUp
	public MoveUp(int[] lijst) {
		this.lijst = lijst;

	}

	// shifts up the numbers of the array by 1;
	public void move() {
		int x2 = lijst[0]; int x1;
		int xend = lijst[lijst.length-1];
		for(int i = 0; i < lijst.length -1 ; i++) {
			x1 = x2;
			x2 = lijst[i+1];
			lijst[i+1] = x1;
		}
		lijst[0] = xend;
		System.out.println(Arrays.toString(lijst));
	}
	
	/**
	 * Calculates the innerproduct of the array of MoveUp and a array that is given as input
	 * @param lijst is a int[] to calculate the innerproduct
	 */
	public void innerProduct(int[] lijst) {
		if(this.lijst.length != lijst.length) {
			System.out.println("not same length!");
		}
		else {
			int [] iPlijst = new int[lijst.length];
			for(int i = 0; i < lijst.length; i++) {
				iPlijst[i] = this.lijst[i] * lijst [i];
			}
	System.out.println(Arrays.toString(iPlijst));
	
	}
	}
	}
	
