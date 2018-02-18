package trees;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
	
	public Node root;
	
	public Node find(int key)
	{
		Node current = root;
		while (current != null)
		{
			if (key < current.key)
			{
				current = current.childLeft;
			}
			else if(key > current.key)
			{
				current = current.childRight;
			} 
			else
			{
				break;
			}
		}
		
		return current;
	}
	
	public int findMin()
	{
		Node current = root;
		while (current != null)
		{
			if (current.childLeft == null)
			{
				break;
			}
			
			current = current.childLeft;
		}
		
		return current.key;
	}
	
	public void BreadthFirst()
	{
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			Node n = q.poll();
			System.out.print(n.key + ", ");
			
			if (n.childLeft != null)
				q.add(n.childLeft);
			if (n.childRight != null)
				q.add(n.childRight);
		}
	}
	
	public void DepthFirst()
	{
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(root);
		
		while (!stack.isEmpty())
		{
			Node n = stack.pop();
			System.out.print(n.key + ", ");
			
			if (n.childLeft != null)
				stack.push(n.childLeft);
			if (n.childRight != null)
				stack.push(n.childRight);
		}
	}
	
	public int findMax()
	{
		Node current = root;
		while (current != null)
		{
			if (current.childRight == null)
			{
				break;
			}
			
			current = current.childRight;
		}
		
		return current.key;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	private Node getSuccessor(Node node)
	{
		Node successorParent = node;
		Node successor = node;
		Node current = node.childRight;

		while (current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.childLeft;
		}
		
		if (successor != node.childRight)
		{
			successorParent.childLeft = successor.childRight;
			successor.childRight = node.childRight;
		}
		 
		return successor;
	}
	
	public boolean isEmpty()
	{
		return (root == null);
	}
	
	public void inOrderRecursiveTraversal(Node node)
	{
		if (node == null) return;
		
		inOrderRecursiveTraversal(node.childLeft);
		node.display();
		inOrderRecursiveTraversal(node.childRight);
	}
	
	public void preOrderRecursiveTraversal(Node node)
	{
		if (node == null) return;
		
		node.display();
		preOrderRecursiveTraversal(node.childLeft);
		preOrderRecursiveTraversal(node.childRight);
	}
	
	public void postOrderRecursiveTraversal(Node node)
	{
		if (node == null) return;
		
		postOrderRecursiveTraversal(node.childLeft);
		postOrderRecursiveTraversal(node.childRight);
		node.display();
	}
	
	public void insert(int key)
	{
		insertIterative(key);
	}
	
	private void insertIterative(int key)
	{
		Node insertNode = new Node(key);
		
		if (isEmpty()) 
		{
			root = insertNode;
			return;
		}
		
		Node current = root;
		
		while (true)
		{
			if (key < current.key)
			{
				if (current.childLeft == null)
				{
					current.childLeft = insertNode;
					break;
				}
				current = current.childLeft;
			}
			else
			{
				if (current.childRight == null)
				{
					current.childRight = insertNode;
					break;
				}
				current = current.childRight;
			}
		}
	}
	
	public boolean remove(int key)
	{
		Node current = root;
		Node parent = null;
		boolean isLeftChild = false;
			
		while (current.key != key)
		{
			parent = current;
			if (key < current.key)
			{
				isLeftChild = true;
				current = current.childLeft;
			}
			else
			{   
				isLeftChild = false;
				current = current.childRight;
			}
			
			if (current == null)
				return false;
		}

		if (current.childLeft == null && current.childRight == null)
		{
			if (current == root)
			{
				root = null;
			}
			else if (isLeftChild)
			{
				parent.childLeft = null;
			}
			else
			{
				parent.childRight = null;
			}
		}
		else if (current.childRight == null)
		{
			if (current == root)
			{
				root = current.childLeft;
			}
			else if (isLeftChild)
			{
				parent.childLeft = current.childLeft;
			} 
			else
			{
				parent.childRight = current.childLeft;
			}
		}
		else if (current.childLeft == null)
		{
			if (current == root)
			{
				root = current.childRight;
			}
			else if (isLeftChild)
			{
				parent.childLeft = current.childRight;
			} 
			else
			{
				parent.childRight = current.childRight;
			}
		}
		else
		{
			Node successor = getSuccessor(current);
			
			if (current == root)
			{
				root = successor;
			}
			else if (isLeftChild)
			{
				parent.childLeft = successor;
			}
			else
			{
				parent.childRight = successor;
				successor.childLeft = current.childLeft;
			}
		}
		
		return true;
	}
}
