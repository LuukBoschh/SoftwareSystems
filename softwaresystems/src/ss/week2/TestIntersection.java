package ss.week2;

import ss.week2.Intersection;
import ss.week2.TrafficSignalecht;

public class TestIntersection {

	public static void main(String[] argv) {
		TestIntersectione test = new TestIntersectione();
		test.runTest();
		// TODO Auto-generated method stub

	}
}

	class TestIntersectione {
		private Intersection kruising;
		public TestIntersectione () {
			kruising = new Intersection();
		}
		public void runTest () {
			testInitialState();
			testChange();
		}
		private void testInitialState() {
			System.out.println("testInitialState:");
			System.out.println("Initial light NS: " + kruising.getColorNS());
			System.out.println("Initial light EW: " + kruising.getColorEW());
			System.out.println("-----------------------");
		}
		private void testChange () {
			kruising.changes();
			kruising.changes();
			kruising.changes();
			kruising.changes();
			kruising.changes();
			kruising.changes();
			
		}
	}

