package LeetcodeProblems;
/*
 * Problem # 2
 * Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	public Node add(Node l1, Node l2) {
		Node head = null;

		if (l1 == null && l2 == null) {
			return head;
		}

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		int carry = 0;
		Node current = null;

		while (l1 != null || l2 != null) {

			int sum = carry;

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;

			Node result = new Node(sum % 10);
			if (head == null) {
				current = result;
				head = current;
			}
			else {
				current.next = result;
				current = current.next;
			}

		}

		if (carry > 0) {
			current.next = new Node(carry);
			current = current.next;
		}

		current.next = null;

		return head;
	}



	public static void main(String[] args) {
		AddTwoNumbers a = new AddTwoNumbers();

		Node l1 = a.new Node(2);
		l1.next = a.new Node(4);
		l1.next.next = a.new Node(7);
		l1.next.next.next = null;

		Node l2 = a.new Node(5);
		l2.next = a.new Node(6);
		l2.next.next = a.new Node(4);
		l2.next.next.next = a.new Node(9);
		l2.next.next.next.next = null;
		Node res = a.add(l1, l2);

		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}


	}

}
