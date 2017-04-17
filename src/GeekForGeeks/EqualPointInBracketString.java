package GeekForGeeks;

/*
 * Given a string S of brackets, the task is to find an index k which decides
 * the number of opening brackets is equal to the number of closing brackets.
 * String must be consists of only opening and closing brackets i.e. ‘(‘ and ‘)’.
 * An equal point is an index such that the number of opening brackets before it
 * is equal to the number of closing brackets from and after.
 */
public class EqualPointInBracketString {

	public int findEqualPoint(String brackets) {
		// find total number of  open and closing brackets
		int numOpen = 0;
		int numClosed = 0;

		for (char c: brackets.toCharArray()) {
			if (c == '(') {
				numOpen++;
			}
		}

		numClosed = brackets.length() - numOpen;

		// Now find K
		int openLeft = 0;
		int closedRight = numClosed;

		int i = 0;
		for (i = 0; i < brackets.length(); i++) {
			if (openLeft == closedRight) {
				break;
			}
			char c = brackets.charAt(i);
			if (c == '(') {
				openLeft++;
			}
			else {
				closedRight--;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		EqualPointInBracketString e = new EqualPointInBracketString();
		String S = "))";

		System.out.println(e.findEqualPoint(S));

	}

}
