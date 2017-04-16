package InterviewCakeProblems;

/*
 * I have an array where every number in the range 1...n appears once
 * except for one number which appears twice.
 * Write a function for finding the number that appears twice.
 */
public class OneDuplicate {

	public int findDuplicate(int[] input) {
		int n = input.length;
		int sum1toN = n * (n-1) / 2;

		int sum = 0;
		for (int i: input) {
			sum += i;
		}

		return sum - sum1toN;
	}

	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,1,4};
		OneDuplicate o = new OneDuplicate();
		System.out.println(o.findDuplicate(input));
	}

}
