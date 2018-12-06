package ss.week3.bill;

public class Kassa {
	Bill bon;
	Appel appel;
	Peer peer;
	
	public static void main(String[] args) {
		Kassa kassa = new Kassa();
		kassa.getBill().getSum();
		kassa.getBill().close()
		
	}

	public Kassa(){
		Printer x = new SysoutPrinter();
		bon = new Bill(x);
		bon.addItem(appel);
		bon.addItem(appel);
		bon.addItem(peer);
		
	}
	
	public Bill getBill() {
		return bon;
	}
}
