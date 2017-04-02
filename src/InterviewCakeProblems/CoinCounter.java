package InterviewCakeProblems;

/*
 * You quirky boss collects rare, old coins...
 * They found out you're a programmer and asked you to solve something
 * they've been wondering for a long time.
 *
 * Write a function that, given:
 * 		an amount of money
 * 		an array of coin denominations
 * computes the number of ways to make the amount of money
 * with coins of the available denominations.
 *
 * Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢),
 * your program would output 4 —the number of ways to make 4¢ with those denominations:
 * 		1¢, 1¢, 1¢, 1¢
 * 		1¢, 1¢, 2¢
 * 		1¢, 3¢
 * 		2¢, 2¢
 */

public class CoinCounter {

	public int countWays(int amount, int[] denominations) {
		int n = denominations.length;
		int[][] result = new int[amount+1][n];

		// first row is 0, amount is 0
		for (int i = 0; i < n; i++) {
			result[0][i] = 1;
		}

		for (int i = 1; i < amount + 1; i++) {
			for (int j = 0; j < n; j++) {
				int x = 0;
				int y = 0;
				if (i >= denominations[j]) {
					x = result[i - denominations[j]][j];
				}
				if (j >= 1) {
					y = result[i][j-1];
				}
				result[i][j] = x + y;
			}
		}

		return result[amount][n-1];
	}

	public static void main(String[] args) {
		CoinCounter c = new CoinCounter();
		System.out.println(c.countWays(100, new int[] {1, 3, 5}));

	}

}
