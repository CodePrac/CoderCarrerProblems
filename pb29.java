/*
How to check whether there is a loop in a linked list? For example, the list in Figure 1 has a loop.

If there is a loop in a linked list, how to get the entry node of the loop? 
The entry node is the first node in the loop from head of list. 
For instance, the entry node of loop in the list of Figure 1 is the node with value 3.

Solution - If there is a loop we use two pointers and move them forward with 1 node and 2 nodes
at each step. If the pointers meet we have a loop . 
*/


public class pb29 {

	public static boolean hasLoop( MyLinkedList<T> l ) {
		if ( l.head == null ) {
			return false;
		}
		Node<T> slowPtr = l.head;
		fastPtr = l.head;
		boolean isLoop = false;
		while ( !isLoop && slowPtr != null && fastPtr !=null ) {
			// increment slow ptr to next
			slowPtr = slowPtr.getNext();
			// move it two steps;
			// this could casuse null pointer exception
			if ( fastPtr.getNext() != null ) {
				fastPtr = fastPtr.getNext().getNext();
			}
			else {
				fastPtr = null;
			}

			if ( fastPtr.equals( slowPtr ) ) {
				isLoop = true;
			}
		}

		return isLoop;	

	}


	public static Node<T> getStartOfLoop( MyLinkedList<T> l ) {
		Node<T> slowPtr = l.head;
		fastPtr = l.head;
		boolean isLoop = false;
		while ( !isLoop && slowPtr != null && fastPtr !=null ) {
			// increment slow ptr to next
			slowPtr = slowPtr.getNext();
			// move it two steps;
			// this could casuse null pointer exception
			if ( fastPtr.getNext() != null ) {
				fastPtr = fastPtr.getNext().getNext();
			}
			else {
				fastPtr = null;
			}

			if ( fastPtr.equals( slowPtr ) ) {
				isLoop = true;
			}
		}

		/*
		now we know that it took slowPtr k steps to meet the fastPTr
		now we move slow PTR to start position and advance both ptrs one 
		step each. When they meet would be start of the loop.

		Another way i
		1 . count number of nodes in the circle - > n
		2. move ptr 1 by n steps
		3. move pt2 to head and move pt1 and pt2 together one step
		4. when they meet we are at the head of the loop
		

		*/

		slowPtr = l.head;
		while ( ! slowPtr.equals( fastPtr )) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPt.getNext();
		}

		return slowPtr;

	}



}

class MyLinkedList<T> {
	Node<T> head; 
	public MyLinkedList( ) {
		this.head = null;
	}

	public void insertNode( Node<T> n ) {
		if ( this.head == null ) {
			head = n;
			return;
		}
		ptr = head;
		while ( ptr.getNext() != null ) {
			ptr = ptr.getNext();
		}
		ptr.setNext(n);
	}


}