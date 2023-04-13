
import java.util.*;

class TreeNode {
    int data;        
    TreeNode left;    // Pointer to the left child.
    TreeNode right;   // Pointer to the right child.

    // This could be useful in debugging:

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

} //end-TreeNode



public class BinaryTreeInt {

    TreeNode root = null;    // Root of the tree.
    int numItems = 0;


    public void printInorder ()
    {
	printInorderRecursively (root);
	System.out.println ();
    }

    void printInorderRecursively (TreeNode node)
    {
	if (node==null) {
	    return;
	}

	printInorderRecursively (node.left);
	System.out.print (" " + node.data);	
	printInorderRecursively (node.right);
    }

	
    public void printPreorder ()
    {
	printPreorderRecursively (root);
	System.out.println ();
    }

    void printPreorderRecursively (TreeNode node)
    {
	if (node==null) {
	    return;
	}
	
	System.out.print (" " + node.data);	
	printPreorderRecursively (node.left);	
	printPreorderRecursively (node.right);
    }

    
    public void printPostorder ()
    {
	printPostorderRecursively (root);
	System.out.println ();
    }
    
    void printPostorderRecursively (TreeNode node)
    {
	if (node==null) {
	    return;
	}
	
	printPostorderRecursively (node.left);	
	printPostorderRecursively (node.right);
	System.out.print (" " + node.data);		
    }

    
    public boolean contains (int k)
    {	
	return recursiveSearch (root, k);
    }

    boolean recursiveSearch (TreeNode node, int k)
    {
	if (node == null) {
	    return false;
	}
	
	if (k == node.data) {
	    return true;
	}

	if (k < node.data) {
	    return recursiveSearch (node.left, k);
	}
	else {
	    return recursiveSearch (node.right, k);
	}
    }

    
    public void add (int k)
    {
        // If empty, create new root.
        if (root == null) {
            root = new TreeNode ();
            root.data = k;
	    numItems++; // Increment numItems
            return;
        }
        
        // If this is a new piece of data, insert into tree.
        recursiveInsert (root, k);
    }

    
    void recursiveInsert (TreeNode node, int k)
    {
	// Return without inserting in case of duplicate
	if (k == node.data) {
	    System.out.println ("The tree already contains " + k + ".");
	    return;
	}

	// Check if node should be placed in left subtree
	else if (k < node.data) {
	    if (node.left == null) {
		node.left = new TreeNode ();
		node.left.data = k;
		numItems++; // Increment numItems		
		return;
	    }
	    else {
		recursiveInsert (node.left, k); // Continue looking
	    }
	}

	// Check right subtree in case k > node.data
	else {
	    if (node.right == null) {
		node.right = new TreeNode ();
		node.right.data = k;
		numItems++; // Increment numItems
		return;
	    }
	    else {
		recursiveInsert (node.right, k); // Continue looking
	    }	    
	} // end-if/elseif/else
    } // end-recursiveInsert()
    

    
    
    
    public int size ()
    {
        return numItems;
    }


    public TreeNode getRoot ()
    {
	return root;
    }

}
