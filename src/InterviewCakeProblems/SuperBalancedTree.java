package InterviewCakeProblems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;


/*
 * Write a function to see if a binary tree is "superbalanced"
 * (a new tree property we just made up).
 *
 * A tree is "superbalanced" if the difference between the depths of
 * any two leaf nodes is no greater than one.
 */
public class SuperBalancedTree {

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
	}

	public boolean isSuperBalanced(BinaryTreeNode root) {

		if (root == null) {
			return true;
		}

		if (root.left == null && root.right == null) {
			return true;
		}

		Set<Integer> depths = new HashSet<Integer>();

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		if (root.right != null) {
			stack.add(root.right);
		}
		if (root.left != null) {
			stack.add(root.left);
		}

		int depth = 0;
		while (!stack.isEmpty()) {
			BinaryTreeNode node = stack.pop();
			depth++;

			if (node.left == null && node.right == null) {
				//leaf
				depths.add(depth);
				depth = 0;
			}

			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}

		if (depths.size() > 2) {
			return false;
		}

		if (depths.size() == 2) {
			Iterator<Integer> it = depths.iterator();
			int depth1 = it.next();
			int depth2 = it.next();
			return Math.abs(depth1 - depth2) <= 1;
		}

		return true;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(4);
		BinaryTreeNode left1 =  root.insertLeft(2);
		BinaryTreeNode right1 =  root.insertRight(7);
		BinaryTreeNode left2 =  left1.insertLeft(1);
		BinaryTreeNode left3 =  left1.insertRight(3);
		//BinaryTreeNode left4 =  left2.insertLeft(0);

		SuperBalancedTree s = new SuperBalancedTree();

		System.out.println(s.isSuperBalanced(root));
	}

}
