package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringMethods {


	public StringMethods() {
	}

	/**
	 * Answer to Question 1.1
	 * @return
	 */
	public boolean isUniqueCharacters(String string) {
		boolean result = true;
		Set<Character> foundCharacters = new HashSet<Character>();

		for (int i = 0; i < string.length(); i++) {
			char found = string.charAt(i);
			if (foundCharacters.contains(found)) {
				result = false;
				break;
			}
			else {
				foundCharacters.add(found);
			}
		}

		return result;
	}

	/**
	 * Answer to Question 1.2
	 * @param another
	 * @return
	 */
	public boolean isPermutation(String string, String another) {

		if (string.length() != another.length()) {
			return false;
		}

		return sort(string).equals(sort(another));
	}


	public String sort(String s) {
		char[] sorted = s.toCharArray();
		Arrays.sort(sorted);

		return new String(sorted);
	}

	/**
	 * Answer to Question 1.3
	 */
	public String replaceSpaces(String original, String sequence) {
		return new String(original.trim().replaceAll("\\s", sequence));
	}
}
