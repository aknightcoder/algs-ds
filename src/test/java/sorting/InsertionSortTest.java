package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void testInsertionSort() {
		
		InsertionSort insertionSort = new InsertionSort();
		
		int[] unsortedArray = new int[]{3,1,9,6,7,4,5};
		
		int[] sortedArray = insertionSort.sort(unsortedArray);
		
		assertArrayEquals(new int[]{1,3,4,5,6,7,9}, sortedArray);
	}
}
