package ss.week6;
import java.util.Scanner;
/**
 * The Hello class ask for the users name using a prompt and returns "Hello + "user name"".
 * Stops when the string equals 1
 * @author luuk.bosch
 *
 */
public class Hello {
	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		String choice = ".";
		while (!choice.equals("1")) {
			choice = readStringWithPrompt("What is your name?");
			System.out.println("Hello: " + choice);
		}
	}
	
	/**
	 * Function that prints a question an returns the string input of the user
	 * @param prompt can be used to ask the user a question	
	 * @return returns the in.next() of the input
	 */
	private static String readStringWithPrompt(String prompt) {
		System.out.println(prompt);
		System.out.flush();
		while (!in.hasNext()) {
			System.out.println(prompt);
			System.out.flush();
		}
		String input = in.next();
		in.nextLine();
		return input;
		
	}
}