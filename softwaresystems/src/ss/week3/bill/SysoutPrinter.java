package ss.week3.bill;

public class SysoutPrinter implements Printer {

	public static void main(String[] args) {
		Printer p = new SysoutPrinter();
		p.printLine("Text1", 1.0);
		p.printLine("Other text", -12.1212);
		p.printLine("Someting", 0.2);
	}
	
	public SysoutPrinter() {
	}

	public void printLine(String text, double price) {
		System.out.println(this.format(text,price));
	}
}
