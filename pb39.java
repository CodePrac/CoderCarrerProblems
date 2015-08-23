/*
How can you implement two stacks in a single array, where no stack overflows 
until no space left in the entire array space?


*/

public class  pb39 {



	public static void main(String[] args ) {
		TwoStackArray ts = new TwoStackArray(4);
		ts.push(1, 10);
		ts.push(2, 5);
		ts.push( 1, 8);
		ts.push( 1, 6);
		System.out.printf( "Stack %d pop - %d", 1, ts.pop(1) );
		ts.push(2,7);
		//System.out.printf( "Stack %d pop - %d", 2, ts.pop(2) );
		ts.push(2,9);

	}

}


class TwoStackArray {

	private int[] stackData; 
	private int[] stackTop;


	public TwoStackArray( int length ) {
		stackData = new int[length];
		stackTop = new int[  ]{ -1, length};
		
	}


	public void push( int stack, int data ) {
		if ( stackTop[1] - stackTop[0 ] > 1 ) {
			// stack has space
			if ( stack == 1 ) {
				stackTop[0]++;
				stackData[stackTop[0]] = data;
			}
			else if  ( stack == 2 ) {
				stackTop[1]--;
				stackData[stackTop[1]] = data;
			}
		
		}
		else {
			throw new RuntimeException("No more space in the stack");
		}
	}

	public int pop( int stack ) {
		int data = 0 ;
		if ( stack == 1 && stackTop[0] >= 0  ) {
				data = stackData[stackTop[0]];
				stackTop[0]--;
			
		}
		else if ( stack == 2 && stackTop[1] < stackData.length ) {
			data = stackData[ stackTop[1]];
			stackTop[1]++;
		}
		else {
			throw new RuntimeException("No data in stack");
		} 

		return data;

	}





}