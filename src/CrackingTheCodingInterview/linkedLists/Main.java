package CrackingTheCodingInterview.linkedLists;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(2);
		list.add(7);
		list.add(1);
		list.add(2);

		System.out.println(list.toString());

		list.removeDuplicates();

		System.out.println(list.toString());

		System.out.println(list.getKthToLast(2).toString());


		MyIntegerLinkedList intList = new MyIntegerLinkedList();
		intList.add(6);
		intList.add(9);
		intList.add(1);

		System.out.println(intList.toString());
		System.out.println(intList.getNumericValue
				());
		System.out.println(intList.getNumericValueReverse());

	}

}
