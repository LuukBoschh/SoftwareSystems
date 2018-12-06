package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    /**
     * Create a new Rectangle with the specified length and width.    
     */	
    //@public invariant length() >=0 && width() >= 0;
    public Rectangle(int length, int width) {
    	assert length >= 0  : "precondition: length (" + length + ") >= 0";
    	assert width >= 0   : "precondition: width (" + width + ") >= 0";
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
//@ ensures \result >= 0; 
/*@ pure */public int length() {
	return length;
    }

    /**
     * The width of this Rectangle.
   
     */
//@ ensures \result >= 0; 
/*@ pure */public int width() {
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
//@ ensures \result >= 0;
/*@ pure */ public int area() {
    	int area = 0;
    	assert area >=0;
    	return area = length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
//@ ensures \result >= 0;
/*@ pure */  public int perimeter() {
    	int perimeter = 1;
    	assert perimeter >=0;
    	return perimeter = 2*length + 2*width;
    }
}
