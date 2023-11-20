package com.greatlearning.graded2.question2.driver;

import com.greatlearning.graded2.question2.service.RightSkewedTree;
import com.greatlearning.graded2.question2.service.TreeNode;

public class BSTMain {

	public static void main(String[] args) {
		RightSkewedTree tree = new RightSkewedTree();
		tree.node = new TreeNode(50);
		tree.node.left = new TreeNode(30);
		tree.node.right = new TreeNode(60);
		tree.node.left.left = new TreeNode(10);
		tree.node.right.left = new TreeNode(55);

		// Convert the complete binary tree to right-skewed binary tree
		tree.node = tree.convertToRightSkewedTree(tree.node);

		// Display the node values in ascending order
		tree.printAscendingOrder(tree.node);
	}

}
