
public class Remainder {

    public static void main (String[] argv)
    {
	int[] A = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	int K = 11;

        for (int i=0; i<A.length; i++) {
	    System.out.println (A[i] + " % 11 = " + (A[i] % K) );
	}

    }

}
