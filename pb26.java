/*
Please implement a function which gets the minimal number of coins, 
whose value is v1, v2, …, vn, to make change for an amount of money with value t. 
Any coin with value vi may duplicate for any times to make change.

For example, the minimal number of coins to make change for 15 out of a set of 
coins with value 1, 3, 9, 10 is 3. 
We can choose two coins with value 3 and a coin with value 9.
 The number of coins for other choices should be greater than 3.

Solution :
F(i) = min( f(i-c1)+c1, f(i-c2)+c2 ... )
*/


public class pb26 {

	public static int getMinCoins( int[] coins, int value ) {
		int [] minCoins = new int[ value+1];
		minCoins[0] = 0;
		minCoins[1] = 1;
		for ( int i = 2 ; i<= value; i++ ) {
			int min = Integer.MAX_VALUE;
			for ( int c = 0 ; c < coins.length; c++ ) {
				if ( coins[c] <= i  ) {
					// lets consider this coin
					min = Math.min( minCoins[i-coins[c]] + 1, min );
				}
			}
			minCoins[i] = min;

		}
		return minCoins[value];

	}
	public static void main( String[] args ) {
		test1();
	}

	public static void test( int testNum, int[] coins, int value, int expected) {
		int observed = getMinCoins( coins, value);

		if ( observed == expected ) {
 			System.out.printf( "Test %d succeded \n",testNum);
 		}
 		else {
 			System.out.printf( "Test %d failed. Expected - %d , observed - %d \n", testNum, expected, observed);
 		}
	}

	public static void test1() {
		int[] coins = new int[]{1, 3, 9, 10 };
		int value = 15;
		int expected = 3;
		test( 1, coins, value , expected);
	}
}