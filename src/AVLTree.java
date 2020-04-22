public class AVLTree
{

	public BinaryTreeNode<String> root; 

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

	public BinaryTreeNode<String> find ( String d )
	{
		if (root == null)
			return null;
		else
			return find (d, root);
	}

	public BinaryTreeNode<String> find ( String d, BinaryTreeNode<String> node )
	{
		if (d.compareTo (node.data) == 0) 
			return node;
		else if (d.compareTo (node.data) < 0)
			return (node.left == null) ? null : find (d, node.left);
		else
			return (node.right == null) ? null : find (d, node.right);
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
}

