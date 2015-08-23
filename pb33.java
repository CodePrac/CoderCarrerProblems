/*
Given an array of numbers and a sliding window size, how to get the maximal numbers in all sliding windows?

For example, if the input array is {2, 3, 4, 2, 6, 2, 5, 1} and the size of sliding windows is 3,
 the output of maximums are {4, 4, 6, 6, 6, 5}, as illustrated in Table1.


 Tricky Problem 

 - Easy Solution is just scanning - O( nk ) complexity
 - We can use heap of size sliding window - O(nlogn ) <-- Heapify of sorted array - 
 average O(n logk) - k is window size
 - Optimized Solution - using double ended queue or linkedlist
*/

 import java.util.*;

public class pb33 {


	public static List<Integer> getMaxInWindow( int[] numbers , int window) {
		// lets get a queue double sided
		LinkedList<Integer> q = new LinkedList<Integer>();
		List<Integer> maxInWindow = new ArrayList<Integer>();

		// lets do this for first element
		for ( int i=0; i<window; i++ ) {
			// we are comparing against the last element in the queue
			while ( !q.isEmpty() && numbers[i] >= numbers[ q.getLast() ]) {
				q.removeLast();
			}
			q.offerLast( i);

		}


		for ( int i = window; i < numbers.length; i++ ) {
			maxInWindow.add( i- window, numbers[ q.getFirst() ] );

			// Remove every element from the back that was smaller
			while ( !q.isEmpty() && numbers[i] >= numbers[ q.getLast() ] ) {
				q.removeLast();
			}
			// check if the first element qualifies
			while ( !q.isEmpty() && q.getFirst() <= ( i - window  ) )  {
				// this number is before the sliding window
				q.removeFirst();
			}

			q.offerLast(i);

		}
		// add for the last window element
		maxInWindow.add( numbers.length - window, numbers[ q.getFirst() ] );
		for ( int i : maxInWindow ) {
			System.out.printf(" %d", i);
		}
		System.out.println("");
		return maxInWindow;
	}

	public static void main(String[] args ) {
		test1();

	}	

	public static void test( int testNum, int[] numbers,int window, List<Integer> expected) {
		List<Integer> observed = getMaxInWindow( numbers, window);

		if ( expected.equals( observed ) ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . \n", testNum );
		}
	}

	public static void test1() {
		int[] nums = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
		List<Integer> expected = new ArrayList<Integer>();
		expected.add( 4);
		expected.add( 4);
		expected.add( 6);
		expected.add( 6);
		expected.add( 6);
		expected.add( 5);
		test( 1, nums, 3, expected);

			
	}

}
