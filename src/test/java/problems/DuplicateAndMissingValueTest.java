package problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateAndMissingValueTest {

	@Test
	public void duplicateAndMissingValue() 
	{
		
		DuplicateAndMissingValue duplicateAndMissingValue = new DuplicateAndMissingValue();
		
		int[] sourceArr = new int[]{1,3,2,4,5,6,5,7,9,10};
		
		int[] results = duplicateAndMissingValue.FindDuplicateAndMissingValue(sourceArr);
		
	    assertEquals(2, results.length);
		assertEquals(5, results[0]);
		assertEquals(8, results[1]);
	}

}
