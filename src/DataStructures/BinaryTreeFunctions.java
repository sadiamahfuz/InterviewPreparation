package DataStructures;

public class BinaryTreeFunctions {

	private int diameter = 0;
	private static BinaryTreeNode prev = null;
	BinaryTreeNode head;

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

	public BinaryTreeNode flattenToDLL(BinaryTreeNode root) {
		BinaryTreeNode head = convertToCircular(root);

		// Break circular connection
		head.left.right = null;
		head.left = null;

		return head;

	}

	private BinaryTreeNode convertToCircular(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}

		BinaryTreeNode left = convertToCircular(root.left);
		BinaryTreeNode right = convertToCircular(root.right);

		if (left == null && right == null) {
			root.left = root;
			root.right = root;
			return root;
		}

		BinaryTreeNode tail = right == null ? null : right.left;

		// join left to root
		if (left == null) {
			join(right.left, root);
		}
		else {
			join(left.left, root);
		}

		// join right to root
		if (right == null) {
			join(root, left);
		}
		else {
			join(root, right);
		}


		// join tail to head
		if (left != null && tail != null) {
			join(tail, left);
		}

		return left == null ? root : left;
	}

	private void join(BinaryTreeNode n1, BinaryTreeNode n2) {
		n1.right = n2;
		n2.left = n1;
	}


	public BinaryTreeNode mergeBST(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}

		// get DLL of two trees
		BinaryTreeNode head1 = flattenToDLL(root1);
		BinaryTreeNode head2 = flattenToDLL(root2);

		// merge the lists
		BinaryTreeNode mergedHead = mergeDLLTrees(head1, head2);

		return sortedListToBST(mergedHead);
	}

	private BinaryTreeNode mergeDLLTrees(BinaryTreeNode head1, BinaryTreeNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		BinaryTreeNode dummy  = new BinaryTreeNode(0);
		BinaryTreeNode tail = dummy;

		while (head1 != null || head2 != null) {
			if (head1 == null) {
				tail.right = head2;
				head2.left = tail;
				head2 = head2.right;
			}
			else if (head2 == null) {
				tail.right = head1;
				head1.left = tail;
				head1 = head1.right;
			}
			else {
				if (head1.value < head2.value) {
					tail.right = head1;
					head1.left = tail;
					head1 = head1.right;
				}
				else {
					tail.right = head2;
					head2.left = tail;
					head2 = head2.right;
				}
			}
			tail = tail.right;
		}

		return dummy.right;
	}


	public BinaryTreeNode sortedListToBST(BinaryTreeNode head) {
		this.head = head;
		int n = numNodes(head);
		return sortedListToBST(n);
	}

	private BinaryTreeNode sortedListToBST(int n) {
		if (n <= 0) {
			return null;
		}

		BinaryTreeNode l = sortedListToBST(n/2);

		BinaryTreeNode root = head;
		root.left = l;

		head = head.right;

		root.right = sortedListToBST(n-(n/2) -1);

		return root;
	}

	private int numNodes(BinaryTreeNode root) {
		BinaryTreeNode temp = root;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.right;
		}
		return count;
	}

}
