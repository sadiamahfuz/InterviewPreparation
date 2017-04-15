package DataStructures;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueWithTwoStacks<E> {

	private Stack<E> addStack;
	private Stack<E> removeStack;

	public QueueWithTwoStacks() {
		this.addStack = new Stack<E>();
		this.removeStack = new Stack<E>();
	}

	public void enqueue(E item) {
		addStack.push(item);
	}

	public E dequeue() {
		if (addStack.isEmpty() && removeStack.isEmpty()) {
			throw new EmptyStackException();
		}

		if (removeStack.isEmpty()) {
			while(!addStack.isEmpty()) {
				removeStack.push(addStack.pop());
			}
		}

		return removeStack.pop();
	}

	public boolean isEmpty() {
		return addStack.isEmpty() & removeStack.isEmpty();
	}

	public static void main(String[] args) {
		QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		while (!q.isEmpty()) {
			System.out.print(q.dequeue() + " ");
		}
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);

		while (!q.isEmpty()) {
			System.out.print(q.dequeue() + " ");
		}
	}

}
