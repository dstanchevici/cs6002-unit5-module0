
import java.util.*;

public class HashtableInt {

    int numBuckets = 5;
    LinkedList<Integer>[] table = new LinkedList [numBuckets];
    int numItems = 0;

    public void add (int data)
    {
	if ( contains(data) ) {
	    // System.out.println ("Hashtable already contains " + data + ".");
	    return;
	}

        // Compute hashcode and therefore, which table entry (list).
	int entry = hashfunction (data);

        // If there's no list there, make one.
	if (table[entry] == null) {
	    table[entry] = new LinkedList<>();
	}

        // Add to the List.
        table[entry].add (data);

        numItems ++;
    }

    public int hashfunction (int data)
    {
	int hashvalue = data % numBuckets;
	return hashvalue;
    }

    public int size ()
    {
	return numItems;
    }

    public boolean contains (int data)
    {
	int entry = hashfunction (data);
	if (table[entry] == null) {
	    return false;
	}
	boolean doesListContain = table[entry].contains(data);
	return doesListContain;
    }

    public void print ()
    {
	for (int i=0; i<table.length; i++) {
	    if (table[i] != null) {
		System.out.println (table[i]);
	    }
	}
    }

}
