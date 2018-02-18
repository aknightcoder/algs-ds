package problems;

public class UniqueCharacters 
{
	public boolean hasUniqueCharacters(String str)
	{
		boolean[] foundChars = new boolean[128];
		
		for (int i = 0; i < str.length(); i++)
		{
			int current = str.charAt(i);
			
			if (foundChars[current])
			{
				return false;
			}

			foundChars[current] = true;
		}
		
		return true;
	}
	
	public static void main(String[] args)
	{
		UniqueCharacters uc = new UniqueCharacters();
		
		System.out.println(uc.hasUniqueCharacters("Adama"));
		
		System.out.println(uc.hasUniqueCharacters("Knight"));
	}
}
