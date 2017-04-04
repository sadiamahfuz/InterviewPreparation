package InterviewCakeProblems;


/*
 * You have a singly-linked list and want to check if it contains a cycle.
 * A singly-linked list is built with nodes, where each node has:
 *
 * node.next—the next node in the list.
 * node.value—the data held in the node.
 *
 * For example, if our linked list stores people in line at the movies,
 * node.value might be the person's name.
 *
 * A cycle occurs when a node’s next points back to a previous node in the list.
 * The linked list is no longer linear with a beginning and end—instead, it cycles
 * through a loop of nodes.
 *
 * Write a function containsCycle() that takes the first node in a singly-linked list
 * and returns a boolean indicating whether the list contains a cycle.
 */
public class LinkedListCycleDetector {

	public static class LinkedListNode {
		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}
	}

	public boolean containsCycle(LinkedListNode head) {

		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
