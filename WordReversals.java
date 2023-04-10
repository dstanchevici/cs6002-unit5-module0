import java.util.*;

public class WordReversals {

    public static void main (String[] argv)
    {
        // Fetch the list of words:
        String[] words = WordTool.getAllWords ();
	System.out.println ("# words: " + words.length);

	// Try a linked list:
        long startTime = System.currentTimeMillis();
        int count = findReversalsUsingLinkedList (words);
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a linked-list: count=" + count + "  timeTaken=" + timeTaken);

	// Next, an array-list:
        startTime = System.currentTimeMillis();
        count = findReversalsUsingArrayList (words);
        timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using an array-list: count=" + count + "  timeTaken=" + timeTaken);

	// And then, a tree:
        startTime = System.currentTimeMillis();
        count = findReversalsUsingTree (words);
        timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a tree: count=" + count + "  timeTaken=" + timeTaken);

	// Finally, a hashtable:
        startTime = System.currentTimeMillis();
        count = findReversalsUsingHashtable (words);
        timeTaken = System.currentTimeMillis() - startTime;
        System.out.println ("Using a hashtable: count=" + count + "  timeTaken=" + timeTaken);
    }
    

    static int findReversalsUsingLinkedList (String[] words)
    {
	// A counter to count the number of words that are reversals.
        int count = 0;

	// Put all the words in a linked list:
        LinkedList<String> wordSet = new LinkedList<>();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
	// Now try every word, reversing it to see if the reverse is 
	// in the set of words.
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }

	return count;
    }


    static int findReversalsUsingArrayList (String[] words)
    {
        int count = 0;

        ArrayList<String> wordSet = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }

	return count;
    }


    static int findReversalsUsingTree (String[] words)
    {
        int count = 0;

        // First put all words into a tree.
        TreeSet<String> wordSet = new TreeSet<>();
        for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        // Now perform the search for reversals.
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }

	return count;
    }


    static int findReversalsUsingHashtable (String[] words)
    {
	int count = 0;

        HashSet<String> wordSet = new HashSet<>();

        // INSERT YOUR CODE HERE
	for (int i=0; i<words.length; i++) {
            wordSet.add (words[i]);
        }
        
        // Now perform the search for reversals.
        for (int i=0; i<words.length; i++) {
            String reverseStr = reverse (words[i]);
            if (wordSet.contains (reverseStr)) {
                count ++;
            }
        }

	return count;
    }
    



    // Reverse a string. This method is used above.

    static String reverse (String str) 
    {
        char[] letters = str.toCharArray ();
        char[] revLetters = new char [letters.length];    

	for (int i=0; i<letters.length; i++) {
	    revLetters[i] = letters[letters.length-1-i];
	}

        String revStr = new String (revLetters);    // Notice the constructor.
        return revStr;
    }
    

}
