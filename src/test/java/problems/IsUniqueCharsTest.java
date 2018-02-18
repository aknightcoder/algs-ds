package problems;

import static org.junit.Assert.*;
import org.junit.Test;

public class IsUniqueCharsTest {

	@Test
	public void isUniqueCharsHashSetTest() {
		
		IsUniqueChars isUniqueChars = new IsUniqueChars();
		
		boolean isUnique = isUniqueChars.isUniqueCharsHashSet("ABCDA");
				
		assertEquals(false, isUnique);
		
		isUnique = isUniqueChars.isUniqueCharsHashSet("ABCD");
		
		assertEquals(true, isUnique);
	}
	
	@Test
	public void isUniqueCharsArrayTest() {
		
		IsUniqueChars isUniqueChars = new IsUniqueChars();
		
		boolean isUnique = isUniqueChars.isUniqueCharsArray("ABCDA");
				
		assertEquals(false, isUnique);
		
		isUnique = isUniqueChars.isUniqueCharsArray("ABCD");
		
		assertEquals(true, isUnique);
	}
}
