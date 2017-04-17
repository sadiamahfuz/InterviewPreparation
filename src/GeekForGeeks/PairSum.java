package GeekForGeeks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given two unsorted arrays A[] of size n and B[] of size m of distinct elements,
 * the task is to find all pairs from both arrays whose sum is equal to x.
 */
public class PairSum {

	public static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public List<Pair> findSumPairs(int[] A, int[] B, int sum) {
		List<Pair> pairs = new LinkedList<Pair>();

		// Read one of the arrays into a Set
		Set<Integer> numbers = new HashSet<Integer>();
		for (int n: A) {
			numbers.add(n);
		}

		for (int n: B) {
			int need = sum - n;
			if (numbers.contains(need)) {
				pairs.add(new Pair(need, n));
			}
		}

		return pairs;
	}

	public static void main(String[] args) {
		PairSum p = new PairSum();
		int[] A = new int[]{-1, -2, 4, -6, 5, 7};
		int[] B = new int[] {6, 3, 4, 0};
		int sum = 8;

		List<Pair> result = p.findSumPairs(A, B, sum);
		for (Pair pair: result) {
			System.out.println(pair.a + ", " + pair.b);
		}
	}

}
