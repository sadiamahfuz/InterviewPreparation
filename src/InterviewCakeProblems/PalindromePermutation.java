package InterviewCakeProblems;
/*
 * Write an efficient function that checks whether any permutation
 * of an input string is a palindrome.
 * You can assume the input string only contains lowercase letters.
 *
 * Examples:
 * "civic" should return true
 * "ivicc" should return true
 * "civil" should return false
 * "livci" should return false
 *
 * Answer: Each character must appear a multiple of 2 times.
 * One character is allowed to appear an odd number of times.
 */

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

	public boolean isPalindromePermutation(String s) {
		// Count the number of occurrences of each character
		Set<Character> unpairedCharacters = new HashSet<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (unpairedCharacters.contains(c)) {
				unpairedCharacters.remove(c);
			}
			else {
				unpairedCharacters.add(c);
			}
		}
		return unpairedCharacters.size() <= 1;
	}

	public static void main(String[] args) {
		PalindromePermutation p = new PalindromePermutation();
		System.out.println(p.isPalindromePermutation("civic"));
		System.out.println(p.isPalindromePermutation("civil"));
		System.out.println(p.isPalindromePermutation("ivicc"));
		System.out.println(p.isPalindromePermutation("glenelg"));
	}
}
