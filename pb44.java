/*
There are n houses built in a line, each of which contains some value in it. 
A thief is going to steal the maximal value in these houses, 
but he cannot steal in two adjacent houses because the owner of a stolen house 
will tell his two neighbors on the left and right side. What is the maximal stolen value?

For example, if there are four houses with values {6, 1, 2, 7}, 
the maximal stolen value is 13 when the first and fourth houses are stolen.
*/

// This problem has a dynamic solution 
// f(i) = max( f(i-1), f(i-2)+val(i) )
class pb44 {



	public static int getMaxValue( int[] values ) {
		int max = 0;
		if ( values.length == 0 ) {
			return 0;
		}
		if ( values.length == 1 ) {
			return values[0];
		}
		if ( values.length == 2 ) {
			return Math.max( values[0], values[1]);
		}
		int [] maxVals = new int[ values.length];
		maxVals[0] = values[0];
		maxVals[1] = Math.max( values[0], values[1]);


		for ( int i = 2 ; i< values.length; i++ ) {
			maxVals[i] = Math.max( maxVals[i-1], ( maxVals[i-2]+values[i] ));
		}

		return maxVals[values.length -1 ];
	}

	public static void main(String[] args ) {
		test1();
		test2();
		test3();
	}

	public static void test(int[] values , int expected ){
		int observed = getMaxValue( values );
		if ( observed == expected ){
			System.out.println( "Test passed for value "+expected);
		}
		else {
			System.out.println( "Test failed for value "+expected);
		}
	}

	// Test cases
	public static void test1( ) {
		int[] values = {6, 1, 2, 7};
		int expected = 13;
		test( values, expected);
	}
	// only one house
	public static void test2() {
		int[] values = { 6};
		int expected  = 6;
		test( values, expected);
	}

	// no houses
	public static void test3() {
		int[] values = { };
		int expected  = 0;
		test( values, expected);
	}


}