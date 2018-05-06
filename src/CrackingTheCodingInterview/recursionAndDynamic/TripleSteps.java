package recursionAndDynamic;

public class TripleSteps {

	public static int count_recursion(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		return count_recursion(n-1) + count_recursion(n-2) + count_recursion(n-3);
	}

	public static int count_dynamic(int n) {
		int[] counts = new int[n+1];
		counts[0] = 1;
		counts[1] = 1;
		counts[2] = 2;
		counts[3] = 4;

		for (int i = 4; i < n+1; i++) {
			counts[i] = counts[i-1] + counts[i-2] + counts[i-3];
		}

		return counts[n];
	}

	public static void main(String[] args) {
		System.out.println(count_dynamic(25));

	}

}
