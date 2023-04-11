import java.util.*;

public class RemainderGrouping {

    public static void main (String[] argv)
    {
	int[] A = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	int K = 11;

	LinkedList<Integer> elementsByRem;
	ArrayList<LinkedList<Integer>> remArray = new ArrayList<> ();
	
	for (int rem=0; rem<A.length; rem++) {
	    
	    elementsByRem = new LinkedList<> ();
	    
	    for (int i=0; i<A.length; i++) {
		if  (A[i] % K == rem) {
		    elementsByRem.add (A[i]);
		}
	    }

	    if ( ! elementsByRem.isEmpty() ) {
		remArray.add (elementsByRem);
	    }

	}

	int remainder = 0;
	for (LinkedList<Integer> list: remArray) {
	    System.out.print ("Elements with remainder " + remainder + ": ");
	    for (int item: list) {
		System.out.print (item + " ");
	    }
	    System.out.println ();
	    remainder ++;
	}
        	
    }

}
