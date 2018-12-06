package ss.week4;
import ss.week3.math.*;
import java.util.List;
import java.util.ArrayList;

public class Polynomial implements ss.week3.math.Integrable{
	Integrable[] lijst;
	Integrable fexp;
	public static void main(String[] args) {
		double[] vector = {1,8,13};
		Integrable X = new Polynomial(vector);
		System.out.println(X.apply(5));
		System.out.println(X.derivative());
		System.out.println(X.integral());
		System.out.println(X.toString());

	}
	
	
	public Polynomial(double[] arr) {
		Integrable f1;
		//fexp = new Constant(0);
		lijst = new Integrable[arr.length];
		for(int i=0; i < arr.length; i++) {
			f1 = new LinearProduct(new Constant(arr[i]), new Exponent(arr.length-i-1));
			lijst[i] = f1;
			//fexp = new Sum(fexp,f1);
		}
	}
	
	public Integrable derivative() {
		Integrable f1;
		Integrable f2 = new Constant(0);
		for(int i=0; i < lijst.length - 1; i++) {
			f1 = (Integrable) lijst[i].derivative();
			f2 = new Sum(f2,f1);
		}
		return f2;
	}
	
	public double apply(double x) {
		double y = 0;
		for(int i=0; i < lijst.length; i++) {
			y  += lijst[i].apply(x);
		}
		return y;
	}

	public Integrable integral() {
		Integrable f1;
		Integrable f2 = new Constant(0);
		for(int i=0; i < lijst.length; i++) {
			f1 = lijst[i].integral();
			f2 = new Sum(f2,f1);
		}
		return f2;
		
		
	}
	public String toString() {
		String string = lijst[0].toString();
		for(int i=1; i < lijst.length; i++) {
			string += "+" + lijst[i].toString();
		}
		return string;
	}
	

	}
	
	
