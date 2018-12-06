package ss.week2.test;




import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;



import org.junit.Before;

import org.junit.Test;



import ss.week2.Year;

public class YearTest {
private Year jaar1;
private Year jaar2;
private Year jaar3;
private Year jaar4;

@Before
public void setUp() {
	jaar1 = new Year(2000);
	jaar2 = new Year(1700);
	jaar3 = new Year(1800);
	jaar4 = new Year(1900);
}
@Test
public void TestYear() {
	assertTrue(jaar1.IsLeapYear());
	assertFalse(jaar2.IsLeapYear());
	assertFalse(jaar3.IsLeapYear());
	assertFalse(jaar4.IsLeapYear());
}

}


