package ss.week3.bill;

public class Bill {
private Printer printer;
//String bill;
private double sum = 0;
	public interface Item{
		double getAmount();
		String getString();
		}

	public Bill(Printer printer) {
		this.printer = printer;
	}
	
	public void addItem(Bill.Item item) {
	printer.printLine(item.getString(), item.getAmount());
	sum += item.getAmount();
	}
	
	public void close(){
	printer.printLine("final price", sum);
	sum = 0;
	}
	
	public double getSum() {
	return sum;
	}
	
	
}
