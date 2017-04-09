package InterviewCakeProblems;

public class ValidBSTChecker {

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


	public boolean isValid(BinaryTreeNode root) {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(BinaryTreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.value < min || node.value > max) {
			return false;
		}

		return isValid(node.left, min, node.value) & isValid(node.right, node.value, max);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(4);
		BinaryTreeNode left1 =  root.insertLeft(2);
		BinaryTreeNode right1 =  root.insertRight(7);
		BinaryTreeNode left2 =  left1.insertLeft(1);
		BinaryTreeNode left3 =  left1.insertRight(3);
		//BinaryTreeNode left4 =  left2.insertLeft(8);

		ValidBSTChecker v = new ValidBSTChecker();
		System.out.println(v.isValid(root));

	}

}
