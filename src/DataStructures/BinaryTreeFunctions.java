package DataStructures;

public class BinaryTreeFunctions {

	private int diameter = 0;

	public int maxDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = maxDepth(root.left);
		int r = maxDepth(root.right);

		return 1 + Math.max(l, r);
	}

	public int minDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 0;
		}

		int l = Integer.MAX_VALUE;
		int r = Integer.MAX_VALUE;

		if (root.left != null) {
			l = minDepth(root.left);
		}
		if (root.right != null) {
			r = minDepth(root.right);
		}

		return 1 + Math.min(l, r);
	}

	public int getDiameter(BinaryTreeNode root) {
		maxDepthForDiameter(root);
		return diameter;
	}

	private int maxDepthForDiameter(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		int l = maxDepth(root.left);
		int r = maxDepth(root.right);

		diameter = Math.max(diameter, l + r);

		return 1 + Math.max(l, r);
	}

}
