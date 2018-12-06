package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

public class RectangleTest {
    private Rectangle a;
    private Rectangle b;
    private Rectangle c;
 
    @Before
    public void setUp() {
        a = new Rectangle(0,1);
        b = new Rectangle(1,0);
        c = new Rectangle(2,2);
        // TODO: initialise the variable room
    }

    @Test
    public void testLength() {
        assertEquals(0, a.length());
        assertEquals(1, b.length());
        assertEquals(2, c.length());
    }
    @Test
    public void testWidth() {
        assertEquals(1, a.width());
        assertEquals(0, b.width());
        assertEquals(2, c.width());
    }
    @Test
    public void testArea() {
        assertEquals(0, a.area());
        assertEquals(0, b.area());
        assertEquals(4, c.area());
    }  
    @Test
    public void testPerimeter() {
        assertEquals(2, a.perimeter());
        assertEquals(2, b.perimeter());
        assertEquals(8, c.perimeter());
    }

 
    
}