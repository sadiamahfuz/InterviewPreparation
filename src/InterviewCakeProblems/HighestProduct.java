package InterviewCakeProblems;

import java.util.Arrays;

public class HighestProduct {

	public int getHighestProduct(int[] input) {
		Arrays.sort(input);

		int n = input.length;

		// Two possibilities
		int a = input[0] * input[1] * input[n-1];

		int b = input[n-1] * input[n-2] * input[n-3];

		return Math.max(a,b);
	}

	public static void main(String[] args) {
		HighestProduct h = new HighestProduct();
		int[] input = {-10,-10,1,3,2};
		System.out.println(h.getHighestProduct(input));
	}

}
