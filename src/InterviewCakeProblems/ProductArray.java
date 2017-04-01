package InterviewCakeProblems;

public class ProductArray {

	public int[] getProductArray(int[] input) {

		if (input == null || input.length <= 1) {
			throw new IllegalArgumentException();
		}

		int[] result = new int[input.length];

		// First, get products from indexes before current index
		int beforeProduct = 1;
		for (int i = 0; i < input.length; i++) {
			result[i] = beforeProduct;
			beforeProduct = beforeProduct * input[i];
		}

		// Now multiply with the product from index after current index
		int afterProduct = 1;
		for (int i = input.length - 1; i >= 0; i--) {
			result[i] = result[i] * afterProduct;
			afterProduct = afterProduct * input[i];
		}


		return result;
	}

	public static void main(String[] args) {
		ProductArray p = new ProductArray();
		int[] a = {1, 2, 6, 5, 9};
		int[] answer = p.getProductArray(a);
		for (int i: answer) {
			System.out.print(i + " ");
		}
	}

}
