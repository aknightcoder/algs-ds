package trees;

public class BinarySearchNode {

	public long key;

	public int count;

	public BinarySearchNode childLeft;

	public BinarySearchNode childRight;

	public BinarySearchNode(long theKey)
	{
		key = theKey;
	}
	
	public void display()
	{
        System.out.println("Key: " + key + ", Left " + childLeft + ", Right: " + childRight);
	}
}
