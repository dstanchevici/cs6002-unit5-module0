// WordTool.java
//
// Author: Rahul Simha
// September 2006
// Updated: 2017, 2019
//
// A general purpose tool to work with words. Needs
// two text files: words.txt (the Unix dictionary)
// and wordsWithPOSAndPron.txt (words with Parts-of-Speech), an edited
// version of the Moby project, using only words from the Unix
// dictionary, about 20,000 words.

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordTool {

    static ArrayList<String> allWords = new ArrayList<String> ();        
    static ArrayList<String> nouns = new ArrayList<String> ();         // N
    static ArrayList<String> pluralNouns = new ArrayList<String> ();   // p
    static ArrayList<String> verbs = new ArrayList<String> ();         // V
    static ArrayList<String> transVerbs = new ArrayList<String> ();    // t
    static ArrayList<String> inTransVerbs = new ArrayList<String> ();  // i
    static ArrayList<String> adjectives = new ArrayList<String> ();    // A
    static ArrayList<String> adverbs = new ArrayList<String> ();       // v
    static ArrayList<String> conjunctives = new ArrayList<String> ();  // C
    static ArrayList<String> prepositions = new ArrayList<String> ();  // P
    static ArrayList<String> pronouns = new ArrayList<String> ();      // r

    // Given a word, produce its pronunciation (phoneme breakdown)
    static HashMap<String, String> pronunciations = new HashMap<String, String>();

    static ArrayList<String> klingonWords = new ArrayList<String> ();


    public static void main (String[] argv)
    {
	// For testing only.
	//readWordsPOSAndPron ();
	//readWordsPOSAndPronLarge ();
	HashSet<String> words = getScrabbleWordsUpperCase ();
    }

    /////////////////////////////////////////////////////////////////////
    // Random Letters and strings

    public static char getRandomLetter ()
    {
	Random rand = new Random ();
	int k = rand.nextInt (25);
	char ch = (char) (97 + k);
	return ch;
    }

    public static char getRandomCapLetter ()
    {
	Random rand = new Random ();
	int k = rand.nextInt (25);
	char ch = (char) (65 + k);
	return ch;
    }

    public static String getRandomString (int length)
    {
	char[] letters = new char [length];
	Random rand = new Random ();
	for (int i=0; i<length; i++) {
	    int k = rand.nextInt (25);
	    letters[i] = (char) (97 + k);
	}
	String s = new String (letters);
	return s;
    }

    public static String getRandomString (int minLength, int maxLength)
    {
	if (minLength > maxLength) {
	    return null;
	}
	if (minLength < 1) {
	    return null;
	}
	Random rand = new Random ();
	int diff = rand.nextInt (maxLength-minLength+1);
	int length = minLength + diff;
	char[] letters = new char [length];
	for (int i=0; i<length; i++) {
	    int k = rand.nextInt (25);
	    letters[i] = (char) (97 + k);
	}
	String s = new String (letters);
	return s;
    }


    /////////////////////////////////////////////////////////////////////
    // Without POS/Pron

    public static String[] getAllWords ()
    {
	ArrayList<String> allWordsList = getAllWordsAsList();
	String[] allWordsArray = new String [allWordsList.size()];
	int k = 0;
	for (String w: allWordsList) {
	    allWordsArray[k++] = w;
	}
	return allWordsArray;
    }

    public static String[] getDictionary ()
    {
	return getAllWords();
    }

    public static ArrayList<String> getAllWordsAsList ()
    {
	if (allWords.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	// We're now going to remove duplicates because some
	// words occur as both verb and noun, e.g. "scrub"
	HashSet<String> uniqueWords = new HashSet<>();
	for (String w: allWords) {
	    uniqueWords.add (w);
	}
	allWords = new ArrayList<>();
	for (String w: uniqueWords) {
	    allWords.add (w);
	}
	Collections.sort (allWords);
	return allWords;
    }

    public static ArrayList<String> getUnixWordsAsList ()
    {
	ArrayList<String> unixWordsList = new ArrayList<String> ();
	String[] unixWords = getUnixWords ();
	for (String w: unixWords) {
	    unixWordsList.add (w);
	}
	return unixWordsList;
    }

    public static String[] getUnixWords ()
    {
	String[] unixWords = getDictionary ("words.txt");
	return unixWords;
    }

    /////////////////////////////////////////////////////////////////////
    // Parts of Speech and pronunciation

    public static void readWordsPOSAndPron ()
    {
	readWordsPOSAndPron ("wordsWithPOSAndPron.txt");
    }

    public static void readWordsPOSAndPronLarge ()
    {
	readWordsPOSAndPron ("wordsWithPOSAndPronLarge.txt");
    }

    public static ArrayList<String> getNounsAsList ()
    {
	if (nouns.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return nouns;
    }

    public static String[] getNouns ()
    {
	return (String[]) getNounsAsList().toArray();
    }

    public static String getRandomNoun ()
    {
	return pickRandom (getNounsAsList());
    }

    public static ArrayList<String> getPluralNounsAsList ()
    {
	if (pluralNouns.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return pluralNouns;
    }

    public static String[] getPluralNouns ()
    {
	return (String[]) getPluralNounsAsList().toArray();
    }

    public static String getRandomPluralNoun ()
    {
	return pickRandom (getPluralNounsAsList());
    }

    public static ArrayList<String> getVerbsAsList ()
    {
	if (verbs.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return verbs;
    }

    public static String[] getVerbs ()
    {
	return (String[]) getVerbsAsList().toArray();
    }

    public static String getRandomVerb ()
    {
	return pickRandom (getVerbsAsList());
    }

    public static ArrayList<String> getTransVerbsAsList ()
    {
	if (transVerbs.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return transVerbs;
    }

    public static String[] getTransVerbs ()
    {
	return (String[]) getTransVerbsAsList().toArray();
    }

    public static String getRandomTransVerb ()
    {
	return pickRandom (getTransVerbsAsList());
    }

    public static ArrayList<String> getInTransVerbsAsList ()
    {
	if (inTransVerbs.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return inTransVerbs;
    }

    public static String[] getInTransVerbs ()
    {
	return (String[]) getInTransVerbsAsList().toArray();
    }

    public static String getRandomInTransVerb ()
    {
	return pickRandom (getInTransVerbsAsList());
    }

    public static ArrayList<String> getAdjectivesAsList ()
    {
	if (adjectives.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return adjectives;
    }

    public static String[] getAdjectives ()
    {
	return (String[]) getAdjectivesAsList().toArray();
    }

    public static String getRandomAdjective ()
    {
	return pickRandom (getAdjectivesAsList());
    }

    public static ArrayList<String> getAdverbsAsList ()
    {
	if (adverbs.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return adverbs;
    }

    public static String[] getAdverbs ()
    {
	return (String[]) getAdverbsAsList().toArray();
    }

    public static String getRandomAdverb ()
    {
	return pickRandom (getAdverbsAsList());
    }

    public static ArrayList<String> getConjunctivesAsList ()
    {
	if (conjunctives.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return conjunctives;
    }

    public static String[] getConjunctives ()
    {
	return (String[]) getConjunctivesAsList().toArray();
    }

    public static String getRandomConjunctive ()
    {
	return pickRandom (getConjunctivesAsList());
    }

    public static ArrayList<String> getPrepositionsAsList ()
    {
	if (prepositions.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return prepositions;
    }

    public static String[] getPrepositions ()
    {
	return (String[]) getPrepositionsAsList().toArray();
    }

    public static String getRandomPreposition ()
    {
	return pickRandom (getPrepositionsAsList());
    }

    public static ArrayList<String> getPronounsAsList ()
    {
	if (pronouns.size() <= 0) {
	    readWordsPOSAndPron ();
	}
	return pronouns;
    }

    public static String[] getPronouns ()
    {
	return (String[]) getPronounsAsList().toArray();
    }

    public static String getRandomPronoun ()
    {
	return pickRandom (getPronounsAsList());
    }


    //////////////////////////////////////////////////////////////
    // Klingon words: klingonwords.txt

    public static ArrayList<String> getKlingonWordsAsList ()
    {
	if ( (klingonWords == null) || (klingonWords.size() == 0) ) {
	    readKlingonWords ("klingonwords.txt");
	}
	return klingonWords;
    }
    

    public static String[] getKlingonWords ()
    {
	ArrayList<String> klingonWords = getKlingonWordsAsList ();
	String[] words = new String [klingonWords.size()];
	int k = 0;
	for (String w: klingonWords) {
	    words[k++] = w;
	}
	return words;
    }

    static void readKlingonWords (String filename)
    {
	try {
	    LineNumberReader lnr = new LineNumberReader (new FileReader (filename));
	    klingonWords = new ArrayList<String> ();
	    String line = lnr.readLine ();
	    while (line != null) {
		klingonWords.add (line.trim());
		line = lnr.readLine ();
	    }
	}
	catch (Exception e) {
	    System.out.println (e);
	    e.printStackTrace ();
	}

    }


    //////////////////////////////////////////////////////////////
    // Scrabble words: we're using hashsets because the most common 
    // use is to see if a word is in the set or not.

    public static HashSet<String> getScrabbleWordsLowerCase ()
    {
	return getScrabbleWords (true);
    }

    public static HashSet<String> getScrabbleWordsUpperCase ()
    {
	return getScrabbleWords (false);
    }



    public static HashSet<String> getScrabbleWords (boolean isLowerCase)
    {
	try {
	    HashSet<String> scrabbleWords = new HashSet<>();
	    Scanner scanner = new Scanner (new FileReader ("scrabblewords.txt"));
	    while (scanner.hasNext()) {
		// At each step, get the next word and place in list.
		String s = scanner.next();
		if (isLowerCase) {
		    scrabbleWords.add (s.toLowerCase());
		}
		else {
		    scrabbleWords.add (s);
		}
		//System.out.println ("[" + s + "]");
	    }

	    return scrabbleWords;
	}
	catch (IOException e) {
	    System.out.println (e);
	    System.exit (0);
	    return null;
	}

    }

    //////////////////////////////////////////////////////////////
    // Dictionary: words.txt

    public static String[] getDictionary (String fileName)
    {
	String[] words = readDictionary (fileName, null);
        String[] scrubbedWords = scrub (words);
	return scrubbedWords;  
    }


    static String[] readDictionary (String fileName, Pattern pattern)
    {
	String[] words = null;
	try {
	    // Since we don't know in advance how many words there 
	    // are, we'll use a list instead of an array.
	    LinkedList<String> stringList = new LinkedList<String>();

	    // Scanner knows how to skip whitespace.
	    Scanner scanner = new Scanner (new FileReader (fileName));
            if (pattern != null) {
                scanner = scanner.useDelimiter (pattern);
            }
            
	    while (scanner.hasNext()) {
		// At each step, get the next word and place in list.
		String s = scanner.next();
		stringList.addLast (s);
	    }

	    // Now that we know the size, we'll make an array.
	    words = new String [stringList.size()];
	    Iterator<String> iter = stringList.iterator();
	    int i = 0;
	    while (iter.hasNext()) {
		words[i] = iter.next();
		i ++;
	    }

	    // Done.
	    return words;
	}
	catch (IOException e) {
	    System.out.println (e);
	    System.exit (0);
	    return null;
	}
    }


    static String[] readWords (String fileName)
    {
        Pattern p = Pattern.compile ("\\W");
	String[] words = readDictionary (fileName, p);
        String[] scrubbedWords = scrub (words);
	return scrubbedWords;  
    }
    

    static String[] scrub (String[] words)
    {
        // Remove words with caps, and single-letter words
        int badWords = 0;
        for (int i=0; i<words.length; i++) {
            if (words[i].length() <= 1) {
                badWords ++;
                words[i] = null;
            }
            else if ( Character.isUpperCase (words[i].charAt(0)) ) {
                badWords ++;
                words[i] = null;
            }
        }

	// Make space for the good words.
        String[] realWords = new String [words.length - badWords];
        int j = 0;
        for (int i=0; i<realWords.length; i++) {
            while (words[j] == null) {
                j ++;
            }
            realWords[i] = words[j];
            j ++;
        }

        return realWords;
    }


    public static char[] computeRemainder (char[] dividend, char[] quotient)
    {
        // First, copy.
        char[] dividendCopy = copy (dividend);

        // Now check off.
        for (int i=0; i<quotient.length; i++) {
            // Look for quotient[i] in dividendCopy.
            boolean found = false;
            for (int j=0; j<dividendCopy.length; j++) {
                if (dividendCopy[j] == quotient[i]) {
                    found = true;
                    dividendCopy[j] = '#';
                    break;
                }
            }
            if (! found) {
                return copy(dividend);
            }
        }
        
        // If we reached here, all letters were found.
        if (dividend.length == quotient.length) {
            return null;
        }
        
        char[] remainder = new char [dividend.length - quotient.length];
        int j = 0;
        for (int i=0; i<remainder.length; i++) {
            while (dividendCopy[j] == '#') {
                j++;
            }
            remainder[i] = dividendCopy[j];
            j ++;
        }
        return remainder;
    }
    

    static char[] copy (char[] A)
    {
        char[] B = new char [A.length];
        for (int i=0; i<B.length; i++) {
            B[i] = A[i];
        }
        return B;
    }
    
    //////////////////////////////////////////////////////////////
    // With Parts of Speech and pronuciation: wordsWithPOSAndPron.txt
    // or wordsWithPOSAndPronLarge.txt

    static void readWordsPOSAndPron (String filename)
    {
	try {
	    File f = new File (filename);

	    LineNumberReader lnr = new LineNumberReader (new FileReader (f));
	    String line = lnr.readLine ();
	    int n = 0;
	    while (line != null) {
		parsePOSAndPron (line);
		line = lnr.readLine ();
		n ++;
		//if (n > 100) break;
	    }
	}
	catch (Exception e) {
	    System.out.println (e);
	    e.printStackTrace ();
	    System.exit (0);
	}
    }

    static void parsePOSAndPron (String line)
    {
	int posIndex = line.indexOf ('-');
	int pronIndex = line.indexOf ('+');
	if ((posIndex < 0) || (pronIndex < 0)) {
	    System.out.println ("ERROR: posIndex=" + posIndex + " pronIndex=" + pronIndex);
	    System.exit(0);
	}
	String word = line.substring (0, posIndex);
	if (word.length() <= 1) {
	    return;
	}
	String desc = line.substring (posIndex+1, pronIndex);
	String pron = line.substring (pronIndex+1, line.length());

	//System.out.println ("word=[" + word + "] desc=[" + desc + "] pron=[" + pron + "]");

	// Words have already been scrubbed.
	classifyWord (word, desc);
	pronunciations.put (word, pron);
	allWords.add (word);
    }

    static void classifyWord (String word, String desc)
    {
	if (desc.contains("N")) {
	    nouns.add (word);
	}
	if (desc.contains("p")) {
	    pluralNouns.add (word);
	}
	if (desc.contains("V")) {
	    verbs.add (word);
	}
	if (desc.contains("t")) {
	    transVerbs.add (word);
	}
	if (desc.contains("i")) {
	    inTransVerbs.add (word);
	}
	if (desc.contains("A")) {
	    adjectives.add (word);
	}
	if (desc.contains("v")) {
	    adverbs.add (word);
	}
	if (desc.contains("C")) {
	    conjunctives.add (word);
	}
	if (desc.contains("P")) {
	    prepositions.add (word);
	}
	if (desc.contains("r")) {
	    pronouns.add (word);
	}

    }

    static void printAllSizes ()
    {
	System.out.println ("Nouns:" + nouns.size());
	System.out.println ("Plural nouns:" + pluralNouns.size());
	System.out.println ("Verbs:" + verbs.size());
	System.out.println ("Transitive verbs:" + transVerbs.size());
	System.out.println ("Intransitive verbs:" + inTransVerbs.size());
	System.out.println ("Adjectives:" + adjectives.size());
	System.out.println ("Adverbs:" + adverbs.size());
	System.out.println ("Conjunctives:" + conjunctives.size());
	System.out.println ("Prepositions:" + pronouns.size());
    }

    static void printAllWords ()
    {
	System.out.print ("Nouns:");
	for (String w: nouns) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Plural nouns:");
	for (String w: pluralNouns) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Verbs:");
	for (String w: verbs) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Transitive verbs:");
	for (String w: transVerbs) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Intransitive verbs:");
	for (String w: inTransVerbs) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Adjectives:");
	for (String w: adjectives) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Adverbs:");
	for (String w: adverbs) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Conjunctives:");
	for (String w: conjunctives) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Prepositions:");
	for (String w: prepositions) {
	    System.out.print (" " + w);
	}
	System.out.print ("\n\n Pronouns:");
	for (String w: pronouns) {
	    System.out.print (" " + w);
	}
	System.out.println ();
    }

    static String pickRandom (ArrayList<String> wordList)
    {
	Random rand = new Random ();
	int index = rand.nextInt (wordList.size());
	return wordList.get(index);
    }


}
