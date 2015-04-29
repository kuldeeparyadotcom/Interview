// Purpose: This program is to reverse a string entered by user

import java.util.*;

class ReverseString
{

	public static void main (String args[])
	{
		String original, reverse = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string to reverse");
		original = in.nextLine();

		int length = original.length();
		System.out.println("Lenght of the entered sting is" + length);
		
		for (int i = length - 1; i >= 0; i-- )
		{
			reverse = reverse + original.charAt(i);
		}
		System.out.println("Reverse of the entered string is: " + reverse);
	}
}
