// Unit 5, Module 0, ex. 0.41

import java.util.*;

public class MyTreeMapExample {

    public static void main (String[] argv)
    {
	TreeMap<String, Integer> h = new TreeMap<>();
	h.put ("Ewok", 3);
	h.put ("Aqualish", 6);
	h.put ("Gungan", 2);
	h.put ("Amanin", 8);
	h.put ("Jawa", 6);
	h.put ("Hutt", 7);
	h.put ("Cerean", 4);

	int rating = h.get ("Gungan");
	System.out.println (rating);

	// System.out.println ( h.toString() );
    }

}
