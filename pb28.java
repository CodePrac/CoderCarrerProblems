/*
 A pair contains two numbers, and its second number is on the right side of the first one in an array.
  The difference of a pair is the minus result while subtracting the second number from the first one. 
  Please implement a function which gets the maximal difference of all pairs in an array. 
  For example, the maximal difference in the array {2, 4, 1, 16, 7, 5, 11, 9} is 11, 
  which is the minus result of pair (16, 5).

  Solution 1 - Brute force - O(n**2)
  Soulution 2 - Dynamic Programming - Start from the end
  	f( x(i) ) = max( x(i) - x(i-1), x(i) - x(i-1) + f(x(i-1)) )

  Solution 3 - Find max number at left of each position of i by scanning 
  Maximal difference - max - that number 


 */


public class pb28 {


	public static int getMaximalDiff( int[] numbers ) {
		
		int max = numbers[0];
		int maxDiff = max - numbers[1];
		
		for ( int i= 2; i< numbers.length; i++  ) {
			max = Math.max( numbers[i-1], max) ;

			if ( maxDiff < ( max - numbers[i]) ) {
				maxDiff = max - numbers[i];
			}
		}

		return maxDiff;
	}

	public static void main( String[] args) {
		test1();
	}

	public static void test( int testNum, int[] numbers, int expected) {
		int observed = getMaximalDiff( numbers);
		boolean equals = true;

		if ( observed == expected ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . \n", testNum );
		}
	}

	public static void test1() {
		int[] nums = new int[] {2,4,1,16,7,5,11,9};
		int  expected = 11;
		
		test( 1, nums, expected);

			
	}
}
