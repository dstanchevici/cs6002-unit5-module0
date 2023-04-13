// NOTE to Grader:
// I am changing the class name TreeNode to TreeNode2
//  so that it does not clash with the class TreeNode
//  in BinaryTreeInt.


class TreeNode2 {
    String data;
    TreeNode2 left;    // Pointer to the left child.
    TreeNode2 right;   // Pointer to the right child.

    // For debugging:
    public String toString ()
    {
        String str = "[data=" + data;
        String leftData = "null";
        if (left != null) {
            leftData = "" + left.data;
        }
        String rightData = null;
        if (right != null) {
            rightData = "" + right.data;
        }
        str += " left=" + leftData + " right=" + rightData + "]";
        return str;
    }
    
} //end-TreeNode2



public class BinaryTreeString {

    TreeNode2 root = null;    // Root of the tree.
    int numItems = 0;       


    public void add (String data)
    {	
        // If empty, create new root.
        if (root == null) {
            root = new TreeNode2 ();
            root.data = data;
	    numItems++; // Increment numItems
            return;
        }
        
        // If this is a new piece of data, insert into tree.
        recursiveInsert (root, data);	
    }

    
    void recursiveInsert (TreeNode2 node, String str)
    {
	// Return without inserting in case of duplicate
	if (str.compareTo(node.data) == 0) {
	    System.out.println ("The tree already contains " + str + ".");
	    return;
	}

	// Check if node should be placed in left subtree
	else if (str.compareTo(node.data) < 0) {
	    if (node.left == null) {
		node.left = new TreeNode2 ();
		node.left.data = str;
		numItems++; // Increment numItems		
		return;
	    }
	    else {
		recursiveInsert (node.left, str); // Continue looking
	    }
	}

	// Check right subtree
	else {
	    if (node.right == null) {
		node.right = new TreeNode2 ();
		node.right.data = str;
		numItems++; // Increment numItems
		return;
	    }
	    else {
		recursiveInsert (node.right, str); // Continue looking
	    }	    
	} // end-if/elseif/else	
    }
    

    public int size ()
    {
        return numItems;
    }
    

    public boolean contains (String str)
    {
        if (numItems == 0) {
            return false;
        }
        
        return recursiveSearch (root, str);
    }
    

    boolean recursiveSearch (TreeNode2 node, String str)
    {
	if (node == null) {
	    return false;
	}
	
	if (str.compareTo(node.data) == 0) {
	    return true;
	}

	if (str.compareTo(node.data) < 0) {
	    return recursiveSearch (node.left, str);
	}
	else {
	    return recursiveSearch (node.right, str);
	} 
    }


    public void preOrderPrint ()
    {
        System.out.println ("Pre-Order Traversal: ");
        preOrderRecursive (root);
	System.out.println ();
    }
    
    void preOrderRecursive (TreeNode2 node)
    {
	if (node==null) {
	    return;
	}
	
	System.out.print (" " + node.data);	
	preOrderRecursive (node.left);	
	preOrderRecursive (node.right);
    }
    

    public void inOrderPrint ()
    {
        System.out.println ("In-Order Traversal: ");
        inOrderRecursive (root);
	System.out.println ();	
    }


    void inOrderRecursive (TreeNode2 node)
    {
	if (node==null) {
	    return;
	}

	inOrderRecursive (node.left);
	System.out.print (" " + node.data);	
	inOrderRecursive (node.right);	
    }
    
    
    public void postOrderPrint ()
    {
        System.out.println ("Post-Order Traversal: ");
        postOrderRecursive (root);
	System.out.println ();	
    }
    

    void postOrderRecursive (TreeNode2 node)
    {
	if (node==null) {
	    return;
	}
	
	postOrderRecursive (node.left);	
	postOrderRecursive (node.right);
	System.out.print (" " + node.data);	
    }

} //end-BinaryTreeString
