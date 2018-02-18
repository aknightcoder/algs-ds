package problems;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class StringPermutationsTest {

	@Test
	public void stringPermutationTest() {
		
		String inputString = "ABCD";

		ArrayList<String> expectedList = new ArrayList<String>(
				Arrays.asList("ABCD", "ABDC", "ACBD", "ACDB", "ADCB", "ADBC", "BACD", "BADC", 
							  "BCAD", "BCDA", "BDCA", "BDAC", "CBAD", "CBDA", "CABD", "CADB", 
							  "CDAB", "CDBA", "DBCA", "DBAC", "DCBA", "DCAB", "DACB", "DABC"));
		
		StringPermutations sp = new StringPermutations();
		
		ArrayList<String> resultList = sp.permuteString(inputString, 0, inputString.length()-1, new ArrayList<String>());
	
		assertEquals(24, resultList.size());
		assertEquals(expectedList, resultList);
	}

}
