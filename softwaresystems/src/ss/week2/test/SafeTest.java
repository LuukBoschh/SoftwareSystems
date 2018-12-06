package ss.week2.test;
import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week2.hotel.Password;

class SafeTest {
	private Safe safe;

	@BeforeEach
	void setUp() {
		safe = new Safe();
		
	}

	@Test

	public void testIsActive() {

		assertFalse(safe.isActive());//deactive

		safe.activate("safefdafda123");

		assertTrue(safe.isActive());//active

		safe.deactivate();

		assertFalse(safe.isActive());//deactive

	}

	

	@Test

	public void CDnaarAOnaarCD() {

		assertFalse(safe.isOpen());

		safe.activate("activate"); //activeer

		safe.open("safefdsf123"); //open

		assertTrue(safe.isOpen()); 

		safe.deactivate();//deactiveer

		assertFalse(safe.isOpen());

	}

	

	@Test

	public void CDnaarACnaarCD() {

		assertFalse(safe.isOpen());

		safe.activate("activateIT"); //activeer

		assertFalse(safe.isOpen()); 

		safe.deactivate();//deactiveer

		assertFalse(safe.isOpen());

	}

	

	@Test

	public void CDnaarODnaarCD() {

		assertFalse(safe.isOpen());

		safe.open("safedfadfa123"); //open

		assertFalse(safe.isOpen()); 

		safe.close();//close

		assertFalse(safe.isOpen());

	}

	

	@Test

	public void AOnaarACnaarAO() {

		safe.activate("activate"); //activeer

		safe.open("kknlnklkkkkkkkkkkkkkkkkkkkk"); //open

		assertTrue(safe.isOpen());

		safe.close();//close

		assertFalse(safe.isOpen());

		safe.open("safe123"); //open

	}

	

	@Test

	public void AOnaarDOnaarAO() {

		safe.activate("activate"); //activeer

		safe.open("safe123"); //open

		assertTrue(safe.isOpen()); 

		safe.deactivate();//deactiveer

		assertFalse(safe.isOpen());

		safe.activate("activate"); //activeer

		safe.open("safe123"); //open

		assertTrue(safe.isOpen()); 

	}

	

	@Test

	public void ACnaarCDnaarAC() {

		safe.activate("activatree"); //activeer

		assertFalse(safe.isOpen()); 

		safe.deactivate();//deactiveer

		assertFalse(safe.isOpen());

		safe.activate("activate"); //activeer

		assertFalse(safe.isOpen());

	}

}