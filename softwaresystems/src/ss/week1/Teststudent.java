package ss.week1;

public class Teststudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentScoreTest studenscore = new StudentScoreTest();
		studenscore.runTest();
		

	}

}

class StudentScoreTest {
	private Student piet;
	public StudentScoreTest() {
		piet = new Student(45);
	}
	public void runTest () {
		testScore();
	}
	private void testScore() {
		if(piet.score() >=  30)
				System.out.println(" score: 45 adjusted Score:" + piet.adjustedscore(90));
		else
			System.out.println("Bad score");
	}
	
}
	