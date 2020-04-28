//Yelanika Gunasekara 
//Assignment2
//13 March 2020

public class AVLTree
{

	public BinaryTreeNode<String> root; 
	public String[] ls = new String[10];
	public int opCount = 0;

	public void AVLTree()
	{
		root = null;
	}

	public int height ( BinaryTreeNode<String> node )
	{
		if (node != null)
			return node.height;
		return -1;
	}	
   
	public int balanceFactor ( BinaryTreeNode<String> node )
	{
		return height (node.right) - height (node.left);
	}
   
	public void fixHeight ( BinaryTreeNode<String> node )
	{
		node.height = Math.max (height (node.left), height (node.right)) + 1;
	}
   
	public BinaryTreeNode<String> rotateRight ( BinaryTreeNode<String> p )
	{
		BinaryTreeNode<String> q = p.left;
		p.left = q.right;
		q.right = p;
		fixHeight (p);
		fixHeight (q);
		return q;
	}

	public BinaryTreeNode<String> rotateLeft ( BinaryTreeNode<String> q )
	{
		BinaryTreeNode<String> p = q.right;
		q.right = p.left;
		p.left = q;
		fixHeight (q);
		fixHeight (p);
		return p;
	}
   
	public BinaryTreeNode<String> balance ( BinaryTreeNode<String> p )
	{
		fixHeight (p);
		if (balanceFactor (p) == 2)
		{
			if (balanceFactor (p.right) < 0)
				p.right = rotateRight (p.right);
			return rotateLeft (p);
		}
		if (balanceFactor (p) == -2)
		{
			if (balanceFactor (p.left) > 0)
				p.left = rotateLeft (p.left);
			return rotateRight (p);
		}
		return p;
	}

	public void insert ( String d )
	{
		root = insert (d, root);
	}

	public BinaryTreeNode<String> insert ( String d, BinaryTreeNode<String> node )
	{
		if (node == null)
			return new BinaryTreeNode<String> (d, null, null);
		if (d.compareTo (node.data) <= 0)
			node.left = insert (d, node.left);
		else
			node.right = insert (d, node.right);
		return balance (node);
	}

	public String printAreas ( String d )
	{
		if (root == null)
			return null;
		else
			return find (d, root);
	}

	public String find ( String d, BinaryTreeNode<String> node )
	{
		ls = node.data.split("\\D");
		
		String s = ls[0];
		String dx = ls[1];
		String t = ls[2];

		String hold = s + " " + dx + " " + t;

		String temp = "Areas: ";

		String[] dArr = new String[2];
		dArr = d.split("//D");
	
		int cmp = d.compareTo(hold);

		if (cmp == 0)
		{	
			opCount++;
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
			System.out.println("OpCount: " + Count());
			return "";
		}
		else if ((cmp < 0))
		{
			opCount++;
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
			opCount++;
			if (node.right == null) 
				return null; 
			else
			{
				find (d,node.right);
				return "";
			}
		}
	}

	public void printAllAreas()
	{
		preOrder(root);
	}

	public void visit (BinaryTreeNode<String> node)
	{
		System.out.println(node.data);
	}

	public void preOrder()
	{
		preOrder(root);
	}

	public void preOrder( BinaryTreeNode<String> node)
	{
		if (node != null)
		{
			visit(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public int Count()
	{
		return opCount;
	}

}

