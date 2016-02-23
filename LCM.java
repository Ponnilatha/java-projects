/**
 * 
 */
package com.latha.math;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lathaS
 *
 */
public class LCM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long[] inputNumbers = {7,14,28};
		/* Calling the LCM method for manipulation*/
		long result = lcmOfNumbers(inputNumbers);
		System.out.println("The LCM of 1st,2nd and 4th multiples of 7 is:" + result);
		
		List<String> input = new LinkedList<String>();
		input.add("a");
		input.add("b");
		input.add("c");
		int size = input.size();
		int halfSize = 0;
		if(size%2!=0){
			halfSize = (size%2)+1;
		}else{
			halfSize =size/2;
		}
		
		input.get(halfSize);
		

	}
	
	/**
	 * This method is used to find the GCD of two number using Euclid's algorithm
	 * @param x
	 * @param y
	 * @return GCD of the two numbers using Euclid's algorithm
	 */
	private static long gcd(long x, long y)
	{
	    while (y > 0)
	    {
	        long temp = y;
	        /* Getting the remainder x and y */
	        y = x % y; 
	        /* Assigning the y as per the Euclid's algorithm if y is not 0 */
	        x = temp;
	    }
	    return x;
	}
	
	
	/**
	 * This method is used to find the LCM of two number
	 * @param a
	 * @param b
	 * @return LCM of the two numbers
	 */
	private static long lcm(long a, long b)
	{
		/* applying algorithm for just two number*/
	    return a * (b / gcd(a, b));
	}

	/**
	 * This method is used to find the LCM of n set of numbers
	 * @param input set of numbers
	 * @return LCM of n set of numbers
	 */
	private static long lcmOfNumbers(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) 
	    	result = lcm(result, input[i]);
	    return result;
	}
}
