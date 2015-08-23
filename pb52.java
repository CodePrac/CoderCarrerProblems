/*
Given a rope with length n, how to cut the rope into m parts with length n[0], n[1], ..., n[m-1], 
in order to get the maximal product of n[0]*n[1]* ... *n[m-1]? We have to cut once at least. 
Additionally, the length of the whole length of the rope, as well as the length of each part, are in integer value.

*/

class pb52 {

	public static void main( String[] args) {
		int lengthOfTheRope = 8;

		double maxProd = dynamicPgSol(lengthOfTheRope);
		System.out.println("Max prod - "+ maxProd);
		maxProd = shortSol(lengthOfTheRope);
		System.out.println("Max prod - "+ maxProd);
	}


	public static double dynamicPgSol( int lengthOfTheRope ) {

		if ( lengthOfTheRope < 2 ) {
			return 0;
		}
		if ( lengthOfTheRope == 2 ) {
			return 2;
		}
		if ( lengthOfTheRope == 3 ) {
			return 2;
		}

		double[] prod = new double[lengthOfTheRope+1];

		// initial values for starting the iteration
		prod[0] = 1;
		prod[1] = 1;
		prod[2] = 2;
		prod[3] = 3;

		// find all the solutions till the length of the rope
		for ( int i = 4 ; i<= lengthOfTheRope; i++ ) {
			prod[i] = 0;
			for ( int j = 2; j<= (int) i /2 ; j++ ) {
				double t = prod[j] * prod[( i-j)];
				if ( t > prod[i] ) {
					prod[i] = t;
				}
			}

		}

		return prod[lengthOfTheRope];
	} 


	// Tricky solution with O(n)
	/*
		Idea here is that the max prod we can get for any length of the rope is to cut it with as many 3's and then 2's 
		as possible. Avoid cutting of length 1.  3(n-3) >=n  for n>=5
 	*/
	public static double shortSol( int lengthOfTheRope) {

		if ( lengthOfTheRope < 2 ) {
			return 0;
		}

		if ( lengthOfTheRope == 2 ) {
			return 1;
		}
		if ( lengthOfTheRope == 3 ) {
			return 2;
		}

		// first lets divide by num of 3
		int max3pow = (int) lengthOfTheRope / 3;
		// in case of 4 we want to avoid 3 and 1 so 
		if ( (lengthOfTheRope -  3* max3pow ) % 2 == 1 ) {
			max3pow --;
		}
		// now lets get num of 2's
		int max2Pow = (int) ( lengthOfTheRope - 3* max3pow) / 2;

		return ( Math.pow(3, max3pow) * Math.pow(2, max2Pow));
		

	}




}