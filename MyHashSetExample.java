// Unit 5, Module 0, ex. 40 (part 2)

import java.util.*;

public class MyHashSetExample {

    public static void main (String[] argv)
    {
	HashSet<Integer> h = new HashSet<>();
	h.add (7);
	h.add (9);
	h.add (3);
	h.add (5);
	h.add (1);
	h.add (11);
	h.add (13);

	if ( h.contains(11) ) {
	    System.out.println ("11 is in the hashtable.");
	}

	// System.out.println ( h.toString() );
	
    }

}
