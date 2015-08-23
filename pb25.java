/*

Implement a function which gets the edit distance of two input strings. 
There are three types of edit operations: insertion, deletion and substitution. 
Edit distance is the minimal number of edit operations to modify a string from one to the other.

For example, the edit distance between “Saturday” and “Sunday” is 3, since the following three edit operations are required to modify one into the other:
1.       Saturday → Sturday (deletion of ‘a’)
2.       Sturday→ Surday (deletion of ‘t’)
3.       Surday → Sunday (substitution of ‘n’ for ‘r’)

There is no way to achieve it with fewer than three operations.

Sol
Using Dynamic programming


*/

public class pb25 {


	
	public static void main(String[] args ) {
		test1();
		test2();
		test3();
	}

	public static void test( int testNum, String s1, String s2, int expected ) {
		int observed = getEditDistance( s1, s2);
		if ( observed == expected ) {
 			System.out.printf( "Test %d succeded \n",testNum);
 		}
 		else {
 			System.out.printf( "Test %d failed. Expected - %d , observed - %d \n", testNum, expected, observed);
 		}
	}

	public static void test1() {
		String s1 = "Saturday";
		String s2 = "Sunday";
		int expected = 3;
		test(1, s1, s2, expected);
	}
	public static void test2() {
		String s1 = "";
		String s2 = "Sunday";
		int expected = 6;
		test(2, s1, s2, expected);
	}
	public static void test3() {
		String s1 = "Saturday";
		String s2 = "";
		int expected = 8;
		test(3, s1, s2, expected);
	}
}