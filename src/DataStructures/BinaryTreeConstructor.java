package DataStructures;

public class BinaryTreeConstructor {

	private int pIndex = 0;

	public BinaryTreeNode getBinaryTree(int[] inorder, int[] preorder) {
		if (inorder.length == 0 || preorder.length == 0) {
			return null;
		}
		if (inorder.length != preorder.length) {
			return null;
		}

		return getBinaryTree(inorder, preorder, 0, preorder.length - 1);
	}

	private BinaryTreeNode getBinaryTree(int[] inorder, int[] preorder, int start, int end) {
		if (start > end) {
			return null;
		}

		int rootValue = preorder[pIndex++];
		BinaryTreeNode root = new BinaryTreeNode(rootValue);

		if (start == end) {
			return root;
		}

		int inorderIndex = findInorderRootIndex(rootValue, inorder, start, end);
		root.left = getBinaryTree(inorder, preorder, start, inorderIndex - 1);
		root.right = getBinaryTree(inorder, preorder, inorderIndex + 1, end);

		return root;

	}

	private int findInorderRootIndex(int rootValue, int[] inorder, int start, int end) {
		if (start > end) {
			return -1;
		}

		for (int i = start; i <= end; i++) {
			if (rootValue == inorder[i]) {
				return i;
			}
		}

		return -1;
	}

}
