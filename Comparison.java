import java.util.*;

public class Comparison {
   
    // Try different values of N: 10,000, 100,000 and 1,000,0000
    static int N = 1_000_000;

    // Comparison of list, tree, hashtable:
    static ArrayList<Integer> list = new ArrayList<>();
    static TreeSet<Integer> tree = new TreeSet<>();
    static HashSet<Integer> hashtable = new HashSet<>();


    public static void main (String[] argv)
    {
	// Put the numbers 0, 2, .. (even numbers) in each structure:
	for (int i=0; i<N; i+=2) {
	    list.add (i);
	    tree.add (i);
	    hashtable.add (i);
	}

	// Random numbers between 0 and N:
	int[] queries = makeRandomQueries (10000);
	// We'll use these queries to search in each data structure.

	// First, an array list:
        long startTime = System.currentTimeMillis();
        int count = findWithArrayList (queries);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using an array-list: count=" + count + "  timeTaken=" + timeTaken);

	// Next, a tree:
        startTime = System.currentTimeMillis();
        count = findWithTree (queries);
        timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a tree: count=" + count + "  timeTaken=" + timeTaken);

	// Finally, a hashtable:
        startTime = System.currentTimeMillis();
        count = findWithHashtable (queries);
        timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a hashtable: count=" + count + "  timeTaken=" + timeTaken);

    }

    static int findWithArrayList (int[] queries)
    {
	int count = 0;
	for (int k: queries) {
	    if (list.contains(k)) {
		count ++;
	    }
	}
	return count;
    }


    static int findWithTree (int[] queries)
    {
	int count = 0;
	for (int k: queries) {
	    if (tree.contains(k)) {
		count ++;
	    }
	}
	return count;
    }

    static int findWithHashtable (int[] queries)
    {
	// MY CODE HERE:
	int count = 0;
	for (int k: queries) {
	    if (hashtable.contains(k)) {
		count ++;
	    }
	}

	return count;
    }

    static int[] makeRandomQueries (int numQueries)
    {
	int[] A = new int [numQueries];
	Random rand = new Random ();
	for (int i=0; i<numQueries; i++) {
	    A[i] = rand.nextInt (N);
	}
	return A;
    }

}
