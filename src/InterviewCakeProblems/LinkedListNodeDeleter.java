package InterviewCakeProblems;

public class LinkedListNodeDeleter {

	class LinkedListNode {
		public String value;
		public LinkedListNode next;

		public LinkedListNode(String value) {
			this.value = value;
		}
	}

	public LinkedListNode deleteNode(LinkedListNode head, LinkedListNode node) {
		if (head == null) {
			return null;
		}

		if (head == node) {
			return head.next;
		}

		LinkedListNode prev = head;
		LinkedListNode current = head.next;

		while (current != node) {
			prev = current;
			current = current.next;
		}

		prev.next = current.next;

		return head;

	}

	public static void main(String[] args) {

		LinkedListNodeDeleter l = new LinkedListNodeDeleter();

		LinkedListNode a = l.new LinkedListNode("A");
		LinkedListNode b = l.new LinkedListNode("B");
		LinkedListNode c = l.new LinkedListNode("C");

		a.next = b;
		b.next = c;

		LinkedListNode head = a;


		head = l.deleteNode(head, b);

		LinkedListNode n = head;
		while (n != null) {
			System.out.print(n.value + "->");
			n = n.next;
		}
		System.out.print("null");

	}

}
