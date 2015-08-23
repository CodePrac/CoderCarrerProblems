// code career pb - 57
/*

Integers in an array are unique and increasingly sorted. 
Please write a function/method to find an integer from the array who equals to its index. 
For example, in the array {-3, -1, 1, 3, 5}, the number 3 equals its index 3.

*/


public class pb57 {


public static void main( String[] args) {

	int[] in = { -3, -1, 1, 3 ,5};
	//int res  = getMatchingIndex( in, 0 , in.length );
	int res = getMatchingIndexNR(in);
	if ( res == -1 ) {
		System.out.println("No Match found");
	}
	else {
		System.out.println("Match at index - "+res);
	}

}

public static int getMatchingIndex( int[] in, int start, int end ) {
	if ( start > end  ) {
		return -1 ;
	}

	int mid = start + (int)( ( end - start ) / 2  );

	if (  in[mid] < mid ) {
		// no matching in left side 
		return getMatchingIndex(  in, mid+1, end);
	}
	else if ( in[mid] > mid ) {
		// no matching value on right side
		return getMatchingIndex( in, start, mid-1 );
	}
	else {
		return mid;
	}
	
}

public static int getMatchingIndexNR( int[] in ) {
	
	if ( in == null ||  in.length == 0 ) {
		return -1;
	}

	int start = 0; 
	int end = in.length -1 ;

	while ( start <= end ) {
		int mid = start + (int) (( end - start) / 2 ); 

		if ( mid == in[mid]) {
			return mid;
		}
		else if ( in[mid] < mid ) {
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}

	return -1;
}


}
