/* Given an array of ranges, please merge the overlapping ones. 
For example, four ranges [5, 13], [27, 39], [8, 19], [31, 37] (in blue in  Figure1) are merged into two ranges, 
which are [5, 19] and [27, 39] 
*/
import java.util.Collections;
import java.util.*;

public class pb54 {


	public static void main ( String[] args ) {
		List<Range> n = new ArrayList<Range>();
		n.add( new Range(5, 13 ) );
		n.add(new Range( 27, 39) );
		n.add( new Range(8,19));
		n.add( new Range(31, 37));

		List<Range> mergedRanges = mergeRanges(n);

		for ( Range r : mergedRanges) {
			System.out.println(r.left+"----"+r.right);
		}
	}


	public static List<Range> mergeRanges( List<Range> n ) {
		List<Range> res = new ArrayList<Range>();
		// sort the ranges
		Collections.sort(n);

		for( Range i : n ) {
			System.out.println(i.left+"----"+i.right);
			// compare it across all the merged ranges
			merge( res, i );
		}
		return res;

	}

	private static void merge(List<Range>res, Range r ) {
		if ( res.size() == 0 ) {
			res.add(r);
			return;
		}

		Boolean merged = false;
		int i = 0;
		while ( i < res.size() ) {
			if ( r.left >= res.get(i).left && r.left <= res.get(i).right ) {
				// merge with new right
				int newRight = res.get(i).right;
				if ( r.right > res.get(i).right ) {
					newRight = r.right;
				}
				Range nr = new Range( res.get(i).left, newRight);
				res.set(i, nr);
				merged = true;

			}
			i++;
		}
		if ( !merged) {
			res.add(r);
		}	
		
	}

	

}	


class Range implements Comparable<Range> {
		int left;
		int right;

		public Range( int x, int y ) {
			left = x;
			right = y;
		}

		public int compareTo( Range a) {
			if ( this.left < a.left ) {
				return -1;
			}
			else if ( this.left > a.left ) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}