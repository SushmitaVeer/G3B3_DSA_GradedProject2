package com.greatlearning.graded2.question2.service;

public class RightSkewedTree {
	public TreeNode node;

	// Function to perform right rotation on tree
	private TreeNode rightRotate(TreeNode x) {

		if (x == null || x.left == null) {
			return x;
		}

		TreeNode y = x.left;
		TreeNode T2 = y.right;
		y.right = x;
		x.left = T2;
		return y;

	}

	// Function to convert BST to skewed tree
	public TreeNode convertToRightSkewedTree(TreeNode root) {
		// Base case
		if (root == null) {
			return null;
		}

		// Recursively convert the left subtree
		root.left = convertToRightSkewedTree(root.left);

		// Perform right rotation until the tree becomes skewed
		root = rightRotate(root);

		return root;
	}

	// Function to print the right-skewed binary tree in ascending order
	public void printAscendingOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		// Traverse the left subtree
		printAscendingOrder(root.left);

		// Print the current node
		System.out.print(root.data + " ");

		// Move to the right subtree
		printAscendingOrder(root.right);
	}
}
