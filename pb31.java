/*

How to verify whether a binary tree is a binary search tree?

// second solution is with inorder traversal and checking the previous value is less then current value
*/

public class pb31 {

	public static boolean isBinarySearchTree( BinaryNode<Integer> root, max, min ) {
		// if a tree is binary search then the left elements are less then the root 
		// and right ones greater then root

		if  ( root == null ) {
			return true;
		}

		boolean left = false;
		boolean right = false; 
		if ( root.value < max && root.value > min ) {

			// lets check the left sub tree
			// max value would be roots value
			left = isBinarySearchTree( root.getLeft(), min, root.getData() );
			right = isBinarySearchTree( root.getRight(), root.getData(), max ); 

			return ( left && right	);		
		}

		else {
			return false;
		}



	}


	public static boolean checkIfBinarySearchTree( BinaryNode<Integer> root ) {

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		return isBinarySearchTree( root, max, min);
	}



}