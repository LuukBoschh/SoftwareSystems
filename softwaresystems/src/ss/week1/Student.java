package ss.week1;

public class Student {
	double score;

public Student(int score) {
	this.score = score;
}
public double score () {
	return score;
}
public double adjustedscore(double highestgrade) {
	double difference;
	double adjustedscore;
	difference = 100 - highestgrade;
	System.out.println(difference);
	adjustedscore = ((score/highestgrade)*difference)+score;
	return adjustedscore;

}
}
