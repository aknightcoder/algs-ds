package problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfTest 
{
	@Test
	public void powerOfPositiveValueTest() {
		
		PowerOf powerOf = new PowerOf();
		
		double result = powerOf.toPower(10, 5);
		
		assertEquals(100000, result, 0);
	}
	
	@Test
	public void powerOfNegativeValueTest() {
		
		PowerOf powerOf = new PowerOf();
		
		double result = powerOf.toPower(10, -3);
		
		assertEquals(0.001, result, 0);
	}

}
