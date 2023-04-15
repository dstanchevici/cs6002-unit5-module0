
class ListItem {
    String key;           // Store the key here.
    int value;            // The associated value.
    ListItem next;        // The usual next pointer.
}


public class OurLinkedListMap {

    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;


    public void add (String key, int value)
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


    public int get (String key)
    {
        ListItem ptr = front;

	while (ptr != null) {
	    if (ptr.key == key) {
		return ptr.value;
	    }
	    ptr = ptr.next;
	}

	// Return -1 if nothing is found. (We need to return some int).
	return -1;
    }

}

