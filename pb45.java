/*
Given a binary search tree and a value k, 
please find a node in the binary search tree whose value is closest to k. 
*/



public class pb45 {



	public static int findClosestValue( BinarySearchTree<Integer> t, int k ) {
		// if binary search tree is empty return
		int res = -1;
		if ( t.getRoot() == null ) {
			return res;
		}

		BinaryNode<Integer> node = t.getRoot();
		int diff = Integer.MAX_VALUE;
		while ( node != null ) {
			// if node value equals then thats the closest node
			if ( node.getData() == k ) {
				return k;
			}
			else {
				if ( Math.abs( node.getData() - k ) < diff ) {
					res = node.getData();
					diff = Math.abs( node.getData() - k );
				}
				// now lets move to next node
				if ( node.getData() > k ) {
					// we need to move left;
					node = node.getLeft();
				}
				else {
					node = node.getRight();
				}

			}
		}

		return res;
	}

	public static void main( String args[]) {
		test1();
		test2();
	}



	public static void test( BinarySearchTree<Integer> t, int k , int expected  ) {
		int closest = findClosestValue( t, k );
		if ( expected == closest ) {
			System.out.println( "Sucess for test with value "+k);	
		}
		else {
			System.out.println( "Test failed for value "+k);
		}
	}


	// Test cases
	public static void test1() {
		int k = 10;
		BinaryNode<Integer> root = null;
		BinarySearchTree< Integer> t = new BinarySearchTree<Integer>();
		test( t, k , -1);
	}

	public static void test2() {
		BinarySearchTree< Integer> t = new BinarySearchTree<Integer>();
		int[] d = { 32, 24, 41, 21, 28,	36, 47, 14, 26, 34, 39};
		for (int i : d ) {
			t.insert( new BinaryNode<Integer>(i));
		}

		test( t, 27 , 28);
	}

}

class BinarySearchTree<T extends Comparable<T>> {
	private BinaryNode<T> root;
	public BinarySearchTree( BinaryNode<T> n ) {
		root = n;
	}

	public BinarySearchTree() {
		root = null;
	}
	public void insert( BinaryNode<T> n ) {
		if ( this.root == null ) {
			this.root = n;
			return;
		}
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