/** Purpose: To find out first non repeated character in entered string
	Input: a string i.e .teeter
	Output: non repeated character or null (i.e. r)

*/

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatedChar
{
	public static void main(String args[])
	{
		String s;
        	Character c;
        	//int length;

		System.out.println("Enter a string. i.e. teeter");
		Scanner in = new Scanner(System.in);
		s = in.nextLine();
	
		System.out.println("System has accepted the string: " + s + " of length " + s.length());
		c = firstNonRepeatedChar(s);
		System.out.println("First Non Repeated Character of "+s+" is: "+c);
	}
	
	public static Character firstNonRepeatedChar(String s)
	{
		HashMap<Character, Integer> characterRepeatitionHashTable = new HashMap<Character, Integer>();
		
		Character c;
		int i;
		int length = s.length();

		for (i=0; i<length; i++)
		{
			c = s.charAt(i);
			
			System.out.println("Checking for character: "+ c);

			if (characterRepeatitionHashTable.containsKey(c))
			{
				characterRepeatitionHashTable.put(c, characterRepeatitionHashTable.get(c)+1);
			} else
			{
				characterRepeatitionHashTable.put(c,1);
			}
		}

	//Search characterRepeatitionHashTable to find out which character has counter 1 (non repeated)
	
		for (i=0; i<length; i++)
		{
			c = s.charAt(i);
			if (characterRepeatitionHashTable.get(c) == 1)
				return c;
		}
		return null;
	}

}

