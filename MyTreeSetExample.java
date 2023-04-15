// Unit 5, Module 0, Ex. 40

import java.util.*;

public class MyTreeSetExample {

    public static void main (String[] argv)
    {
	TreeSet<String> tree = new TreeSet<> ();
	tree.add ("Ewok");
	tree.add ("Gungan");
	tree.add ("Aqualish");
	tree.add ("Amanin");
	tree.add ("Cerean");
	tree.add ("Jawa");
	tree.add ("Hutt");

	if ( tree.contains("Ewok") ) {
	    System.out.println ("Ewok is in the tree.");
	}

	// System.out.println ( tree.toString() );
	
       
    }

}
