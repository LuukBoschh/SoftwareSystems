package ss.week4;

public class Counter {
		int c;
		public Counter() {
			int c = 0;
		}
		
		public void count() {
			c++;
		}
		
		public int returnCount() {
			return c;
		}
		public void resetCount() {
			c = 0;
		}
	}