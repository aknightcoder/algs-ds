package problems;

public class ReverseString 
{
	public static String reverseString(char[] text)
	{
		int counter = 0;
		int midIndex = (text.length - 1) / 2;
		
		while (counter <= midIndex)
		{
            int endIndex = (text.length - 1) - counter;
            
			char swapValue = text[counter];
			
			text[counter] = text[endIndex];
			text[endIndex] = swapValue;
			
			counter++;
		}
		
		return new String(text);
	}
	
	public static void main(String[] args) 
	{
		String result = ReverseString.reverseString("Adam".toCharArray());
		
		System.out.println(result);
	}
}
