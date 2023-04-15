
public class OurLinkedListMapExample {

    public static void main (String[] argv)
    {
	OurLinkedListMap map = new OurLinkedListMap ();
        map.add ("Ewok", 3);
        map.add ("Aqualish", 6);
        map.add ("Gungan", 2);
        map.add ("Amanin", 8);
        map.add ("Jawa", 6);
        map.add ("Hutt", 7);
        map.add ("Cerean", 4);

	int rating = map.get ("Gungan");
	System.out.println (rating);

	//System.out.println (map.contains ("Soo"));
	//System.out.println (map.contains ("Cerean"));
	
			    
    }

}
