/*
When some elements at the beginning of an array are moved to the end, 
it gets a rotation of the original array. Please implement a function to search a number in a r
otation of an increasingly sorted array. Assume there are no duplicated numbers in the array.
For example, array {3, 4, 5, 1, 2} is a rotation of array {1, 2, 3, 4, 5}. 
If the target number to be searched is 4, the index of the number 4 in the rotation 1 should be returned. 
If the target number to be searched is 6, -1 should be returned because the number 
does not exist in the rotated array.
*/

public class pb47 {


	public static int getIndexLocation( int [] data , int number ) {
		// since the array is rotated lets check which half has the number and rotation
		int p1 = 0;
		int p2 = data.length -1 ;
		int mid = 0;

		boolean found = false;
		int resIndex = -1;

		while ( ( p2 - p1 >= 0  )  &&  ! found ) {

			mid = p1 + ( int ) (p2-p1) / 2 ;

			if ( number == data[mid]) {
				found = true;
				resIndex = mid;
			}
			else { 
			// check second sub array
				if ( data[mid] <= data[p2] ) {
					/// this sub array is without rotation and increasingly sorted
					if ( number > data[mid] && number <= data[p2] ) {
						// number is in this sub-array
						//p1 = mid+1;
						// or 
						return bst( number, data, mid+1, p2 );
						
					}
					else {
						// number in first sub array
						p2 = mid-1;
					}
				}
				else if ( data[mid] > data[p1] ) {
					// this sub array is without rotation and increasingly sorted
					if ( number >= data[p1] && number < data[mid]) {
						//p2 = mid-1;
						return bst( number, data, p1, mid - 1 );
					}
					else {
						// number in second subarray
						p1 = mid+1;
					}
				}
			}
		}

		return resIndex;  

	}


	public static int bst( int num, int[] data, int start, int end ) {
		if ( end < start ) {
			return -1;
		}
		int mid = start + ( end -start) /2 ;
		if ( num == data[mid] ) {
			return mid;
		}

		else if ( num > data[mid]) {
			return bst( num, data, mid+1, end );
		}
		else {
			return bst(num, data, start, mid-1);
		}

	}

	public static void main( String[] args) {
		test1();
		test2();
		test3();
		test4();

	}


	public static void test( int[] data, int number, int expected) {
		int  index = getIndexLocation( data, number );
		if ( expected == index ) {
			System.out.print("Sucess for number "+ number + "and data -");
			printArrary(data);
			System.out.println("\n");
		}
		else {
			System.out.print("Failed for number "+ number + "and data -" + "Got - "+index);
			printArrary(data);
			System.out.println("");
			


		}
	}

	private static void printArrary( int[] data ) {
		for ( int i : data ) {
			System.out.print(" "+i);
		} 
	}

	// test cases 

	public static void test1() {
		int [] data = { 3,4,5,1,2};
		int num = 4;
		test( data, num, 1);
	}

	public static void test2() {
		int [] data = { 3,4,5,1,2};
		int num = 6;
		test( data, num, -1);
	}

	public static void test3() {
		int [] data = { };
		int num = 6;
		test( data, num, -1);
	}

	public static void test4() {
		int[] data = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int num = 14;
		test( data, num, 11) ;
	}



}
