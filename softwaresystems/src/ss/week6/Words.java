package ss.week6;
import java.util.Scanner;
/**
 * Splits up a given input sentence into single words and prints out these single words.
 * @author luuk.bosch
 *
 */
public class Words {
	Scanner in;
	public static void main(String[] args) {
		Words hoi = new Words();
		hoi.readStringWithPrompt();
	}	
	public Words() {
		this.in = new Scanner(System.in);
	}
	/**
	 * Reads the input of the user and prints the full sentence and all the single words with enumeration.
	 */
	public	void readStringWithPrompt() {
		System.out.println("Give me a full sentence");
		while (in.hasNextLine()) {
			String woord = in.next();
			if (woord.equals("end")) {
				System.out.println("program stopped");
				break;
			} else {
				String zin = in.nextLine();
				System.out.println("Line(or'end'):  " + woord + zin);
				System.out.println("Word " + 1 + ": " + woord);
				String[] arr = zin.trim().split(" ");
				int i = 2;
				for (String ss: arr) {
					System.out.println("Word " + i + ": " + ss);
					i++;
				}
			}
		}
	}
}
