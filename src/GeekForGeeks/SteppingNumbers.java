package GeekForGeeks;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * A number is called stepping number if all adjacent digits have an absolute difference
 * of 1,
 * e.g. '321' is a Stepping Number while 421 is not.
 * Given two integers n and m, find the count of all the stepping numbers in range [n, m].
 *
 * Input : n = 0, m = 21
 * Output : 13
 * Stepping no's are 0 1 2 3 4 5 6 7 8 9 10 12 21
 *
 * Input : n = 10, m = 15
 * Output : 2
 * Stepping no's are 10, 12
 *
 */
public class SteppingNumbers {

	private List<Integer> result = new LinkedList<Integer>();

	private void bfs(int n, int m, int num) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(num);

		while (!queue.isEmpty()) {
			int current = queue.remove();

			if (current >= n && current <= m) {
				result.add(current);
			}

			if (current == 0 || current > m) {
				continue;
			}

			int lastDigit = current % 10;
			int next1 = current * 10 + (lastDigit + 1);
			int next2 = current * 10 + (lastDigit - 1);

			if (lastDigit == 0) {
				queue.add(next1);
			}
			else if (lastDigit == 9) {
				queue.add(next2);
			}
			else {
				queue.add(next1);
				queue.add(next2);
			}
		}
	}

	public List<Integer> getSteppingNumbers(int n, int m) {

		for (int i = 0; i < 10; i++) {
			bfs(n, m, i);
		}

		return result;
	}

	public static void main(String[] args) {
		SteppingNumbers s = new SteppingNumbers();

		List<Integer> list = s.getSteppingNumbers(0, 1000);
		for (int v: list) {
			System.out.print(v + " ");
		}
	}

}
