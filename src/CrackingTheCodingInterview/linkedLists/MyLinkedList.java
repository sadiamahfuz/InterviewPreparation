package linkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class MyLinkedList<T> implements Iterable<T>{

	Node head;
	Node tail;
	int size;

	public MyLinkedList() {
		head  = null;
		size = 0;
	}

	public void add(T value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void append(T value) {
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = null;

	}

	public void removeDuplicates() {
		Set<T> set = new HashSet<T>();

		if (size <= 1) {
			return;
		}

		set.add(head.value);

		Node node = head.next;
		Node previous = head;

		while (node != null) {
			if (set.contains(node.value)) {
				previous.next = node.next;
				size--;
				node = node.next;
			}
			else {
				set.add(node.value);
				node = node.next;
				previous = previous.next;
			}
		}
	}

	public MyLinkedList<T> getKthToLast(int k) {
		MyLinkedList<T> result = new MyLinkedList<T>();
		Stack<T> temp = new Stack<T>();

		if (k >= size) {
			return null;
		}

		Node node = head;
		int index = 0;

		while(node != null) {
			if (index >= k) {
				temp.push(node.value);
			}
			node = node.next;
			index++;
		}

		while(!temp.isEmpty()) {
			result.add(temp.pop());
		}

		return result;
	}


	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node current = head;

		for (int i = 0; i < size; i++) {
			s.append(current.value);
			if (i < size - 1) {
				s.append("->");
			}
			current = current.next;
		}

		return s.toString();
	}


	class Node {
		T value;
		Node next;
	}


	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	public class ListIterator implements Iterator<T> {

		private Node current = head;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T value = current.value;
			current = current.next;
			return value;
		}
	}
}


