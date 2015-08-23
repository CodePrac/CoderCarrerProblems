/*
 Reorder the digits of a number, in order to get the next number 
 which is the least one that is greater than the input number. F
 or example, the number 34724126 is the next number of 34722641 when reordering digits.
 */
 import java.util.*;
 public class pb51 {

 	public static void main( String[] args) {
 		int num = 102;

 		int res = getNextNumber( num);
 		System.out.println( " The next number is - "+res);

 	}

 	public static int getNextNumber( int num ) {
 		// 1. check and get array of numbers that needs to be switched
 		int residual = num;
 		List<Integer> switches = new ArrayList<Integer>();
 		int lastDigit = residual % 10 ;
 		residual = residual / 10;

 		switches.add( lastDigit);
 		
 		Boolean bigRightDigit = false;

 		// here we get all the digits starting from left before the right digit is larger
 		while ( residual > 0 &&  !bigRightDigit ) {
 			int d = residual % 10;
 			residual = residual / 10;
 			switches.add( d);
 			if ( lastDigit > d ) {
 				bigRightDigit = true;
 			}
 			lastDigit = d;
 		}

 		// There is no next number available. This is the largest number
 		if ( !bigRightDigit) {
 			return -1;
 		}

 		//Now lets sort the switches array
 		Collections.sort( switches);

 		// we want the least bigger digit then the lastdigit
 		
 		int lastdigitIndex = 0;

 		for ( int i = 0; i<switches.size(); i++) {
 			if ( switches.get(i) == lastDigit ) {
 				lastdigitIndex = i;
 			}
 		}

 		// we want to add the next number in switches array to the residual
 		residual = residual * 10 + switches.get( lastdigitIndex+1 );
 		// delete this digit from the list
 		switches.remove(lastdigitIndex+1);

 		// now add rest of the digits in ascending order
 		for ( int i : switches ) {
 			residual = residual * 10 + i;
 		}


 		return residual;
 	}

 }