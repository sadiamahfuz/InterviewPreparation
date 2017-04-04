package InterviewCakeProblems;

/*
 * Hooray! It's opposite day. Linked lists go the opposite way today.
 * Write a function for reversing a linked list. Do it in-place.
 *
 * Your function will have one input: the head of the list.
 * Your function should return the new head of the list.
 */
public class LinkedListReverser {

	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	public LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode current = head;

		if (head == null || head.next == null) {
			return head;
		}

		while (current != null) {
			LinkedListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}

	public static void main(String[] args) {

		LinkedListNode a = new LinkedListNode(1);
		LinkedListNode b = new LinkedListNode(2);
		LinkedListNode c = new LinkedListNode(3);

		a.next = b;
		b.next = c;

		LinkedListReverser r = new LinkedListReverser();

		LinkedListNode head = r.reverse(a);

		while (head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println("null");

	}

}
