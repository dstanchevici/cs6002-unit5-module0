
import java.util.*;

public class HashtableString2 {

    int numBuckets = 5;
    LinkedList<String>[] table = new LinkedList [numBuckets];
    int numItems = 0;

    public void add (String data)
    {
	if ( contains(data) ) {
	    return;
	}

        // Compute hashcode and therefore, which table entry (list).
	int entry = hashfunction (data);

        // If there's no list there, make one.
	if (table[entry] == null) {
	    table[entry] = new LinkedList<>();
	}

        // Add data to the List.
        table[entry].add (data);

        numItems ++;
    }

    public int hashfunction (String data)
    {
	int intValue = 0;
	for (int i=0; i<data.length(); i++) {
	    intValue += (int) data.charAt(i);
	}
	return intValue % numBuckets;
    }

    public int size ()
    {
	return numItems;
    }

    public boolean contains (String data)
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
	System.out.println ("Hashtable: ");
        for (int i=0; i<table.length; i++) {
	    System.out.print ("Bucket # " + i + ": ");
	    if (table[i] == null) {
		System.out.println ();
		continue;
	    }
	    for (String str: table[i]) {
		System.out.print (" " + str);
	    }
	    System.out.println ();
	}
    }

}
