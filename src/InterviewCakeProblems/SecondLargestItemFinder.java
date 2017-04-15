package InterviewCakeProblems;

public class SecondLargestItemFinder {

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

	public int getSecondLargest(BinaryTreeNode root) {

		if (root == null) {
			throw new IllegalArgumentException();
		}

		if (root.left == null && root.right == null) {
			throw new IllegalArgumentException();
		}

		BinaryTreeNode prevRight = root.left;
		BinaryTreeNode current = root;

		while (current != null) {
			if (current.right == null && current.left == null) {
				return prevRight.value;
			}
			else if (current.right == null) {
				return current.left.value;
			}

			prevRight = current;
			current = current.right;
		}

		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root = new BinaryTreeNode(4);
		BinaryTreeNode left1 =  root.insertLeft(2);
		BinaryTreeNode right1 =  root.insertRight(7);
		BinaryTreeNode left2 =  left1.insertLeft(1);
		BinaryTreeNode left3 =  left1.insertRight(3);
		BinaryTreeNode right2 =  right1.insertRight(9);
		BinaryTreeNode right3 =  right1.insertLeft(6);
		BinaryTreeNode right4 =  right2.insertLeft(8);

		SecondLargestItemFinder s = new SecondLargestItemFinder();
		System.out.println(s.getSecondLargest(root));
	}

}
