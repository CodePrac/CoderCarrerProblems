/*
Nodes in a list represent a number. For example, the nodes in Figure 1 (a) and (b) represent numbers 123 and 4567 
respectively. Please implement a function/method to add numbers in two lists, and store the sum into a new list.

*/


public class pb40 {

	public static LinkedList<Integer> getSum( LinkedList<Integer> a, LinkedList<Integer>b  ) {
		// we neet to reverse the linkedlists in order to add 
		a.reverseList();
		b.reverseList();
		LinkedList<Integer> sum = new LinkedList<Integer>();
		Node<Integer> aNode = a.getRoot();
		Node<Integer> bNode = b.getRoot();
		if ( aNode == null && bNode == null ) {
			// both lists are empty;
			sum.insert(new Node<Integer>(0));
			return sum;
		}
		int carry = 0;
		String temp ="";
		while ( aNode != null || bNode != null ) {
			int aData = ( aNode != null ) ? aNode.getData() : 0;
			int bData = ( bNode != null ) ? bNode.getData() : 0;

			int s = aData + bData + carry;
			carry = (int) s/ 10; 
			int d = s % 10;
			temp = d+temp;
			sum.insert(new Node<Integer>(d));

			aNode = ( aNode != null ) ? aNode.getNext() : aNode;
			bNode =  (bNode != null ) ? bNode.getNext() : bNode;
		}

		// see if there is any carry
		if ( carry > 0 ) {
			sum.insert(new Node<Integer>(carry));
			temp = carry+temp;
		}

		// now reverse the sum list
		sum.reverseList();
		return sum;	
	}



	public static Integer getSumInt( LinkedList<Integer> a, LinkedList<Integer>b  ) {
		// we neet to reverse the linkedlists in order to add 
		a.reverseList();
		b.reverseList();
		LinkedList<Integer> sum = new LinkedList<Integer>();
		Node<Integer> aNode = a.getRoot();
		Node<Integer> bNode = b.getRoot();
		if ( aNode == null && bNode == null ) {
			// both lists are empty;
			sum.insert(new Node<Integer>(0));
			return 0;
		}
		int carry = 0;
		String temp ="";
		while ( aNode != null || bNode != null ) {
			int aData = ( aNode != null ) ? aNode.getData() : 0;
			int bData = ( bNode != null ) ? bNode.getData() : 0;

			int s = aData + bData + carry;
			carry = (int) s/ 10; 
			int d = s % 10;
			temp = d+temp;
			sum.insert(new Node<Integer>(d));

			aNode = ( aNode != null ) ? aNode.getNext() : aNode;
			bNode =  (bNode != null ) ? bNode.getNext() : bNode;
		}

		// see if there is any carry
		if ( carry > 0 ) {
			sum.insert(new Node<Integer>(carry));
			temp = carry+temp;
		}

		// now reverse the sum list
		sum.reverseList();
		return Integer.valueOf(temp);	
	}


	public static void main( String[] args) {
		test1();
	}


	public static void test( int testNum, LinkedList<Integer> a, LinkedList<Integer> b, 
			LinkedList<Integer> expected) {
		
		// 
		//LinkedList<Integer> observed = getSum(a, b);
		Integer o = getSumInt(a,b);
		Integer e = 4690; 
		if ( o.equals(e) ) {
			System.out.printf("Passed Test %d \n", testNum );
		}
		else {
			System.out.printf("Failed Test %d - %s - %s\n", testNum , o, e);
		}

	}

	// test cases 
	public static void test1() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		a.insert( new Node<Integer>( 1));
		a.insert( new Node<Integer>(2));
		a.insert( new Node<Integer>(3));
		b.insert( new Node<Integer>(4));
		b.insert( new Node<Integer>(5));
		b.insert( new Node<Integer>(6));
		b.insert( new Node<Integer>(7));

		LinkedList<Integer> e = new LinkedList<Integer>();
		e.insert(new Node<Integer>(4));
		e.insert(new Node<Integer>(6));
		e.insert(new Node<Integer>(9));
		e.insert(new Node<Integer>(0));
		
		test( 1, a, b , e);
	}

}

class LinkedList< T > {
	private Node<T> root;
	private int length;

	public LinkedList() {
		this.root = null;
	}
	public LinkedList( Node<T> r ) {
		this.root = r;
		length = 1;
	}

	public Node<T> getRoot() {
		return this.root;
	}

	public int getLength() {
		return this.length;
	}

	

	public void insert( Node<T> n ) {
		if ( root == null ) {
			root = n;

		}
		else {
			Node<T> t = this.root;
			while( t.getNext() != null ) {
				t = t.getNext();
			}
			t.setNext(n);
		}

	}


	public void reverseList( ) {
		this.printList();
		Node<T> current = this.root;
		Node<T> previous = null;
		Node<T> next = null;
		while ( current != null ) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;

		}

		// the last node is the root node
		this.root = previous;
		this.printList();
	}

	public void printList() {
		Node<T> current = this.root;

		while ( current != null ) {
			System.out.print(" --> "+ current.getData()); 
			current = current.getNext();
		}
		System.out.println("------------------");
	}


/*
	@overide
	public boolean equals( Object o ) {
		if ( !( o instanceOf LinkedList<?> ) ){
			 if (((SingularNode<?>)other).value.equals(value)){
            return true;
        }
			if ((( LinkedList<?> o ).value.equals(value )))
			return false;
		}
		if ( o == this ) {
			return true;
		}

		// check each element 
		boolean notEqual = false;
		LinkedList<T> l = (LinkedList<T>) o;
		Node<T> lNode = l.getRoot();
		Node<T> rNode = this.root;

		if ( lNode == null && rNode == null ) {
			return true;
		}
		else if ( (lNode == null ) ^ ( rNode == null ) ) {
			return false;
		}

		while ( !notEqual && lNode != null  ) {
			if ( lNode.getData().equals( rNode.getData() ) ){
				lNode = lNode.getNext();
				rNode = rNode.getNext();

				if ( (rNode == null && lNode != null )  || ( lNode == null && rNode != null ) ) {
					notEqual = true;
				}
			}
			else {
				notEqual = true;
			}
		}

		return !notEqual;

	}

	@overide
	public int hashCode( ) {
			HashCodeBuilder hb = new HashCodeBuilder(17,37);
			Node<T> n = this.root;
			while( n != null ){
				hb.append( n.getData());
				n = n.getNext();
			}

			return hb.hashCode();

	}
	*/

}


class Node <T> {

	private T data;
	private Node<T> next;

	public Node( T data ) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return this.data;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setNext( Node<T> n ) {
		this.next = n;
	}

}