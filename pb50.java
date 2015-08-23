/*
In an array, all numbers appear three times except one which only appears only once. Please find the unique number.
*/

// 1. Assume every number is an integer
// 
//import java.lang.illegalArgumentException;

class pb50 {

	public static void main( String[] args ){

		// test case 
		//int[] data = { 10, 10, 7, 10, 7, -2, 7};
		int[] data = {1024, -1025, 1024, -1025, 1024, -1025, -1023};	

		int res = findNumber( data );
		System.out.println( " Result - "+res);
	}


	public static int findNumber( final int[] data )  {
		// 1. check if array is empty or return exception
		if ( data.length == 0 ) {
			throw new IllegalArgumentException();
		}
		// lets get an array of 32 length - since int is 32 bits
		int[] bits = new int[32];
		// for each value in the data - lets add their bits
		for ( int n : data ) {
			int i = 0;
			while ( n != 0 ) {

				bits[i] += n & 1;
				n = n >>> 1 ;
				i = i+1;
			}
		}


		// since all the numbers are repeated three times except one - we divide by three and get remainder at each bit
		int res = 0;
		for( int i = (bits.length - 1  ); i >= 0; i--) {
			
			bits[i] = bits[i] % 3;
			if ( bits[i] == 1 ) {
				int bitFlag = bits[i] << i ;
				res = res | bitFlag;  
			}
			
			

		}

		// first method 

		// Second method
		// if last bit is set then the number is negative
		//if ( bits[ length - 1]  == 1 ) {
			// take two's complement

		//}
		return res;

	}
}