package lct.amazon;

/*
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */

public class StringToIntegerATOI {

	public int myAtoi(String s) {
		int sign = 1; // sign (to store the sign of the final result) as 1.
		int result = 0; //result (to store the 32-bit integer result) as 0.
		int index = 0; 
		int n = s.length();
		
		while(index < n && !Character.isDigit(s.charAt(index))) {			
			index++;
		}
		
		if (index > 0) {
			index = index -1;
		}
		
		
		// clean all whitespace on string
		while(index < n && s.charAt(index) == ' ') {
			index++;
		}
		
		// sign = +1, if it's positive number, otherwise sign = -1. 
		if(index < n && s.charAt(index) == '+') {
			sign = 1;
			index++;
		} else if(index < n && s.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		
		while(index < n && Character.isDigit(s.charAt(index))) {
			int digit = s.charAt(index) - '0';
			
			 // Check overflow and underflow conditions. 
            if ((result > Integer.MAX_VALUE / 10) || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {     
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.    
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
			
			result = 10 * result + digit;
			index++;
		}
		
		return sign * result;
	}

	
	public static void main(String[] args) {
		
		StringToIntegerATOI sti = new StringToIntegerATOI();
		
		System.out.println(sti.myAtoi("a  -123 number"));
		
		System.out.println(sti.myAtoi("b  +456 number"));
		
		System.out.println(sti.myAtoi("   -789 number"));
		
		System.out.println(sti.myAtoi("-100"));
		
		System.out.println(sti.myAtoi("   -999 number 666"));
		
		System.out.println(sti.myAtoi("000200"));

	}

}
