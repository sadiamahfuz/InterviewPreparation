package InterviewCakeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * You're working with an intern that keeps coming to you with JavaScript code
 * that won't run because the braces, brackets, and parentheses are off.
 * To save you both some time, you decide to write a braces/brackets/parentheses validator.
 *
 * Let's say:
 * '(', '{', '[' are called "openers."
 * )', '}', ']' are called "closers."
 * Write an efficient function that tells us whether or not an input string's openers
 * and closers are properly nested.
 *
 * Examples:
 * "{ [ ] ( ) }" should return True
 * "{ [ ( ] ) }" should return False
 * "{ [ }" should return False
 *
 *
 */

public class ParathesesBalancer {

	public boolean isBalanced(String s) {

		if (s == null || s.isEmpty()) {
			return true;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isOpening(c)) {
				stack.push(c);
			}
			else if (isClosing(c)) {
				if (!stack.isEmpty()) {
					char open = stack.pop();
					if (c != map.get(open)) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private boolean isOpening(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	private boolean isClosing(char c) {
		return c == ')' || c == '}' || c == ']';
	}

	public static void main(String[] args) {
		ParathesesBalancer p = new ParathesesBalancer();
		System.out.println(p.isBalanced("{ [ ] ( ) }"));
		System.out.println(p.isBalanced("{ [ ( ] ) }"));
		System.out.println(p.isBalanced("{ [ }"));

	}

}
