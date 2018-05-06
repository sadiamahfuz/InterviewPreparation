package CrackingTheCodingInterview.linkedLists;

import java.util.Iterator;

public class MyIntegerLinkedList {

	MyLinkedList<Integer> list = new MyLinkedList<Integer>();

	public MyIntegerLinkedList() {
	}

	public void add(int value) {
		list.add(value);
	}

	public int getNumericValueReverse() {
		int result = 0;
		int power = 0;
		Iterator<Integer> iterator = list.iterator();

		while(iterator.hasNext()) {
			result += (iterator.next() * Math.pow(10, power));
			power++;
		}

		return result;
	}

	public int getNumericValue() {
		int result = 0;
		int power = this.size() - 1;
		Iterator<Integer> iterator = list.iterator();

		while(iterator.hasNext()) {
			result += (iterator.next() * Math.pow(10, power));
			power--;
		}

		return result;
	}

	public int size() {
		return list.size;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
