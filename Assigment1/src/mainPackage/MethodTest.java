package mainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodTest {

	@Test
	public void testNeedToSave() {
		
		double result = Main.needToSave(2, 20, 10000, 2642.00);
		assertEquals(-1454485.55, result, 0.01);
	}
	
	@Test
	public void testSaveMonthly() {
		double result = Main.saveMonthly(9, 23, 1454485.55);
		assertEquals(-1589.29, result, 0.01);
	}

}
