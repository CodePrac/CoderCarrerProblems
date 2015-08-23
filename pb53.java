/*
 Given an array, please get the length of the longest arithmetic sequence. 
 The element order in the arithmetic sequence should be same as the element order in the array.
 For example, in the array {1, 6, 3, 5, 9, 7}, the longest arithmetic sequence is 1, 3, 5, and 7, 
 whose elements have same order as they are in the array, and the length is 4.

 Every pair of two adjacent numbers in an arithmetic sequence has exactly same difference. 
 For example, 1, 3, 5, and 7 is an arithmetic sequence, and the pairs (1, 3), (3, 5), and (5, 7) 
 have the same difference 2.
 */
import java.util.*;

 public class pb53 {

 	public static void main(String[] args) {
		
		int[] numbers = {1, 6, 3, 5, 9, 7 };
		// calculate all possible distance pairs
		Arrays.sort(numbers);
		Map<Integer, List<Pair>> distPairMap = calculateDistances(numbers); 
		Integer longestSequence = getLongestSequence(distPairMap, numbers.length);
		System.out.println( "Longest Sequence - "+ longestSequence);

 	}

 	public static Map<Integer,List<Pair>> calculateDistances( int[] numbers ) {
 		Map<Integer, List<Pair>> distMap = new HashMap<Integer, List<Pair>>();

 		// calculate distance between every pair
 		for ( int i = 0 ; i< numbers.length; i++ ) {
 			for ( int j = i+1; j < numbers.length; j++) {
 				int dist = numbers[j] - numbers[i];
 				Pair d = new Pair( i, j);
 				// check if distance is present in the hash
 				if( distMap.containsKey( dist)) {
 					distMap.get(dist).add(d);
 				}
 				else {
 					List<Pair> pairs = new ArrayList<Pair>();
 					pairs.add(d);
 					distMap.put(dist, pairs);
 				}
 			}
 		}

 		return distMap;
 	}

 	// returns longest sequence
 	public static Integer getLongestSequence( Map<Integer, List<Pair>> distPairs, int len) {
 		int maxLength  = 0;
 		int[] seqLen = new int[len];

 		for ( Integer k : distPairs.keySet() ) {
 			List<Pair> seq = distPairs.get(k);

 			//every element has seq of 1 
 			for ( int i = 0 ; i< seqLen.length; i++  ) {
 				seqLen[i] = 1;
 			}

 			// ( 1, 3) ( 3,5 )
 			// seqLen[3] = 2 & seqLen[5] = 3
 			for ( Pair p : seq  ) {
 				seqLen[p.second] = seqLen[p.first] + 1;
 			}

 			for ( int i : seqLen ) {
 				if ( i > maxLength) {
 					maxLength = i;
 				}
 			}
 		}

 		return maxLength;
 	}


 }

 class Pair {

 	Integer first;
 	Integer second;

 	public Pair( Integer f, Integer s ) {
 		first = f;
 		second = s;

 	}

 	public Integer getDistance() {
 		return ( this.second - this.first );
 	}


 }