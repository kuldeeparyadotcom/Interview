/*
Purpose: Write a program for basic string compression.
Input: a-z A-Z string i.e. aabbccccdef
Output: a2b2c4d1e1f1
Please note: length of the compressed string should not be more than the original :)

Make sure Time Space trade off is well considered

Algorithm:
Input an input string

Iterate through the input string i.e. aabbccccdef
Make a note of each character and number of subsequent occurrences i.e.
a2
b2
c4
d1
e1
f1
Combine collected stats i.e. a2b2c4d1e1f1

check if string is of unique characters
	if yes, return original string
check if number of unique characters >= length of the string
	if yes, return the original string
check if length of the conmpressed string is greater than original input string
	if yes, return the original string

*/

import java.util.*;

public class BasicStringCompression {
	public static void main(String args[])
	{	
		//Take an input string
		System.out.println("Enter input string for basic compression");
		Scanner scan = new Scanner(System.in);
		String input_string = scan.nextLine();
		System.out.println("System has captured the following string for basic compression: "+input_string);
		
		//If input string is just one character long, then program should return original string and exit
		if (input_string.length()<2)
		{
			System.out.println("As input string contains only one character, therefore optimal compressed string can be: "+input_string);
			System.exit(0);
		}

		//If input string has only unique characters, then program should return original string and exit
		if(isItUniqueCharacterString(input_string))
		{
			System.out.println("As input string contains only unique characters, therefore optimal compressed string can be: "+input_string);
			System.exit(0);
		}

		//If number of unique characters in input string > (lenght of input string)/2, then program should return original string and exit	
		//TO DO :)
			
		//Make a note of each character and number of subsequent occurrences
		StringBuffer compressedString = new StringBuffer(input_string.length());
		boolean match = false;
		int occurrence = 1;
		//Start iterating with second character
		for (int i=1; i<input_string.length(); i++)
		{
			
			System.out.println("Checking for character: "+ input_string.charAt(i));
	                if(input_string.charAt(i)==input_string.charAt(i-1))
				match = true;
			else
				match = false;

			if(match) //simply keep going until occrrence ends
			{
				occurrence++;
			}else //if match is false then it's time to append our compressed string 
			{	
                                System.out.println("Character "+ input_string.charAt(i-1) +" has occurred " + occurrence + "times" );
                                System.out.println("Therefore appending "+input_string.charAt(i-1)+occurrence + " to the compressed string");
				compressedString.append(input_string.charAt(i-1));
                                compressedString.append(occurrence);
                                System.out.println("Intermediate compression string look like: "+ compressedString.toString());
				occurrence = 1;
			}
			//for last character occurrence: whether is is true or false, it must be appended at last
			if (i == input_string.length() - 1)
			{
				compressedString.append(input_string.charAt(i));
				compressedString.append(occurrence);
			}
		}
		
		if (input_string.length() > compressedString.length()) {
                        System.out.println("Input string: "+input_string+" after Basic Compression, should look like: "+compressedString.toString());
		} else {
			System.out.println("As length of compressed string: "+compressedString.toString() +" is greater than input string, returning original string: "+input_string);
		}

	}

	public static boolean isItUniqueCharacterString(String str)
	{
		boolean result = true;
		
		//if provided string has only unique characters then set result = true
		//iterate through string from index 0 to length()-1 and on the basis of ASCII char set, track in a boolean array
		boolean[] trackCharacterRepeatition = new boolean[128];
		
		for (int i =0; i<str.length(); i++)
		{	
			if (!trackCharacterRepeatition[str.charAt(i)])
				trackCharacterRepeatition[str.charAt(i)] = true;
			else
				result = false; //repeatition found
		}		
		return result;	
	}
	
} 
