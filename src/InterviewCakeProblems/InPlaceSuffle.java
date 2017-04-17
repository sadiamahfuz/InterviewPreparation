package InterviewCakeProblems;

/*
 * Write a function for doing an in-place shuffle of an array.
 * The shuffle must be "uniform," meaning each item in the original array
 * must have the same probability of ending up in each spot in the final array.
 * Assume that you have a function getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
 */

import java.util.Random;

public class InPlaceSuffle {

	public int getRandom(int lo, int hi) {
		Random rand = new Random();
		return rand.nextInt((hi - lo)) + lo;
	}

	public int[] inPlaceShuffle(int[] input) {
		int n = input.length;

		for (int i = 0; i < n; i++) {
			int random = getRandom(i, n);
			int temp = input[random];
			input[random] = input[i];
			input[i] = temp;
		}

		return input;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		InPlaceSuffle i = new InPlaceSuffle();
		int[] result = i.inPlaceShuffle(input);
		for (int number: result) {
			System.out.print(number + " ");
		}
	}

}
