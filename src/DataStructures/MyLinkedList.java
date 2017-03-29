package DataStructures;

public class MyLinkedList<E> {

	private Node head;
	private int size;

	class Node {
		E val;
		Node next;
		public Node(E val) {
			this.val = val;
		}
	}

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	public void add(E val) {
		Node node = new Node(val);
		node.next = head;
		head = node;

		size++;
	}

	public void reverse() {
		if (head == null) {
			return;
		}

		Node prev = null;
		Node current = head;

		while (current.next != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		current.next = prev;

		head = current;
	}

	public boolean contains(E val) {
		Node current = head;
		while (current != null) {
			if (current.val.equals(val)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean remove(E val) {
		if (head == null) {
			return false;
		}
		if (head.val.equals(val)) {
			head = head.next;
			size--;
			return true;
		}

		Node prev = head;
		Node current = head.next;

		while (current != null) {
			if (current.val.equals(val)) {
				prev.next = current.next;
				size--;
				return true;
			}
			prev = prev.next;
			current = current.next;
		}

		return false;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

}
