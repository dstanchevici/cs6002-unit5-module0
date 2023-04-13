
public class PrintTreeExample {

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
        
	System.out.println ("In order");
        tree.printInorder ();

	System.out.println ("Pre order");
        tree.printPreorder ();

	System.out.println ("Post order");
        tree.printPostorder ();
    }

}
