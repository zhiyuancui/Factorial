/**
 * A java implementation of factorial using iterative ways.
 * @author Zhiyuan
 *
 */
public class Factorial {

	/**
	 * Accept a small input number and return the
	 * factorial of it.
	 * @param num which is should be less than 25,
	 *        otherwise will overflow.
	 * @return the factorial of input number
	 */
	private long calculateSmallInt(int num)
	{
		if( num < 2 )
		{
			return 1;
		}
		
		long fac = 1;
		
		while( num > 1 )
		{
			fac *= num;
			num--;
		}
		
		return fac;
	}
	
	/**
	 * Implemente big number multiply
	 * @param s1
	 * @param s2
	 * @return return the result in a string
	 */
	private String bigIntMultiply(String s1, String s2)
	{
		if( s1.equals("1") || s2.equals("1") )
		{
			return s1.equals("1") ? s2 : s1;
		}
		
		int len1 = s1.length();
		int len2 = s2.length();
		int[] result = new int[len1+len2];
		
		for(int i = len2-1; i >=0; i--)
		{
			if( s2.charAt(i) == '0' )
			{
				continue;
			}
			for(int j = len1 - 1; j >=0; j--)
			{
				result[i+j+1] += toInt(s1.charAt(j)) * 
						       toInt(s2.charAt(i));
			}
		}
		
		//Convert Integer array to String
		String s = "";
		int carry = 0;
		for(int i = result.length - 1; i >= 0; i--)
		{
			int digit = result[i] + carry;
			carry = digit / 10;
			digit = digit % 10;
			s = digit + s;
		}
		
		//remove the first 0 
		return s.charAt(0) == '0' ? s.substring(1) : s;
	}
	
	/**
	 * Convert character to int
	 * @param c
	 * @return
	 */
	private int toInt(Character c)
	{
		return c-'0';
	}
	
	/**
	 * The main function to calculate factorial
	 * @param n
	 * @return
	 */
	private String calculate(int n )
	{
		if( n <= 20 )
		{
			return Long.toString( calculateSmallInt(n) );
		}
		
		String fac = "1";
		while( n > 20 )
		{
			fac = bigIntMultiply(fac, Integer.toString(n) );
			n--;
		}
		
		return bigIntMultiply(fac, 
					Long.toString( calculateSmallInt(20) ) );
	}
	
	
	public static void main(String[] args)
	{
		Factorial f = new Factorial();
		System.out.println(f.calculate(26));
	}
}
