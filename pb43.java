/* A string can be partitioned into some substrings, such that each substring is a palindrome. 
For example, there are a few strategies to split the string “abbab” into palindrome substrings, 
such as: “abba”|”b”, “a”|”b”|”bab” and “a”|”bb”|”a”|”b”.

Given a string str, please get the minimal numbers of splits to partition it into palindromes. 
The minimal number of splits to partition the string “abbab” into a set of palindromes is 1.
*/


class pb43 {

	// we use dynamic programming to solve this 
	// f(i) = min( palidrome(i), palindrome(i-1)+1)
	public static int getMinSplits( String s ) {
		if ( s.length() == 0 ) {
			return 0;
		}
		if ( s.length() == 1) {
			return 1;
		}

		int[] minPalLength = new int[ s.length()];
		minPalLength[s.length()-1] = 1;
		int k = s.length() - 2;
		for ( int i = k; i>=0 ; i-- ) {
			minPalLength[i] = getMinPalindromeLength(s, i, minPalLength);
		}

		return minPalLength[0];
	}

	// get minimum palindrome length starting from ith position
	public static int getMinPalindromeLength( String s, int startPosition , int[] vals) {
		

		int minPalSplit = s.length() - startPosition;

		for ( int endPos = s.length()-1; endPos >= startPosition ; endPos-- ) {
			int p1 = startPosition;
			int p2 = endPos;
			// check all the palindromes starting from i to end
			boolean found = true;
			while ( p1 <= p2 && found ) {
				if ( s.charAt(p1) != s.charAt(p2) ) {
					found = false;
				}
				p1++;
				p2--;
			}

			if ( found ) {
				
				// we found a palindrome between p1 and i;
				int palLen = endPos - startPosition + 1;
				int totalSplit = 1;
				
				if ( endPos < s.length()-1 ) {
					totalSplit= totalSplit + vals[endPos+1];
					}	
				
				//	System.out.printf("Min palindrome for %s for %d - %d \n", s, minPalSplit, totalSplit ); 
				
				if ( minPalSplit > totalSplit){
					//System.out.printf("Final palindrome for %s for %d is %d\n", s, startPosition, totalSplit);
					minPalSplit = totalSplit;
				}
			}
		}
		return minPalSplit;

	}

	public static void main( String [] args ) {
		test1();
		test2();
		test3();


	}

	public static void test( int testNum, String s, int expected ) {
		int observed = getMinSplits( s ) ;
		if ( observed == expected ) {
			System.out.printf("Test %d passed for %s with splits %d \n", testNum, s, expected );
		}
		else {
			System.out.printf("Test %d failed for %s with splits %d \n",testNum, s, observed );
		}
	}

	// Test cases 
	public static void test1() {
		String s = "";
		int expected = 0 ;
		test( 1, s, expected);
	}

	// one char
	public static void test2() {
		String s = "a";
		int expected = 1;
		test( 2, s, expected);
	}

	public static void test3() {
		String s = "abbab";
		int expected = 2;
		test( 3, s, expected);
	}

}