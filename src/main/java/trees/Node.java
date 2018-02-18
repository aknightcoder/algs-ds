package trees;

public class Node {
	public int key;
	public Node childLeft;
	public Node childRight;

	public Node(int nodeKey)
	{
		key = nodeKey;
	}
	
	public void display()
	{
		System.out.print(key + ", ");
	}

	public boolean hasChildren() 
	{
		return (childLeft != null && childRight != null);
	}
}
