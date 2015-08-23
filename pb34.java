/*
How to implement a function to check whether there is a path for a string in a matrix of characters? 
 It moves to left, right, up and down in a matrix, and a cell for a movement. T
 he path can start from any entry in a matrix. If a cell is occupied by a character of a string on the path, 
 it cannot be occupied by another character again.

For example, the matrix below with three rows and four columns has a path for the string “BCCED” 
(as highlighted in the matrix). 
It does not have a path for the string “ABCB”, 
because the first “B” in the string occupies the “B” cell in the matrix, 
and the second “B” in the string cannot enter into the same cell again.

A B C E 
S F C S
A D E E 

// This can be solved using bfs on graph
// Also using dynamic programming

*/
import java.util.*;

public class pb34 {



	public static boolean isPathForString( String[][] matrix, String tobeFound ) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		boolean found = false;
		// check the starting position 
		for ( int i=0; i< rows; i++ ) {
			for ( int j = 0; j< columns ; j++ ) {
				if ( matrix[i][j].equals( String.valueOf( tobeFound.charAt(0) ) ) ) {
					// This could be the starting position for our path
					found = doBFSAndCheck( matrix, i, j , tobeFound);
				}
				if ( found ) {
					break;
				}

			}
		}

		return found;
	}

	public static boolean doBFSAndCheck( String[][] matrix, int rowPos, int colPos, String tobeFound) {
		// given a starting position we need to check progressively for the path
		Queue<Coordinate> q = new LinkedList<Coordinate>();
		q.add(new Coordinate(rowPos, colPos));
		boolean found = false;
		boolean isPossible = true;
		String s = tobeFound;
		boolean visited[][] = new boolean[ matrix.length ][ matrix[0].length];

		//System.out.printf( "Visiting - %s, Remaining - %s ", matrix[rowPos][colPos], s );
		while ( !q.isEmpty() && !found   ) {

			Coordinate n = q.poll();
			
			//System.out.printf( "Visiting - %s, Remaining - %s ", matrix[n.x][n.y], s );
			if ( matrix[n.x][n.y].equals(  String.valueOf( s.charAt(0) ) ) && ! visited[n.x][n.y]  ) {
				// mark this node as visited 
				visited[n.x][n.y] = true;
				// remove the first char from the s
				s = s.substring(1);
				// we need to explore this path further
				// up
				if ( s.length() == 0) {
					found = true;
					continue;
				}
				if ( inBoundary( n.x, n.y+1, matrix ) && ! visited[n.x][n.y+1]  ) {
					q.add( new Coordinate(n.x, n.y+1));
				}
				// down
				if ( inBoundary( n.x, n.y-1, matrix ) && ! visited[n.x][n.y-1]  ) {
					q.add( new Coordinate(n.x, n.y-1));
				}
				// right
				if ( inBoundary( n.x+1, n.y , matrix) && ! visited[n.x+1][n.y]  ) {
					q.add( new Coordinate(n.x+1, n.y));
				}
				// left
				if ( inBoundary( n.x-1, n.y, matrix ) && ! visited[n.x-1][n.y]  ) {
					q.add( new Coordinate(n.x-1, n.y));
				}

			}
			else {
				// we dont need to explore this path
			}

		}

		return found;

	}


	public static boolean inBoundary( int row, int col, String[][] matrix) {
		if ( row < matrix.length && row >= 0  && col >= 0  & col< matrix[0].length) {
			return true;
		}
		else {
			return false;
		}
	}


	public static void main ( String[] args ) {
		test1();
		test2();
		test3();
	}

	public static void test( int testNum, String[][] matrix, String s, boolean expected) {
		boolean observed = isPathForString( matrix, s) ;

		if ( expected == observed ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . expected - %b , observed - %b \n", testNum, expected, observed );
		}
	}



// test case 
	public static void test1() {
		String[][] matrix =  new String[][] {
			{"A", "B", "C", "E"  },
			{"S", "F", "C", "S" },
			{ "A", "D", "E", "E" }
		};

		String s = "BCCED";

		test(1, matrix, s, true);

	}

	public static void test2() {
		String[][] matrix =  new String[][] {
			{"A", "B", "C", "E"  },
			{"S", "F", "C", "S" },
			{ "A", "D", "E", "E" }
		};

		String s = "ABCB";

		test(2, matrix, s, false);

	}

	public static void test3() {
		String[][] matrix =  new String[][] {
			{"A", "B", "C", "E"  },
			{"S", "F", "C", "S" },
			{ "A", "D", "E", "E" }
		};

		String s = "ADFBA";

		test(3, matrix, s, true);

	}


}


class Coordinate {
	int x ;
	int y;
	//boolean visited;

	public Coordinate( int row, int col ) {
		x = row;
		y = col;
		//visited = false;

	}

}

