/*

Given an array and a value, how to implement a function to remove all instances of that value in place 
and return the new length? The order of elements can be changed. 
It doesn't matter what you leave beyond the new length.

*/

public class pb32 {

	public static int[] removeValue( int[] numbers, int value) {
		// we use two pointers one searching for the value and other from the end replacing the values
		int p1 = 0;
		int p2 = numbers.length -1;

		while( p1 <= p2 ) {
			// ignore all the numbers with value at the end of the array
			while ( numbers[p2] == value) {
				p2--;
			}
			if ( numbers[p1] == value ) {
				numbers[p1] = numbers[p2];
				p2--;
			}
			p1++;
		}
		int[] res = new int[ p1];
		for ( int i = 0 ; i< p1; i++) {
			res[i] = numbers[i];
			System.out.printf(" %d", res[i]);
		}

		System.out.println("");

		return res;

	}


	public static void main(String[] args ) {
		test1();

	}	

	public static void test( int testNum, int[] numbers,int value, int[] expected) {
		int [] observed = removeValue( numbers, value);
		boolean equals = true;

		for( int i = 0 ; i < expected.length;  i++ ) {
			if ( observed[i] != expected[i]) {
				equals = false;
			}
		}

		if ( equals ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . \n", testNum );
		}
	}

	public static void test1() {
		int[] nums = new int[] {4, 3, 2, 1, 2, 3, 6};
		int[]  expected = new int[] { 4, 3, 6, 1, 3 };
		
		test( 1, nums, 2, expected);

			
	}

}