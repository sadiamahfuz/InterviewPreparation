package InterviewCakeProblems;

/*
 * I like parentheticals (a lot).
 * "Sometimes (when I nest them (my parentheticals) too much
 * (like this (and this))) they get confusing."
 *
 * Write a function that, given a sentence like the one above,
 * along with the position of an opening parenthesis,
 * finds the corresponding closing parenthesis.
 *
 * Example: if the example string above is input with the number 10
 * (position of the first parenthesis), the output should be 79
 * (position of the last parenthesis).
 */
public class ParanthesesMatcher {

	public int getMatchingIndex(String s, int openIndex) {
		if (s.length() < openIndex || s.charAt(openIndex) != '(') {
			throw new IllegalArgumentException();
		}

		int openCount = 0;
		for (int i = openIndex + 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (openCount == 0) {
					return i;
				}
				else {
					openCount--;
				}
			}
			else if (s.charAt(i) == '(') {
				openCount++;
			}
		}

		throw new IllegalArgumentException("No Matching closing bracket found");
	}

	public static void main(String[] args) {
		ParanthesesMatcher p = new ParanthesesMatcher();
		System.out.println(p.getMatchingIndex("Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.", 10));

	}

}
