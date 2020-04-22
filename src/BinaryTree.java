import java.io.FileNotFoundException;
// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree 
{
	public BinaryTreeNode<String> root;
	public String[] ls = new String[10];

	public void BinaryTree ()
	{
		root = null;
	}

	public void insert(String d)
   	{

		if (root == null)
		{
			root = new BinaryTreeNode<String> (d, null, null);
		}
		else
		{
			insert(d, root);
		}
   	}

	public void insert (String d, BinaryTreeNode<String> node)
	{
		if (d.compareTo(node.data) <= 0)
		{
			if (node.left == null)
			{
				node.left = new BinaryTreeNode<String> (d, null, null);
			}
			else
			{
				insert(d, node.left);
			}
		}
		else
		{
			if (node.right == null)
			{
				node.right = new BinaryTreeNode<String> (d, null, null);
			}
			else
			{
				insert(d, node.right);
			}
		}
	}

	public void printAllAreas()
	{
		preOrder(root);
	}

	public String printAreas( String d)
	{
		if (root == null )
		{
			return null;
		}
		else
		{
			find(d,root);
			return "";
		}
	}

	public String find (String d, BinaryTreeNode<String> node)
	{	
		//System.out.println(node);
		ls = node.data.split("\\D");

		System.out.println(node.data);
		
		String s = ls[0];
		String dx = ls[1];
		String t = ls[2];

		//System.out.println(ls.length);
		//System.out.println

		String hold = s + " " + dx + " " + t;

		//System.out.println(hold + " " + ls[3]);

		String temp = "Areas: ";

		String[] dArr = new String[2];
		dArr = d.split("//D");
	
		int cmp = d.compareTo(hold);

		if (cmp == 0)
		{	
			String ls_n[];
			ls_n = node.data.split(",");		

			if (ls[0].equals("1"))
				temp = temp + ls[3];
			else if (ls[0].equals("2"))
			{
				temp = temp + ls[3]+ " " + ls_n[1];
			}
			else if (ls[0].equals("3"))
			{
				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2]; 
			}
			else if (ls[0].equals( "4"))
			{
				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2] + " " + ls_n[3];
			}
			else if (ls[0].equals("5"))
			{
				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2] + " " + ls_n[3] + " " + ls_n[4];
			}
			else if (ls[0].equals("6"))
			{
				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2] + " " + ls_n[3] + " " + ls_n[4] + " " + ls_n[5];
			}
			else if (ls[0].equals("7"))
			{
				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2] + " " + ls_n[3] + " " + ls_n[4] + " " + ls_n[5] + " " + ls_n[6];
			}
			else if (ls[0].equals("8"))
			{

				temp = temp + ls[3]+ " " + ls_n[1] + " " + ls_n[2] + " " + ls_n[3] + " " + ls_n[4] + " " + ls_n[5] + " " + ls_n[6] + " " + ls_n[7];
				
			}

			System.out.println(temp);
			return "";
		}
		else if ((cmp < 0))
		{
			if (node.left == null) 
				return null;
			else
			{
		 		find (d,node.left);
				return "";
			}
		}
		else
		{
			if (node.right == null) 
				return null; 
			else
			{
				find (d,node.right);
				return "";
			}
		}
	}

	public void visit (BinaryTreeNode<String> node)
	{
		System.out.println(node.data);
	}

   	public void preOrder ()
   	{
      		preOrder (root);
   	}

   	public void preOrder ( BinaryTreeNode<String> node )
   	{
	      	if (node != null)
	      	{
	        	 visit (node);
	        	 preOrder (node.getLeft());
	       		 preOrder (node.getRight());
	     	 }   
	}
}
