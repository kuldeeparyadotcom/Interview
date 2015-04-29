/*
FindUniqueCharLongestString.java
Purpose: Given a string, find out longest substring having unique characters


Algorithm:
Take input string (i.e. original_string)
Take StringBuffer to store our intermediate results. Strings are immutable. Arrays are fixed size. Due to these constraints, we cannot use String or Array.
(This would not work: i.e. Take another array that we would return at end of the execution (i.e. char[] result))
if string length is less than 2, return original string (i.e. result=original_string)
Start from second character in string (start_traversing_index = 1) to original_string.length()-1
Check if character at index "start_traversing_index" is contained in substring i.e. original_string.substring(0, start_traversing_index - 1)
	if yes, then
		check if original_string.substring(0, start_traversing_index - 1).lenth >= result.length()
			if yes, then
				copy the substring to result  //to make sure result always carry the latest longest substring
			if not, ignore 
	if not, then advance start_traversing_index = start_traversing_index + 1



*/

import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;

public class FindUniqueCharLongestString{
	public static void main(String args[]){
		//Take input string
		System.out.println("Please provide an input string");
		Scanner scan = new Scanner(System.in);
		//String original_string = scan.nextLine();
	
                String input_string = scan.nextLine();
		StringBuffer original_string = new StringBuffer(input_string);

		System.out.println("System has received the following string as input: "+original_string);
		
		//you can convert the string to array as Strings are immutable, if you are planning to come up with some "in place" solution
		//For this code design, we will just deal with Strings
		
		//Take another string to store result
		//char[] result = new char[original_string.length()];
		StringBuffer result = new StringBuffer(original_string.length());
		

		// If only one character is passed as input string, the original string is returned
		if (original_string.length() < 2){
			result = result.delete(0,result.length());
			result = result.append(original_string);	
		}

		//if all characters are unique, then return the original string as is
		//Code still to be added
				
		int substr_start = 0;
		int start_traversing_index = substr_start + 1;
		//int original_string_end = original_string.length();	
		int i = start_traversing_index;
		//for (int i = start_traversing_index; i < original_string_end; i++)
		while (i < original_string.length())
		{
			//if (original_string.substring(substr_start, i).contains(original_string.charAt(i).subSequence(i,i)))
			System.out.println("Now checking: "+ original_string.charAt(i));
			System.out.println("Comparing if "+ original_string.charAt(i) + " is contained in " + original_string.substring(substr_start, i));
                        if (original_string.substring(substr_start, i).indexOf(original_string.charAt(i)) != -1)
			{
			int substr_end = i;
                        System.out.println(original_string.charAt(substr_end) + " is contained in " + original_string.substring(substr_start, substr_end));
			System.out.println("This time the substring having unique character we found is: "+ original_string.substring(substr_start, substr_end) + " of length: " + original_string.substring(substr_start, substr_end).length());	
				
				//set substr_start to index of repeated character in substring
				//substr_start = (original_string.substring(substr_start, i)).indexOf(original_string.charAt(i)) + 1;
				//System.out.println("Now the same process would start from substr_start index: " + substr_start);

				//Copy the substring to result array if length of already stored string in array is less than this one
				System.out.println("Let's check if we could find any longer substring before");
				
				if (result.length() > 1){
					System.out.println("The longest sub string we have found till moment is "+ result.toString()  + " of length " + result.length()); 
				}
				
				if (result.length() < original_string.substring(substr_start, substr_end).length())
				{
					System.out.println("As newly found substing is longer than previously found, so old one is being replaced by: "+ original_string.substring(substr_start, substr_end));
					if (result.length() < 1){
						//simply append
						result = result.append(original_string.substring(substr_start, i));
					} else {
						//Delete result and append
						result = result.delete(0,result.length());
						result = result.append(original_string.substring(substr_start, substr_end));
					}
				}
                                        //set substr_start to index of repeated character in substring
                                        //substr_start = (original_string.substring(substr_start, i)).indexOf(original_string.charAt(i)) + 1;
                                        //substr_start  = result.toString().indexOf(original_string.charAt(substr_end)) ;
                                        //substr_start  = original_string.substring(substr_start,substr_end).indexOf(original_string.charAt(substr_end)) + 1;
					//System.out.println("Now the same process would start from start_traversing_index index: " + start_traversing_index);
                                        //start_traversing_index = substr_start + 1;
					//System.out.println("Now the same process would start from start_traversing_index index: " + start_traversing_index);
                                        //i = start_traversing_index ;

					//Reduce original string as we don't need the part we already traversed
					original_string = original_string.delete(substr_start,original_string.substring(substr_start,substr_end).indexOf(original_string.charAt(substr_end))+1);
					System.out.println("Now the reduced original string is: "+ original_string.toString());
					i = start_traversing_index -1 ; //because anyhow i will be advanced by one at the end of the loop
			}
			i++ ;

		}		
		

		//Special Case: If you enter a string having no duplicates, this program would return empty string
		//Handle that case smartly
		if (result.length() < 1)
		{
			//Initialize result with original input string; It would protect you when input string has no duplicates
                	result = result.append(input_string.substring(0,original_string.length()));

		}
		
		System.out.println("The longest substring having unique characters is: "+ result.toString());
	}

}
