package DataStructures;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		int[] inorder = {1, 3, 4, 5, 6, 7, 8, 9, 11, 12};
		int[] preorder = {5, 3, 1, 4, 8, 7, 6, 9, 12, 11};

		BinaryTreeConstructor b = new BinaryTreeConstructor();

		BinaryTreeNode root = b.getBinaryTree(inorder, preorder);
		BinaryTreeFunctions bf = new BinaryTreeFunctions();

		BinaryTreeTraversals bt = new BinaryTreeTraversals();
		/*List<Integer> list = bt.postOrder(root);

		for (int v: list) {
			System.out.print(v + " ");
		}
		System.out.println();



		list = bt.levelOrder(root);

		for (int v: list) {
			System.out.print(v + " ");
		}*/

		//System.out.println(bf.maxDepth(root));
		//System.out.println(bf.minDepth(root));
		//System.out.println(bf.getDiameter(root));


		/*BinaryTreeNode current = bf.flattenToDLL(root);
		while(current != null) {
			System.out.print(current.value + "<->");
			current = current.right;
		}
		System.out.println("null");*/



		int[] inorder1 = {2, 10, 13, 15, 17};
		int[] preorder1 = {10, 2, 15, 13, 17};

		BinaryTreeConstructor b1 = new BinaryTreeConstructor();
		BinaryTreeNode root1 = b1.getBinaryTree(inorder1, preorder1);
		/*BinaryTreeNode current1 = bf.flattenToDLL(root1);
		while(current1 != null) {
			System.out.print(current1.value + "<->");
			current1 = current1.right;
		}
		System.out.println("null");*/

		BinaryTreeNode res = bf.mergeBST(root, root1);
		/*while(res != null) {
			System.out.print(res.value + "<->");
			res = res.right;
		}
		System.out.println("null");*/
		List<Integer> list = bt.levelOrder(res);
		for (int v: list) {
			System.out.print(v + " ");
		}
	}

}
