package DataStructures;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MaxStack {

	private Stack<Integer> stack;
	private Stack<Integer> maxStack;

	public MaxStack() {
		stack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public int getMax() {
		return maxStack.peek();
	}

	public void push(int number) {
		if (maxStack.isEmpty() || number >= maxStack.peek()) {
			maxStack.push(number);
		}
		stack.push(number);
	}

	public int pop() {
		if (stack.isEmpty()) {
			throw new NoSuchElementException();
		}
		// remove old max
		int value = stack.pop();
		if (maxStack.peek() == value) {
			maxStack.pop();
		}

		return value;
	}

	public static void main(String[] args) {
		MaxStack m = new MaxStack();
		m.push(4);
		m.push(3);
		m.push(2);
		m.push(6);

		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());
		m.push(1);
		System.out.println(m.getMax());
		m.push(7);
		m.push(7);
		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());

	}

}
