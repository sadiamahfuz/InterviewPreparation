package LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem # 3
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeats {

	public int getLongestSubstring(String s) {
		int result = 0;

		Set<Character> set = new HashSet<Character>();

		StringBuilder current = new StringBuilder();

		for (char c: s.toCharArray()) {
			if (set.contains(c)) {
				// found repeating character
				if (result < current.length()) {
					result = current.length();
				}
				set.clear();
				current.setLength(0);
			}
			set.add(c);
			current.append(c);
		}

		return result;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeats l = new LongestSubstringWithoutRepeats();
		System.out.println(l.getLongestSubstring("abcabcbb"));
		System.out.println(l.getLongestSubstring("bbbbb"));
		System.out.println(l.getLongestSubstring("pwwkew"));
		System.out.println(l.getLongestSubstring("aaabcdefghijklmnopqrstuvwxyzzzz"));
	}
}
