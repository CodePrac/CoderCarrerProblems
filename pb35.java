/*
 How do you get the depth of a binary tree? Nodes from the root to a leaf form a path. 
 Depth of a binary tree is the maximum length of all paths. 
 For example, the depth of the binary tree in Figure 1 is 4, 
 with the longest path through nodes 1, 2, 5, and 7.

How do you verify whether a binary tree is balanced? 
If the depth difference between a left subtree and right subtree of any node in a 
binary tree is not greater than 1, it is balanced. 
 

 */


class pb35 {

	public static int depthOfBinaryTree( Node<T> root ) {
		if ( root == null ) {
			return 0;
		}
		int lHeight = 0;
		int rHeight = 0;
		if ( root.getLeft() != null ) {
			// get height of left subtree
			lHeight =  depthOfBinaryTree( root.getLeft());
		}

		if ( root.getRight() != null ) {
			rHeight = depthOfBinaryTree( root.getRight());
		}

		return Math.max( lHeight, rHeight) + 1;


	}



	public static int checkHeightBalance( Node<T> node ) {
		if ( node == null ) {
			return 0;
		}
		int lHeight =  checkHeightBalance( node.getLeft());
		int rHeight = checkHeightBalance( node.getRight());

		if ( lHeight == -1  || rHeight == -1 ) {
			// subtree is unbalanced
			return -1 ;
		}
		
		if ( Math.abs( lHeight - rHeight) > 1 ) {
			return -1 ;
		}
		else {
			return Math.max( lHeight, rHeight ) + 1;
		}


	}

	// CHECK THIS ONE 

	public static bool isBalanced( Node<T> root  ) {
		if ( root == null ) {
			int depth = 0;
			return true;
		}
		int h = checkHeightBalance( root);

		if ( h == -1 ) {
			return false;
		}
		else {
			return true;
		}

	}

}