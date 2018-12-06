package ss.week3.bill;
public class StringPrinter implements Printer{
	String string;
	public StringPrinter(){
			}
	
	public void printLine(String text, double price) {
		this.string += this.format(text, price)+"\n";
	}
	public String getResult() {
		return string;
	}
}
