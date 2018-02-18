package trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void binarySearchTree() {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		
		binarySearchTree.insert(40);
		binarySearchTree.insert(25);
		binarySearchTree.insert(78);
		binarySearchTree.insert(10);
		binarySearchTree.insert(32);
	
		BinarySearchNode theNode = binarySearchTree.find(10);
		assertEquals(theNode.key, 10);
		BinarySearchNode root = binarySearchTree.getRoot();
		System.out.println("Inorder:");
		binarySearchTree.inorder(root);
		System.out.println("\nPreorder:");
		binarySearchTree.preorder(root);
		System.out.println("\nPost order:");
		binarySearchTree.postorder(root);
	}
}
