/*
Given a matrix with 1s and 0s, please find the number of groups of 1s. A group is defined by horizontally or 
vertically adjacent 1s. For example, there are four groups of 1s in Figure 1 which are drawn with different colors.
*/


public class pb41 {


	//get Groups 
	public static int getGroups( int[][] input ) {
		// in order to be in a group its adjecent elements need to be 1
		int groups = 0;
		int rows = input.length;
		if ( rows == 0 ) {
			// its empty 
			return groups;
		}
		int cols = input[0].length;

		for( int i= 0 ; i< rows; i++ ) {
			for( int j = 0; j < cols; j++ ) {
				if ( input[i][j] == 1) {
					// we are only concerned when cell is 1
					if ( i== 0 && j == 0 ) {
						// for first element
						groups++;
					}
					else if (  ( j == 0 && input[i-1][j] == 0  )   || ( i == 0 && input[i][j-1] == 0) )  {
						// then in new group
						groups++;
					}
					else if ( j> 0 && i > 0 && input[i-1][j] ==  0 && input[i][j-1] == 0 ) {
						groups++;
					}
				}	

			}
		}
		return groups;

	}

	public static void main(String[] args ) {
		test1();
		test2();

	}



	// Test cases
	
	public static void test2() {
		int[][] input = { {1, 1, 0, 0, 1 } };
		int expected = 2;
		test( 2, input, expected);

	}
	public static void test1() {
		int[][] input = {
			 			 {1, 1, 0, 0, 1 },
			 			 {1, 0, 0, 1, 0 },
			 			 {1, 1, 0, 1, 0 },
			 			 {0, 0, 1, 0, 0 } };

		int expected = 4;
		test( 1, input, expected);
	}

	public static void test( int testnum, int[][] input, int expected ) {
		int observed = getGroups( input );

		// check if they are same

		if ( observed == expected) {
			System.out.printf("Success for Test %d . Got %d \n", testnum, observed );
		}
		else {
			System.out.printf("Failure for Test %d . . Got %d \n",testnum, observed  );
		}

	}


}