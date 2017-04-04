package InterviewCakeProblems;

/*
 * You have a linked list and want to find the kkth to last node.
 *
 * Write a function kthToLastNode() that takes an integer k
 * and the headNode of a singly linked list,
 * and returns the kth to last node in the list.
 *
 */
public class LinkedListKthFromLastFinder {

	public static class LinkedListNode {

		public String value;
		public LinkedListNode next;

		public LinkedListNode(String value) {
			this.value = value;
		}
	}

	public LinkedListNode getKthToLastNode(int k, LinkedListNode head) {
		LinkedListNode first = head;
		LinkedListNode second = head;

		int count = 0;
		while (count < k && first != null) {
			first = first.next;
			count++;
		}


		if (count < k && first == null) {
			throw new IllegalArgumentException("K cannot be larger than length of list.");
		}

		while (first != null) {
			second = second.next;
			first = first.next;
		}

		return second;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedListNode a = new LinkedListNode("Angel Food");
		LinkedListNode b = new LinkedListNode("Bundt");
		LinkedListNode c = new LinkedListNode("Cheese");
		LinkedListNode d = new LinkedListNode("Devil's Food");
		LinkedListNode e = new LinkedListNode("Eccles");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		LinkedListKthFromLastFinder l = new LinkedListKthFromLastFinder();
		LinkedListNode n = l.getKthToLastNode(3, a);
		System.out.println((n == null) ? "null" : n.value);

	}

}
