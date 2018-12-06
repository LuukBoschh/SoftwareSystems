package ss.week3.bill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class BillTest2{
	private Bill bon;
	private Appel appel;
	private Peer peer;
	
    @Before
    public void setUp() {
        // initialisation of Guest-variables
      appel = new Appel();
      peer = new Peer();
      bon = new Bill(new SysoutPrinter());
    }
	
    
    @Test
    public void toevoegen() {
    	bon.addItem(appel);
		bon.addItem(appel);
		bon.addItem(peer);
        assertEquals(bon.getSum(), 8.5, 1e-15);

    }
    @Test
    public void close() {
    	bon.addItem(appel);
		bon.addItem(appel);
		bon.addItem(peer);
		bon.close();
        assertEquals(bon.getSum(),0.0, 1e-15);

    }
	
}

