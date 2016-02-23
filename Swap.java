/**
 * 
 */
package com.latha.math;

/**
 * @author anwita
 *
 */
public class Swap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x,y;
		x=4;
		y=3;
		x = x^y;
	    y = x^y;
	    x = x^y;
		
		System.out.println("x = "+x+"\ny = "+y);

	}

}
