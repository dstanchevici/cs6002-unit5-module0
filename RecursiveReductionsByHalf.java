
public class RecursiveReductionsByHalf {

    public static void main (String[] argv) 
    {
	int N = 15;
	int k = reductions (N, 0);
	System.out.println ("N=" + N + " k=" + k);
	
	N = 31;
	k = reductions (N, 0);
	System.out.println ("N=" + N + " k=" + k);

	N = 63;
	k = reductions (N, 0);
	System.out.println ("N=" + N + " k=" + k);
	
    }

    static int reductions (int n, int count)
    {
        if (n <= 0) return 1;
        count += reductions (n/2, 1);
        return count;
    }

}
