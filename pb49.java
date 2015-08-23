/*
Given a string, please get the length of the longest substring which does not have duplicated characters. 
Supposing all characters in the string are in the range from ‘a’ to ‘z’.

*/

public class pb49 {

	public static int longestSubstringWithoutDuplication( final String inputString) {
		char[] input = inputString.toCharArray();
		// check the length of the string
		if ( input.length < 1  ) {
			return 0;
		}
		if ( input.length == 1 ) {
			return 1;
		}

		int[] length = new int[ input.length  ];
		length[0] = 1;
		int maxLength = 1;
		// lets look at the string from 2nd char
		for ( int i = 1 ; i< input.length; i++ ) {
			// compare it with previous chars , starting from i-1
			boolean dup = false;
			int j = i-1;
			while ( j >= 0 && !dup ) {
				if( input[j] == input[i]) {
					dup = true;
				}
				else {
					j--;
				}
			}

			//if no dupe, then increment previous substring count by 1
			if ( !dup ) {
				length[i] = length[i-1] + 1;
			}

			// jth position will have the last matching dupe
			if ( dup  ) {
				// check if dup in this substring or previous one
				// if previous substring length is less then relative position behind then its not part of this 
				// substring
				if (  length[i-1] < ( i-1 - j )) {
					length[i] = length[i-1] + 1;
				}
				else {
					// need to calculate new substring lenght
					length[i] = i-j ;
				}

			}
			if ( length[i] > maxLength ) {
				maxLength = length[i];
			}
			
		}

		return maxLength;

	}


	public static void main( String[] args ) {
		//test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();

	}

	// test cases

	private static void test(String input, int expected) {
		int output = longestSubstringWithoutDuplication(input);
		if(output == expected) {
			System.out.println("Solution 1 passed, with input: " + input);
		}
		else {
			System.out.println("Solution 1 FAILED, with input: " + input + "- "+output+" - " + expected);
		}
	}
	private static void test1() {
		String input = "abcacfrar";
		int expected = 4;
		test(input, expected);
	}

		private static void test2() {
		String input = "acfrarabc";
		int expected = 4;
		test(input, expected);
	}
 
	private static void test3() {
		String input = "arabcacfr";
		int expected = 4;
		test(input, expected);
	}
 
	private static void test4() {
		String input = "aaaa";
		int expected = 1;
		test(input, expected);
	}
 
	private static void test5() {
		String input = "abcdefg";
		int expected = 7;
		test(input, expected);
	}
 
	private static void test6() {
		String input = "aaabbbccc";
		int expected = 2;
		test(input, expected);
	}
 
	private static void test7() {
		String input = "abcdcba";
		int expected = 4;
		test(input, expected);
	}
 
	private static void test8() {
		String input = "abcdaef";
		int expected = 6;
		test(input, expected);
	}
 
	private static void test9() {
		String input = "a";
		int expected = 1;
		test(input, expected);
	}
 
	private static void test10() {
		String input = "";
		int expected = 0;
		test(input, expected);
	}

}