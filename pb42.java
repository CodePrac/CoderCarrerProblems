/* 
 Given an array of integers A, please find three indexes i, j, k, such that i<j<k and A[i]<A[j]<A[k].

 */

public class pb42 {

	public static void main( String args[]) {
		test1();
	}

	public static int[] getThreeIndex( int[] nums ) {
		int[] leastIndex =  new int[ nums.length];
		int[] largerIndex = new int[nums.length];
		int i = 0; 
		int j = -1; 
		int k = nums.length -1;


		// lets find index of smaller element moving from left
		for ( int x = 1 ; x< nums.length ; x++ ) {
			if ( nums[x] < nums[ leastIndex[x-1]] ) {
				leastIndex[x] = x;
			}
			else {
				leastIndex[x] = leastIndex[x-1];
			}
		}

		// lets find index of larger elements moving from right
		largerIndex[ nums.length -1 ] = nums.length -1;
		for ( int x = nums.length -2 ; x <= 0 ; x-- ) {
			if ( nums[x] > nums[largerIndex[x+1]] ) {
				largerIndex[x] = x;
			}
			else {
				largerIndex[x] = largerIndex[x+1];
			}
		}


		// lets find the middle element
		for ( int x = 1 ; x < nums.length ; x++ ) {
			if ( leastIndex[x] < x  && largerIndex[x] > x ) {
				// we found our element
				i = leastIndex[x];
				j = x;
				k = largerIndex[x];
			}
		}
		if ( j == -1 ) {
			return null;
		}
		else {
			return { i, j, k}
		}

	}


	public static void test1() {
		int[] numbers = { 5,4,2,8,10,6};
		int[] expected = { 2, 3, 4}; 
		test( 1, numbers, expected);
	}

	// Test cases
	public static void test( int testnum, int[] input, int[] expected ) {
		int [] observed = getThreeIndex( input );

		// check if they are same

		if ( matchArray( observed, expected) ) {
			System.out.printf("Success for Test %d ");
		}
		else {
			System.out.printf("Failure for Test %d ");
		}

	}

	private static boolean matchArray( int[] observed, int[] expected) {

		if ( observed == null && expected == null ) {
			return true;
		}
		else if ( observed == null || expected == null ) {
			// if one of them is null
			return false;
		}

		if ( observed.length != expected.length ) {
			return false;
		}

		for ( int i = 0 ; i< observed.length; i++ ){
			if ( observed[i] != expected[i]) {
				return false;
			}
		}

		return true;	
	}


}
