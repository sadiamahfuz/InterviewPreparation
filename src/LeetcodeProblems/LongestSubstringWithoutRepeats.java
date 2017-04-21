package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

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

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c));
			}
			result = Math.max(result, i + 1 - j);
			map.put(c, i + 1);
		}

		return result;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeats l = new LongestSubstringWithoutRepeats();
		System.out.println(l.getLongestSubstring("abcabcbb"));
		System.out.println(l.getLongestSubstring("bbbbb"));
		System.out.println(l.getLongestSubstring("pwwkew"));
		System.out.println(l.getLongestSubstring("dvdf"));
		System.out.println(l.getLongestSubstring("abcadefg"));
	}
}
