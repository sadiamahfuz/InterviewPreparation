package DataStructures;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] inorder = {1, 3, 4, 5, 6, 7, 8, 9, 11, 12};
		int[] preorder = {5, 3, 1, 4, 8, 7, 6, 9, 12, 11};

		BinaryTreeConstructor b = new BinaryTreeConstructor();

		BinaryTreeNode root = b.getBinaryTree(inorder, preorder);
		BinaryTreeTraversals bt = new BinaryTreeTraversals();
		List<Integer> list = bt.postOrder(root);

		for (int v: list) {
			System.out.print(v + " ");
		}

	}

}
