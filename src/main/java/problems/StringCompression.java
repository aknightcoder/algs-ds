package problems;

public class StringCompression 
{
	public String compressString(String str)
	{
		int compressionSize = getCompressionSize(str);
		if(compressionSize >= str.length())
			return str;
		
		StringBuilder sb = new StringBuilder();
		
		int lastCharIndex = 0;
		int charCount = 1;
		sb.append(str.charAt(lastCharIndex));
		
		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == str.charAt(lastCharIndex))
			{
				charCount++;
			} 
			else
			{
				sb.append(charCount);
				charCount = 1;
				lastCharIndex = i;
				sb.append(str.charAt(i));
			}
		}
		sb.append(charCount);
		
		return sb.toString();
	}
	
	public String compressString2(String str)
	{
		int size = getCompressionSize(str);
		if (size >= str.length())
			return str;
		
		char[] array = new char[size];
		int lastIndex = 0;
		int count = 1;
		for(int i = 1, j = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == str.charAt(lastIndex))
			{
				count++;
			}
			else 
			{
				array[j] = str.charAt(lastIndex);
				array[++j] = String.valueOf(count).toCharArray()[0];
				count = 1;
				lastIndex = i;
				j++;
			}
		}
		
		array[lastIndex] = str.charAt(lastIndex);
		array[size-1] = String.valueOf(count).toCharArray()[0];
		
		return new String(array);
	}
	
	private int getCompressionSize(String str)
	{
		int size = 0;
		int lastCharIndex = 0;
		int count = 1;
		
		for (int i = 1; i < str.length(); i++)
		{
			if (str.charAt(i) == str.charAt(lastCharIndex))
			{
				count++;
			}
			else 
			{
				count = 1;
				size += 1 + String.valueOf(count).length();
				lastCharIndex = i;
			}
		}
		
		return size += 1 + String.valueOf(count).length();
	}
	
	
	public static void main(String[] args)
	{
		StringCompression sc = new StringCompression();
		
		System.out.println(sc.compressString("aaabccdddd"));
		System.out.println(sc.compressString("abcdddd"));
		System.out.println(sc.compressString2("aaabccdddd"));
		System.out.println(sc.compressString2("abcdddd"));
	}
}
