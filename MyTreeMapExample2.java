// Unit 5, Module 0, ex. 42

import java.util.*;

class TribeInfo {

    String name;
    int fierceness;
    String planet;

    // Constructor
    public TribeInfo (String inputName, int inputFierceness, String inputPlanet)
    {
	name = inputName;
	fierceness = inputFierceness;
	planet = inputPlanet;
    }

    public String toString ()
    {
	return name + ", " + fierceness + ", " + planet;
    }

}

public class MyTreeMapExample2 {

    public static void main (String[] argv)
    {
	TreeMap<String, TribeInfo> map = new TreeMap<>();

	TribeInfo info = new TribeInfo ("Ewok", 3, "Endor");
	map.put ("Ewok", info);

	info = new TribeInfo ("Aqualish", 6, "Ando");
	map.put ("Aqualish", info);

	info = new TribeInfo ("Gungan", 2, "Naboo");
	map.put ("Gungan", info);

	info = new TribeInfo ("Amanin", 8, "Maridun");
	map.put ("Amanin", info);

	info = new TribeInfo ("Jawa", 6, "Tatooine");
	map.put ("Jawa", info);

	info = new TribeInfo ("Hutt", 7, "Varl");
	map.put (info.name, info);

	map.put ( "Cerean", new TribeInfo ("Cerean", 4, "Cerea"));


	TribeInfo result = map.get ("Hutt");
	System.out.println (result);

	// System.out.println ( map.toString() );
	
    }

}
