package InterviewCakeProblems;

public class FibonacciNumbers {

	public int fib(int n) {
		// base case
		if (n <= 0) {
			return n;
		}

		int prev1 = 0;
		int prev2 = 1;
		int result = 0;

		int count = 2;

		while (count <= n) {
			result = prev1 + prev2;
			prev1 = prev2;
			prev2 = result;
			count++;
		}

		return result;
	}

	public static void main(String[] args) {
		FibonacciNumbers f = new FibonacciNumbers();
		System.out.println(f.fib(17));

	}

}
