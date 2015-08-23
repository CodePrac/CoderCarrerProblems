/*
Given a number, please translate it to a string, following the rules: 
1 is translated to 'a', 2 to 'b', …, 12 to 'l', …, 26 to 'z'. 
For example, the number 12258 can be translated to "abbeh", "aveh", "abyh", "lbeh" and "lyh", 
so there are 5 different ways to translate 12258. How to write a function/method to count 
the different ways to translate a number?
*/


public class pb56 {

	public static void main( String[] args ) {
		int num = 12258;
		int res = getNumTrans(  num);
	}

	public static int getNumTrans( int num) {
		if ( num <= 0 ) {
			return 0;
		}

		// convert number to chararray
		char[] n = Integer.toString(num).toCharArray();


	}


	public static int getCombinations( char[] n , int start ) {
		
		if ( start == ( n.length - 1 ) ) {
			//combos = combos ++;
			return combos++;
		}

		for ( int i = start; i< n.length; i++ ) {
			for ( int j = 1 ; j <= 2; j++ ) {

				if ( isValidCombo( n, start, j )) {
					combos = getCombinations( n, start+j )
				}
				else {
					return combos;
				}
			}
			
			
		}

	}

	private static Boolean isValidCombo( char[] n , int start, int length) {
		if (length == 1 ) {
			return True;
		}
		if ( length == 2 && ( start+1 <  n.length ) ) {
			String nu = n[start]+n[start+1];

			if ( Integer.valueOf(nu) <= 26 ) {
				return True;
			}
		}
		else {
			return False;
		}
	} 
}