/*
Given a binary search tree, please check whether there are two nodes in it whose sum equals a given value.
*/
import java.util.*;

public class pb46 {

	public static void main( String[] args ) {
		BinaryNode<Integer> root = new BinaryNode<Integer>(32);
		BinarySearchTree< Integer> t = new BinarySearchTree<Integer>( root);

		//int[] d = { 24, 41, 21, 28,	36, 47, 14, 26, 34, 39};
		int[] d = { 12, 43 };
		for (int i : d ) {
			t.insert( new BinaryNode<Integer>(i));
		}

		int sum = 64;
		Integer[] res = findSum(t , sum);
		if ( res != null  ) {
			System.out.println ( "Found Sum - "+res[0]+" + "+ res[1]+ " = " + sum);
		}
		else {
			System.out.println ( "Sum not found in tree");
		}
	}


	public static Integer[] findSum( BinarySearchTree<Integer> t, int sum) {
		Integer[] res = null;
		// lets find the min and the max nodes
		// we would need to store the parents in order to navigate up
		Stack<BinaryNode<Integer>> leftStack = new Stack<BinaryNode<Integer>>();
		Stack<BinaryNode<Integer>> rightStack = new Stack<BinaryNode<Integer>>();
		BinaryNode<Integer> p1 = null ;
		BinaryNode<Integer> p2 = null;

		
		if ( t.getRoot() == null ) {
			throw new IllegalArgumentException();
		}

		BinaryNode<Integer> node = t.getRoot();
		// lets get the min element
		while( node.getLeft() != null ) {
			leftStack.push(node);
			node = node.getLeft();
		}
		// min node
		p1 = node;

		// added root node to left stack
		node = t.getRoot();

		while ( node.getRight() != null ) {
			rightStack.push(node);
			node = node.getRight();
		}
		p2 = node;

		boolean found = false;
		while ( ( p1 != null && p2 != null && p1 != p2 ) && !found ) {
			if ( p1.getData() + p2.getData() == sum ) {

				res = new Integer[2];  ;
				res[0]= p1.getData();
				res[1] = p2.getData();
				found = true;
			}
			else if ( ( p1.getData() + p2.getData() ) > sum ) {
				// we need to reduce the value of p2
				p2 = getPreviousRightNode(rightStack );

			}
			else {
				p1 = getPreviousLeftNode( leftStack );
			}

		}

		return res;

	}

	// get left previous node
	public static BinaryNode<Integer> getPreviousLeftNode( Stack<BinaryNode<Integer>> s ) {

		
		if ( s.empty() ) {
			return null;
		}

		BinaryNode<Integer> n = s.pop();
		if ( n.getRight() != null ) {
			BinaryNode<Integer> rNode  = n.getRight();
			s.push( rNode);
			pushLeftSubTree(s, rNode);
		}
		return n;
	}


	// get Right previous Node
	public static BinaryNode<Integer> getPreviousRightNode(Stack<BinaryNode<Integer>> s) {
		
		if ( s.empty()) {
			return null;
		}
		BinaryNode<Integer> n = s.pop();
		if ( n.getLeft() != null ) {
			// push it on the stack
			BinaryNode<Integer> leftNode  = n.getLeft();
			s.push( leftNode);
			// push its right subtree in the stack
			pushRightSubTree( s, leftNode);
			
		}
		return n;
	}



	public static void pushLeftSubTree( Stack<BinaryNode<Integer>> s, BinaryNode<Integer> r ) {
		while ( r.getLeft() != null ) {
			s.push( r.getLeft());
			r = r.getLeft();
		}
	}

	public static void pushRightSubTree(Stack<BinaryNode<Integer>> s, BinaryNode<Integer> r ) {
		while ( r.getRight() != null ) {
			s.push( r.getRight());
			r = r.getRight();
		}
	}

}


class BinarySearchTree<T extends Comparable<T>> {
	private BinaryNode<T> root;
	public BinarySearchTree( BinaryNode<T> n ) {
		root = n;
	}

	public void insert( BinaryNode<T> n ) {
		boolean flag = false;
		BinaryNode<T> start = root;
		while( !flag ) {
			if ( n.getData().compareTo( start.getData()) > 0 ) {
				if ( start.getRight() != null ) {
					start = start.getRight();
				}
				else {
					start.setRight(n);
					flag = true;
				}
			}
			else {
				if ( start.getLeft() != null ) {
					start = start.getLeft();
				}
				else {
					start.setLeft(n);
					flag = true;
				}
			}

		}
	}


	public BinaryNode<T> getRoot() {
		return this.root;
	}

}

class BinaryNode<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode( T d ) {
		data = d;
		left = null;
		right = null;
	}



	public BinaryNode<T> getLeft() {
		return this.left;
	}

	public BinaryNode<T> getRight() {
		return this.right;
	}

	public T getData() {
		return this.data;
	}

	public void setLeft( BinaryNode<T> l) {
		this.left = l;
	}

	public void setRight( BinaryNode<T> r) {
		this.right = r;
	}

}