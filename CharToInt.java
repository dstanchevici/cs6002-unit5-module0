
public class CharToInt {

    public static void main (String[] argv)
    {
	int numBuckets = 5;
	for (char ch='A'; ch<='Z'; ch++) {

	    int intValue = (int) ch;
	    int hashValue = intValue % numBuckets;

	    System.out.println ("char=" + ch + "  intValue=" + intValue + " hash=" + hashValue);
	}
    }

}
