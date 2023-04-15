// NOTE: I have replaced "TribeInfo" with
// "TribeInfo2" to avoid the clash with
// "TribeInfo used in MyTreeMapExample2


class TribeInfo2 {

    String name;
    int fierceness;
    String planet;

    public TribeInfo2 (String name, int fierceness, String planet)
    {
        this.name = name;
        this.fierceness = fierceness;
        this.planet = planet;
    }

    public String toString ()
    {
        return "Tribe: " + name + " from planet " + planet + " rating=" + fierceness;
    }
    
}

public class OurLinkedListMapExample2 {

    public static void main (String[] argv)
    {
	OurLinkedListMap2 map = new OurLinkedListMap2 ();

        TribeInfo2 info = new TribeInfo2 ("Ewok", 3, "Endor");
        map.add ("Ewok", info);

        info = new TribeInfo2 ("Aqualish", 6, "Ando");
        map.add ("Aqualish", info);

        info = new TribeInfo2 ("Gungan", 2, "Naboo");
        map.add ("Gungan", info);

        info = new TribeInfo2 ("Amanin", 8, "Maridun");
        map.add ("Amanin", info);

        info = new TribeInfo2 ("Jawa", 6, "Tatooine");
        map.add ("Jawa", info);

        info = new TribeInfo2 ("Hutt", 7, "Varl");
        map.add ("Hutt", info);

        info = new TribeInfo2 ("Cerean", 4, "Cerea");
        map.add ("Cerean", info);

        TribeInfo2 result = map.get ("Hutt");
        System.out.println (result); // Same with   System.out.println (result.toString());
    }

}
