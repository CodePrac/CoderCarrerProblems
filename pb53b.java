/*
Given an array, please get the length of the longest consecutive sequence. 
A consecutive sequence is an arithmetic sequence with common difference 1. 
The element order in the consecutive sequence is not necessarily same as the element order in the array. 
The solution should not cost more than O(n) time and space if the length of the input array is n. 
For example, in the array {1, 6, 3, 5, 9, 7}, the longest consecutive sequence is 5, 6, and 7 whose length is 3.
*/

// possible nlogn solution would be to sort the elemnts and iterate over them
// we store the array into a hash map and then for each element look for its neighbours
import java.util.*;

public class pb53b {

	public static void main ( String[] args ){
		int[] numbers = {1, 6, 3, 5, 9, 7 };
		//int[] length = new int[numbers.length];

		

		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for ( int n : numbers ) {
			numMap.put(n, 1);
		}

		Iterator it = numMap.keySet().iterator();

		while ( it.hasNext() ) {
			int n = (Integer) it.next();
			int count = numMap.get(n);
			if ( numMap.containsKey(n+1) ) {
				count = count + numMap.get(n+1 );
			}
			if ( numMap.containsKey(n-1)) {
				count = count + numMap.get(n-1);
			}
			numMap.put(n, count );
		}

		int maxLength = 0 ;
		for ( Map.Entry<Integer, Integer> e : numMap.entrySet() ) {
			// we are looking for beginning of the sequence ,
			// middle of the sequence will have 2 neighbours - so value would be 3
			// this is the beginning of the sequence 
			int count = 1;
			int num = e.getKey();
			int v = e.getValue();
			if ( v == 2 ) {
				while ( numMap.containsKey( num + 1 ) ) {
					count ++ ;
					num++;
				}
			}

			if ( count > maxLength ) {
				maxLength = count;
			}
		}

		System.out.println("Max consecutive length - "+maxLength);

	}

}