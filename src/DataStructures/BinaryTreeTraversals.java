package DataStructures;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {

	public List<Integer> levelOrder(BinaryTreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}

		Queue<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.remove();
			list.add(node.value);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return list;
	}

	public List<Integer> postOrder(BinaryTreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = root;
		stack.push(current);

		while (!stack.isEmpty()) {
			current = stack.peek();
			if (current.left == null && current.right == null) {
				list.add(current.value);
				stack.pop();
			}
			if (current.right != null) {
				stack.push(current.right);
				current.right = null;
			}
			if (current.left != null) {
				stack.push(current.left);
				current.left = null;
			}

		}
		return list;
	}


	public List<Integer> zigzagOrder(BinaryTreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<BinaryTreeNode> lr = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> rl = new Stack<BinaryTreeNode>();
		boolean rTol = false;
		lr.add(root);

		while (!lr.isEmpty() || !rl.isEmpty()) {
			if (!rTol) {
				while (!lr.isEmpty()) {
					BinaryTreeNode node = lr.pop();
					list.add(node.value);
					if (node.left != null) {
						rl.push(node.left);
					}
					if (node.right != null) {
						rl.push(node.right);
					}
				}
			}
			else {
				while (!rl.isEmpty()) {
					BinaryTreeNode node = rl.pop();
					list.add(node.value);
					if (node.right != null) {
						lr.push(node.right);
					}
					if (node.left != null) {
						lr.push(node.left);
					}
				}
			}
			rTol = !rTol;
		}
		return list;
	}

}
