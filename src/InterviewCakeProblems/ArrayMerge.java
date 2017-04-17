package InterviewCakeProblems;

/*
 * In order to win the prize for most cookies sold, my friend Alice and I
 * are going to merge our Girl Scout Cookies orders and enter as one unit.
 * Each order is represented by an "order id" (an integer).
 * We have our lists of orders sorted numerically already, in arrays.
 * Write a function to merge our arrays of orders into one sorted array.
 */
public class ArrayMerge {

	public int[] mergeSortedArrays(int[] a, int[] b) {

		int index1 = 0;
		int index2 = 0;
		int mergedIndex = 0;

		int[] result = new int[a.length + b.length];

		while (index1 < a.length || index2 < b.length) {
			if (index1 >= a.length) {
				result[mergedIndex] = b[index2++];
			}
			else if (index2 >= b.length) {
				result[mergedIndex] = a[index1++];
			}
			else {
				if (a[index1] > b[index2]) {
					result[mergedIndex] = b[index2++];
				}
				else {
					result[mergedIndex] = a[index1++];
				}
			}
			mergedIndex++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
		int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
		ArrayMerge a = new ArrayMerge();
		int[] array = a.mergeSortedArrays(myArray, alicesArray);
		for (int i: array) {
			System.out.print(i + " ");
		}

	}

}
