package trees;

public class BinarySearchTree {

	private BinarySearchNode root;

	public int count;
	
	public BinarySearchNode getRoot()
	{
		return root;
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	public BinarySearchNode find(long key)
	{
		BinarySearchNode currentNode = root;

		while (currentNode != null)
		{
			if (key < currentNode.key) 
				currentNode = currentNode.childLeft;
			else if (key > currentNode.key)
				currentNode = currentNode.childRight;
			else if (currentNode.key == key)
				return currentNode;
		}
		
		return null;
	}
	
	public long floor(long key)
	{
		BinarySearchNode node = floor(root, key);

		if (node == null) return -1;

		return node.key;
	}
	
	private BinarySearchNode floor(BinarySearchNode node, long key)
	{
		if (node == null) return null;
		
		if (key == node.key) return node;
		
		if (key < node.key)
			return floor(node.childLeft, key);
			
		BinarySearchNode node2 = floor(node.childRight, key);
		
		if (node2 != null) 
			return node2;
		else
			return node;
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(BinarySearchNode node)
	{
		if (node == null) return 0;
		return node.count;
	}
	
	public int rank(long key)
	{
		return rank(root, key);
	}
	
	public void inorder(BinarySearchNode node)
	{
		if (node == null) return;
		inorder(node.childLeft);
		System.out.print(node.key + ", ");
		inorder(node.childRight);
	}
	
	public void preorder(BinarySearchNode node)
	{
		if (node == null) return;
		System.out.print(node.key + ", ");
		preorder(node.childLeft);
		preorder(node.childRight);
	}
	
	public void postorder(BinarySearchNode node)
	{
		if (node == null) return;

		postorder(node.childLeft);
		postorder(node.childRight);
		System.out.print(node.key + ", ");
	}

	private int rank(BinarySearchNode node, long key)
	{
		if (node == null) return 0;
		if (key < node.key) return rank(node.childLeft, key);
		else if (key > node.key) return 1 + size(node.childLeft) + rank(node.childRight, key);
		else return size(node.childLeft);
	}
	
	private BinarySearchNode insert(BinarySearchNode current, long key)
	{
		if (current == null) return new BinarySearchNode(key);
		
		if (key < current.key)
			current.childLeft = insert(current.childLeft, key);
		else
			current.childRight = insert(current.childRight, key);

		current.count = 1 + size(current.childLeft) + size(current.childRight);
		
		return current;
	}
	
	public void insertNonRecursive(long key)
	{
        BinarySearchNode newNode = new BinarySearchNode(key);
        
        if (root == null)
        {
        	root = newNode;
        	return;
        }
        
        BinarySearchNode currentNode = root;
		while (currentNode != null)
		{
			BinarySearchNode parentNode = currentNode;
		    if (key < parentNode.key)
		    {
		    	if (parentNode.childLeft == null)
		    	{
		    		parentNode.childLeft = newNode;
		    		break;
		    	}

		    	currentNode = parentNode.childLeft;
		    }
			else if (key > parentNode.key)
		    {
			  	if (parentNode.childRight == null)
			  	{
		    		parentNode.childRight = newNode;
		    		break;
		    	}
		    	
			  	currentNode = parentNode.childRight;
		    }
		}
	}
	
	public void insert(long key)
	{
		root = insert(root, key);
	}
}
