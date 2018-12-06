package ss.week1;

import ss.week2.TrafficSignal;
public class Testlamp {

	public static void main(String[] argv) {
		TrafficSignalTest test = new TrafficSignalTest();
		test.runTest();
		// TODO Auto-generated method stub

	}

}

class TrafficSignalTest {
	private TrafficSignal signal;
	public TrafficSignalTest () {
		signal = new TrafficSignal();
	}
	public void runTest () {
		testInitialState();
		testChange();
	}
	private void testInitialState() {
		System.out.println("testInitialState:");
		System.out.println("Initial light: " + signal.light());
	}
	private void testChange () {
		System.out.println("testChange:");
		System.out.println("starting light:" + signal.light());
		signal.change();
		System.out.println("After 1 change " + signal.light());
		signal.change();
		System.out.println("After 2 change " + signal.light());
		signal.change();
		System.out.println("After 3 change " + signal.light());
		signal.change();
		System.out.println("After 4 change " + signal.light());
	}
}
