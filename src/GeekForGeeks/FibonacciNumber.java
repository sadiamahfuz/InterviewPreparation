package GeekForGeeks;

public class FibonacciNumber {

	public int get(int n) {
		if (n == 0) {
			return 0;
		}

		if (n <= 2) {
			return 1;
		}

		int fib1 = 1;
		int fib2 = 1;
		int count = 2;
		int result = 0;

		while (count < n) {
			result = fib1 + fib2;
			fib2 = fib1;
			fib1 = result;

			count++;
		}
		return result;
	}

	public static void main(String[] args) {
		FibonacciNumber f = new FibonacciNumber();
		System.out.println(f.get(14));
	}


}
