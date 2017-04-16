package InterviewCakeProblems;

import java.util.HashSet;
import java.util.Set;

/*
 * Write a recursive function for generating all permutations of an input string.
 * Return them as a set.
 * Don't worry about time or space complexity — if we wanted efficiency
 * we'd write an iterative version.
 *
 * To start, assume every character in the input string is unique.
 * Your function can have loops — it just needs to also be recursive
 */
public class StringPermutations {

	public Set<String> getAllPermutations(String input) {
		Set<String> result = new HashSet<String>();

		// base case
		if (input.length() <= 1) {
			result.add(input);
			return result;
		}

		char lastChar = input.charAt(input.length() - 1);
		String inputWithoutLast = input.substring(0, input.length() - 1);

		Set<String> permutationsWithoutLast = getAllPermutations(inputWithoutLast);

		for (String perm: permutationsWithoutLast) {
			for (int i = 0; i <= inputWithoutLast.length(); i++) {
				String permutation = perm.substring(0, i) + lastChar + perm.substring(i);
				result.add(permutation);
			}
		}

		return result;
	}


	public static void main(String[] args) {
		StringPermutations s = new StringPermutations();
		Set<String> perm = s.getAllPermutations("cats");
		for (String p : perm) {
			System.out.println(p);
		}

	}

}
