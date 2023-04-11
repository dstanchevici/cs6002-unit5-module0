
public class ReductionsByHalf {

    public static void main (String[] argv) 
    {
	int N = 15;
	int k = reductions (N);
	System.out.println ("N=" + N + " k=" + k);

	N = 31;
	k = reductions (N);
	System.out.println ("N=" + N + " k=" + k);

	N = 63;
	k = reductions (N);
	System.out.println ("N=" + N + " k=" + k);
	
    }

    static int reductions (int n)
    {
	int count = 0;

	while (n > 0) {
	    n /= 2;
	    count ++;
	}

	return count;
    }

}
