package LeetcodeProblems;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem #1
 *
 * Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */

public class TwoSum {

	public int[] getIndices(int[] numbers, int sum) {
		int[] indices = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(numbers[0], 0);

		for (int i = 0; i < numbers.length; i++) {
			int target = sum - numbers[i];
			if (map.containsKey(target)) {
				indices[0] = map.get(target);
				indices[1] = i;
				break;
			}
			map.put(numbers[i], i);
		}
		return indices;
	}

	public static void main(String[] args) {
		TwoSum t = new TwoSum();

		int[] a = {2, 3, 5, 6, 11, 15};

		int[] result = t.getIndices(a, 9);
		System.out.println(result[0] + " " + result[1]);
	}

}
