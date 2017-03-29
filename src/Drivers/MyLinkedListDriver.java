package Drivers;

import DataStructures.MyLinkedList;

public class MyLinkedListDriver {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList();
		System.out.println(list.toString());

		list.add(1);
		list.add(3);
		list.add(4);

		System.out.println(list.toString());

		list.reverse();

		System.out.println(list.toString());

		list.remove(4);

		System.out.println(list.toString());

		list.add(6);

		list.remove(8);

		System.out.println(list.toString());

		System.out.println(list.contains(7));

		System.out.println(list.contains(3));

	}

}
