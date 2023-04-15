// NOTE: I have replaced "TribeInfo" with
// "TribeInfo2" to avoid the clash with
// "TribeInfo used in MyTreeMapExample2

class ListItem {
    String key;
    TribeInfo2 value;
    ListItem next;        // The usual next pointer.
}


public class OurLinkedListMap2 {

    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;


    public void add (String key, TribeInfo2 value)
    {
        if ( contains (key) ) {
            return;
        }

	if (front == null) {
	    front = new ListItem ();
	    front.key = key;
	    front.value = value;
	    rear = front;
	    rear.next = null;
	}
	else {
            ListItem nextOne = new ListItem ();
	    nextOne.key = key;
	    nextOne.value = value;
	    rear.next = nextOne;
	    rear = nextOne;
	}    

	numItems ++;
    }


    public int size ()
    {
	return numItems;
    }

    

    public boolean contains (String key)
    {
	ListItem ptr = front;
	while (ptr != null) {
	    if (ptr.key == key) {
		return true;
	    }
	    ptr = ptr.next;
	}

	return false;
    }


    public TribeInfo2 get (String key)
    {
        ListItem ptr = front;

	while (ptr != null) {
	    if (ptr.key == key) {
		return ptr.value;
	    }
	    ptr = ptr.next;
	}

	// If nothing has been found
	System.out.println ("No such tribe found");
	return null;
    }

}

