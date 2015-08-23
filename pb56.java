/*
A board has n*m cells, and there is a gift with some value (value is greater than 0) in every cell. 
You can get gifts starting from the top-left cell, and move right or down in each step, 
and finally reach the cell at the bottom-right cell. What’s the maximal value of gifts you can get from the board?
*/



public class pb56 {

	public static void main ( String[] args ) {
		test1();
	}

	public static void test1() {
		System.out.println ("Test 1 ");
		int[][] d = {{ 1, 10, 3, 8},
					 { 12, 2, 9, 6 },
					 { 5, 7, 4, 11},
					 { 3, 7, 16, 5 }
					};
		int res = getMaxValue( d );
		System.out.println ( "Max val - " + res );
	}

	public static int getMaxValue( int[][] values ) {

		
		int rows = values.length;
		int cols = values[0].length;
		int[][] maxVals = new int[rows][cols];

		//maxVals[i][j] = values[i][j];
		for ( int x = 0 ; x < rows; x++) {
			for ( int y = 0 ; y < cols; y++ ){
				int i = 0; 
				int j = 0;

				if ( x > 0 ) {
					i = maxVals[x-1][y];
				}	
				if ( y > 0 ) {
					j = maxVals[x][y-1];
				}
				maxVals[x][y] = Math.max( i,j ) + values[x][y];
			}
		}
		return maxVals[rows-1][cols-1];
	}




}