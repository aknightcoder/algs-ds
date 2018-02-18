package hashing;

import org.junit.Test;

public class SeparateChainingHashSetTest {

	@Test
	public void test() 
	{
		SeparateChainingHashSet<String,Integer> hashSet = new SeparateChainingHashSet<String,Integer>(26);
		
		StringBuilder alphabet = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
		
		for(Integer i = 0; i < alphabet.length(); i++)
		{
			hashSet.put(String.valueOf(alphabet.charAt(i)), i);
		}
	}
}
