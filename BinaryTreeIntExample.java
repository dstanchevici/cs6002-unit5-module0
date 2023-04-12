
public class BinaryTreeIntExample {

    public static void main (String[] argv)
    {
        // Make an instance of the tree.
        BinaryTreeInt tree = new BinaryTreeInt ();

        // Add stuff.
        tree.add (7);
        tree.add (9);
        tree.add (3);
        tree.add (5);
        tree.add (1);
        tree.add (11);
        tree.add (13);

	System.out.println ("Number in tree: " + tree.size());
	TreeNode root = tree.getRoot ();

	System.out.println ("Root: " + root);
	System.out.println ("Root's left child: " + root.left);
	System.out.println ("Root's right child: " + root.right);
    }

}
