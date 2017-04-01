package DataStructures;

public class StackUsingLinkedList<E> {

	class Node {
		int value;
		Node next;

		public Node(int val) {
			this.value = val;
		}
	}

	private int size = 0;

	public StackUsingLinkedList() {

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
