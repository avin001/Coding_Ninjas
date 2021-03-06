package binary_trees;

import java.util.Scanner;

import stacks_and_queues.QueueEmptyException;
import stacks_and_queues.QueueUsingLL;

public class CheckIfBinaryTreeIsBalanced {
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner scanner = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data: ");
		int rootData = scanner.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = null;
			try {
				frontNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + frontNode.data + ": ");
			int leftCild = scanner.nextInt();
			if (leftCild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftCild);
				pendingNodes.enqueue(child);
				frontNode.left = child;
			}
			System.out.println("Enter right child of " + frontNode.data + ": ");
			int rightChild = scanner.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				frontNode.right = child;
			}
		}
		return root;
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}
		int levelCount = 0;
		levelCount = Math.max(height(root.left), height(root.right));
		return levelCount + 1;
	}
	
	public static boolean checkBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(height(root.left) - height(root.right)) > 1) {
			return false;
		}
		boolean leftAnswer = checkBalanced(root.left);
		boolean rightAnswer = checkBalanced(root.right);
		return leftAnswer && rightAnswer;
	}
	
	public static void main(String[] args) {
		/*
		 Given a binary tree, check if its balanced i.e. depth of left and right subtrees of every node 
		 differ by at max 1. Return true if given binary tree is balanced, false otherwise. 
		 
		 Input format : 
		 Elements in level order form (separated by space). If any node does not have left or right child, 
		 take -1 in its place. 
		 
		 Sample Input 1 : 
		 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1 
		 
		 Sample Output 1 : 
		 false 
		 
		 Sample Input 2 : 
		 1 2 3 -1 -1 -1 -1 
		 
		 Sample Output 2 : 
		 true
		 */
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		System.out.println(checkBalanced(root));
	}
}
