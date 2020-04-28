//Yelanika Gunasekara 
//Assignment2
//13 March 2020

public class BinaryTreeNode<String>
{
	String data;
	int height;
	BinaryTreeNode<String> left;
	BinaryTreeNode<String> right;

   
	public BinaryTreeNode ( String d, BinaryTreeNode<String> l, BinaryTreeNode<String> r )
	{
		data = d;
		left = l;
		right = r;
	}
   
	BinaryTreeNode<String> getLeft () { return left; }
	BinaryTreeNode<String> getRight () { return right; }

}
