/*

 How to get the median from a stream of numbers at any time? The median is middle value of numbers.
 If the count of numbers is even, the median is defined as the average value of the two numbers in middle


Solution - We use two heaps - one max heap to store all the elments in the left side 
and min heap to store all the on the right side . The size of heap is same or differ by one. 
 Median would be top element of heap with more numbers or avg of the max and min 
 */

import java.util.*;

 public class pb30 {





 	public static int getMedian( int[] numbers) {
 		// initialize two heaps
 		Comparator<Integer> maxComparator = new Comparator<Integer>() {
 			public int compare( Integer a, Integer b ) {
 				if ( b > a ) {
 					return 1;
 				}
 				else if ( b < a ) {
 					return -1;
 				}
 				else {
 					return 0;
 				}
 			// or return b-a
 			}
 		};

 		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( maxComparator );
 		// default comparator
 		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();


 		for  ( int num : numbers  ) {
 			// add to heaps
 			addToHeaps( maxHeap, minHeap, num);

 		}
 		
 		return median( maxHeap, minHeap);

 	}


 	public static Integer median( PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap ) {
 		if ( maxHeap.size() > minHeap.size()  ) {
 			// median is top of maxHeap
 			return maxHeap.peek();
 		}
 		else if ( minHeap.size() > maxHeap.size() ) {
 			return minHeap.peek();
 		} 
 		else {
 			// if they are of equal length then its average of middle elements
 			return ( maxHeap.peek() + minHeap.peek() ) / 2;
 		}

 		
 	}

 	public static void addToHeaps( PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num ) {
 		if ( maxHeap.size() == 0 || minHeap.size() == 0 ) {
 			// first number
 			maxHeap.offer(num);
 		}
 		else {
 			if ( num < maxHeap.peek()  ) {
 				// number is on left side
 				maxHeap.offer(num);
 			}
 			else {
 				// number is on right side
 				minHeap.offer(num);
 			}
 		}
 		balanceHeaps( maxHeap, minHeap);

 	}


 	public static void balanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap ) {
 		if ( Math.abs( maxHeap.size() - minHeap.size() ) <= 1  ) {
 			// heaps are balanced
 			return;
 		} 
 		else {
 			if ( maxHeap.size() > minHeap.size() ) {
 				minHeap.offer( maxHeap.poll() );
 			}
 			else {
 				maxHeap.offer( minHeap.poll() );
 			}
 		}
 	}

 	public static void main(String[] args ) {
		test1();
		test2();
		test3();
	}	

	public static void test( int testNum, int[] numbers, int  expected) {
		int observed = getMedian( numbers);
		if ( expected == observed )  {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d . \n", testNum );
		}
	}


 	public static void test1() {
 		int[] sequence = new int[] { 4, 3, 5}; 
 		int expected = 4;
 		test(1, sequence, expected);
 	}


 	public static void test2() {
 		int[] sequence = new int[] { 4, 3, 5, 2}; 
 		int expected =  7 /2 ;
 		test(2, sequence, expected);
 	}

 	public static void test3() {
 		int[] sequence = new int[]{ 12, 8, 6, 5, 5, 14}; 
 		int expected =  7 ;
 		test(1, sequence, expected);
 	}



 }



/*
class MaxHeap  {
	List<Integer> heap; 


	public MaxHeap() {
		this.heap = new ArrayList<Integer>();
	}


	public void insert(int n ) {

		heap.add( n);
		if ( heap.size() > 1 ) {
			heapifyUp( heap.size() - 1 );
		}

	}

	public void heapifyUp( int pos ) {
		// check the node against parents node - 
		int parentPos =  (pos -1 ) / 2;
		// switch if parent is smaller 
		if ( heap[pos] > heap[ parentPos] ) {
			int temp = heap[pos];
			heap[pos] = heap[parentPos];
			heap[parentPos ] = temp;
			heapifyUp( parentPos);
		}   
	}

	// removes and returns first element
	public int remove() {
		if ( heap.size() == 0 ) {
			throw new RuntimeException( "Removing from empty heap");
		}
		int val = heap.get(0);

		if ( heap.size() == 1 ) {
			heap.remove(0);
			return val;
		}

		int val = heap.get(0);
		// get the last element and place it on the top
		int temp = heap.get( heap.size() - 1) ;
		heap.remove( heap.size() - 1 );
		heap.add(0, temp );
		heapifyDown( 0);

	}


	public void heapifyDown( int pos) {
		// compare element with its children 
		int lchild = 2 * pos + 1;
		int rchild = 2 * pos + 2;
		int temp = heap[pos];
		if ( rchild < heap.size()  && rchild < heap.size() ) {
			if (  heap[ pos ]  < heap[ lchild ] || heap[pos] < heap[rchild] ) {
				
				// left is max
				if (  heap[ pos ]  < heap[ lchild ] && heap[lchild]  > heap[rchild ]) {
					heap[pos] = heap[lchild];
					heap[lchild] = temp;
					heapifyDown( lchild);
				}
				else {
					heap[pos] = heap[rchild];
					heap[rchild] = temp;
					heapifyDown( rchild);
				}
 			}
 		}
 		else if ( lchild < heap.size() && heap[ lchild ] > heap[ pos ] ) {
 			heap[pos] = heap[lchild];
			heap[lchild] = temp;
			heapifyDown( lchild);
 		}

	}


 }

 */