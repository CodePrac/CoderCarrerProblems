/*
Please implement a function which gets area of a set of rectangles, 
whose edges are parallel to X-axis or Y-axis.

Rectangles are defined as the following:
 === Assumming: left <= right; top <= bottom === 
struct Rect
{
    int left;
    int right;
    int top;
    int bottom;

    }

 Solution - Since the edges are parallel to x or y axis, they intersection forms a rectangle. 
 Merge rectangles and split them into smaller rectangles based on x or y axis. calculate area for each of these
 rectangles


  */

import java.util.*;

 public class pb27 {

 	public static double getArea( Set<Rect> recs ) {
 		// lets get all the x coordinates
 		TreeSet<Integer> xCords = new TreeSet<Integer>();
 		for ( Rect r : recs ) {
 			xCords.add( r.left);
 			xCords.add( r.right);
 		}

 		double totalArea = 0.0;
 		// lets get the y coordinates for each pair of x coordinated
 		while( xCords.size() > 1) {
 			// remove left most coordinate
 			int x1 = xCords.pollFirst();
 			// look at the next one without removing
 			int x2 = xCords.first();

 			int[] ycords = findYCords( x1, x2 , recs );
 			System.out.printf( "x1 - %d, X2 - %d, Y1 - %d, Y2 - %d \n", x1, x2, ycords[0], ycords[1]);
 			double area = ( x2- x1 ) * ( ycords[1 ] -ycords[0]);

 			totalArea = totalArea + area;

 		}
 		return totalArea;

 	} 

 	public static int[] findYCords( int x1, int x2, Set<Rect>recs ) {
 	
 		int yMin = Integer.MAX_VALUE;
 		int yMax = Integer.MIN_VALUE;
 		for ( Rect r : recs ) {
 			if ( r.left <= x1 && r.right > x1 ) {
 				if ( r.bottom < yMin) {
 					yMin = r.bottom;
 				}
 				if ( r.top > yMax ) {
 					yMax = r.top;
 				}
 				
 			}
 		}
 		return new int[] { yMin, yMax };
 	}

 	public static void main( String[] args ) {
 		test1();
 	}

 	public static void test( int testNum, Set<Rect> recs, double expected) {
 		double observed = getArea( recs );
 		if ( observed == expected ) {
 			System.out.printf( "Test %d succeded \n",testNum);
 		}
 		else {
 			System.out.printf( "Test %d failed. Expected - %f , observed - %f \n", testNum, expected, observed);
 		}
 	}

 	public static void test1 () {
 		Rect a = new Rect( 0, 10, 0, 10);
 		Rect b = new Rect( 5, 20, 5, 20 );
 		Rect c = new Rect( 8, 30, 8, 30 );
 		Set<Rect> s = new HashSet<Rect>();
 		s.add(a);
 		s.add(b);
 		s.add(c);

 		double expected = 640; 
 		test( 1, s, expected );
 	}


 }

 class Rect {
 	 int left; // x coordinates
 	 int right; // x coordinates
 	 int top;
 	 int bottom;

 	 public Rect( int l, int r, int b, int t) {
 	 	left = l;
 	 	right = r;
 	 	top = t;
 	 	bottom = b;
 	 }
 }