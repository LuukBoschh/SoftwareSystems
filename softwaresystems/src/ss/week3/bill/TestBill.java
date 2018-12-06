package ss.week3.bill;

public class TestBill {
	Bill bon;
	public static void main(String[] args) {
			TestBill test = new TestBill();
			test.test();
		
		}
	public TestBill(){
		Printer printer = new SysoutPrinter();
	    bon = new Bill(printer);
	}
	
	public void test() {
		Appel appel = new Appel();
		Peer peer = new Peer();
		bon.addItem(appel);
		bon.addItem(appel);
		bon.addItem(peer);
		bon.getSum();
		bon.close();

		
		
	}

}
