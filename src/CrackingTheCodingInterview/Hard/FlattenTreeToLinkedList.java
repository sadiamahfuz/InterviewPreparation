package CrackingTheCodingInterview.Hard;

public class FlattenTreeToLinkedList {

	public static class BiNode {
		public BiNode node1, node2;
		public int data;
		public BiNode(int data) {
			this.data = data;
		}
	}

	public BiNode flatten(BiNode root) {
		if (root == null || (root.node1 == null && root.node2 == null)) {
			return root;
		}




		return root;
	}

	private BiNode convertToCircular(BiNode root) {
		if (root == null) {
			return root;
		}

		BiNode left = convertToCircular(root.node1);
		BiNode right = convertToCircular(root.node2);

		if (left == null && right == null) {
			return null;
		}

		left.node1 = root;
		root.node2 = left;
		root.node1 = right;
		right.node2 = root;

		return left;

	}


	public static void main(String[] args) {


	}

}
