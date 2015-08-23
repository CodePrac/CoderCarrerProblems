/*
An array n - 1 unique numbers in the range from 0 to n - 1. 
There is only one number in the range from 0 to n - 1 missing. 
Please write a function to find the missing number. 

Ans : - if only one number is missing then we add all the numbers in array and then add all the indicies. 
Their difference should give us the missing number
to add all the numbers from 0 -- n-1  -> n( n-1)/2


Part 2 
An sorted array n - 1 unique numbers in the range from 0 to n - 1. 
There is only one number in the range from 0 to n - 1 missing. 
Please write a function to find the missing number. 

USE Binary search to find the position where number became different  

*/

public class pb37 {


	public static int findMissing( int[] num ) {


		int len = num.length;
		if ( len < 2 ) {
			return -1;
		}
		// this  type cast is very important or overflow error
		long indexSum = ( (long) len * ( len - 1) ) /2 ;
		long dataSum = 0;
		
		// get sum of all the numbers 
		for ( int i = 0; i< len; i++ ){
			dataSum = dataSum + num[i];
		}
		
		return (int) ( indexSum - dataSum );
	}

	public static void main( String[] args) {
		test1();
		test2();
	}


	public static void test( int testNum, int[] num, int expected ) {
		int observed = findMissing( num );
		if ( expected == observed ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . expected - %d , observed - %d \n", testNum, expected, observed );
		}
	}
	public  static void test1() {
		int[] num = { 1, 2, 3,0, 0 };
		int expected = 4;
		test( 1, num, expected);

	}

	public static void test2() {
		int[] num = new int[ 100000];
		int expected = 3322;
		for ( int i = 0; i< 100000; i ++)  {
			if ( i == expected ) {
				num[i] = 0;
			}
			else { 
				num[i] = i;
			}
		}
		test( 2, num, expected);
	}
}