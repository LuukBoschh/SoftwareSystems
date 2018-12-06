package ss.week3.bill;

public interface Printer {
	
	public default String format(String text, double price) {
		return String.format("%-15s%9.2f", text,price);
		
	}
	
	public void printLine(String text, double price);


}
