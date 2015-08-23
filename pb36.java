/*
Please print all permutations of a given string. 
For example, print “abc”, “acb”, “bac”, “bca”, “cab”, and “cba” when given the input string “abc”.

*/
import java.util.*;
import java.lang.StringBuffer;

public class pb36 {


	public static List<String> findPermuations( String s ) {
		List<String> results = new ArrayList<String>();
		if ( s.length() < 1) {
			return null;
		}
		StringBuffer r = new StringBuffer("");
		StringBuffer remainingString = new StringBuffer( s);
		permute(  remainingString, r, results );
		System.out.printf( "Found permuations %d \n", results.size());
		return results;
	}

	public static void permute( StringBuffer remainingString, StringBuffer temp, List<String> results ) {
		if ( remainingString.length() == 0 ) {
			results.add(temp.toString());
			System.out.println(temp);

			return;
		}
		else {
			for ( int i = 0 ; i < remainingString.length(); i++ ) {
				char p = remainingString.charAt(i);
				temp = temp.append( p);
				StringBuffer nr = new StringBuffer( remainingString );
				nr.deleteCharAt(i);
				

				permute( nr , temp, results  );
				temp.deleteCharAt( temp.length() -1 );
			}
		}

	}


	

	public static void main( String[] args) {
		test1();
	
	}


	public static void test( int testNum, String s, List<String> expected ) {
		List<String> observed = findPermuations( s );
		if ( expected.equals( observed ) ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d ", testNum );
		}
	}
	public  static void test1() {
		String s = "abc";
		List<String> expected = new ArrayList<String>( );

		expected.add( "abc" );
		expected.add("acb" );
		expected.add("bac");
		expected.add( "bca" );
		expected.add( "cab" );
		expected.add( "cba" );
		test( 1, s , expected);

	}

	
}