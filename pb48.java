/*
Please get the least number after deleting k digits from the input number. 
For example, if the input number is 24635, the least number is 23 after deleting 3 digits.
*/

public class pb48 {


	// delete k digits from num and return least number
	public static int getLeastNumber( int num, int k ) {
		if ( num < 0 ) {
			return -1;
		}
		
		// convert number to a string
		String n = ""+num;
		if ( ! isPossibleDelete( n, k ) ) {
			return -1 ;
			// throw new illegalArgumentExcepection();
		}

		int len = n.length();
		// delete k digits
		for ( int i = 0 ; i < k; i ++ ) {
			int firstDecreasingIndex = getFirstDecreasingIndex( n );
			n = deleteDigit(n, firstDecreasingIndex );
		}
		return Integer.parseInt(n);	

	}
	

	private static String deleteDigit( String n , int index ) {
		String t1 = n.substring( 0, index ) ;
		String t2 = "";
		if ( index < n.length() - 1 ) {
			t2 = n.substring( index+1, n.length() );
		} 
		return t1+t2;
	}
	

	private static int getFirstDecreasingIndex( String n ) {
		int len = n.length();
		for ( int i = 0 ; i < len-1 ; i++ ) {
			int curDigit = n.charAt(i) - '0';
			int nexDigit = n.charAt(i+1) - '0';
			if ( curDigit > nexDigit ) {
				return i ; 
			}	
		}
		// if all digits are in increasing order return the last one as its the largest
		return len-1; 
	}

	private static boolean isPossibleDelete( String num , int k ) {
		if ( num.length() > k ) {
			return true;
		}
		return false;
	}

	public static void main ( String[] args ) {
		test1();
		test2();
		test3();
	}

	// Test cases
	public static void test( int number, int k , int expected  ) {

		int generated = getLeastNumber(  number,  k );
		if ( expected == generated ) {
			System.out.println( "Passed Test for "+ number );
		}
		else {
			System.out.println("Test failed for "+number );
		}
	}

	// given example
	public static void test1() {
		int number = 24635;
		int k = 3;
		test( number, k , 23 );
	}


	public static void test2() {
		int number = 50;
		int k = 2;
		test( number, k , -1 );
	}

	
	public static void test3() {
		int number = 29;
		int k = 1;
		test( number, k , 2 );
	
	}
	

	 

}
