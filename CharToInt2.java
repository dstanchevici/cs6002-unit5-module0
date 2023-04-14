
public class CharToInt2 {

    public static void main (String[] argv)
    {
	int numBuckets = 5;
	for (char ch='a'; ch<='z'; ch++) {
	    int intValue = (int) ch;
	    int hashvalue = intValue % numBuckets;
	    System.out.println ("char=" + ch + "  intvalue=" + intValue + " hash=" + hashvalue);
	}
    }

}
