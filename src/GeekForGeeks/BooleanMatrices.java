package GeekForGeeks;

public class BooleanMatrices {

	private int[][] matrix;

	public BooleanMatrices(int[][] matrix) {
		this.matrix = matrix;
	}

	public void fillBooleanMatrices() {
		if (matrix.length == 0) {
			return;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		boolean firstRow = false;
		boolean firstCol = false;

		for (int j = 0; j < m; j++) {
			if (matrix[0][j] == 1) {
				firstRow = true;
				break;
			}
		}

		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 1) {
				firstCol = true;
				break;
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][0] = 1;
					matrix[0][j] = 1;
				}
			}
		}

		// fill rows
		for (int i = 1; i < n; i++) {
			if (matrix[i][0] == 1) {
				for (int j = 1; j < m; j++) {
					matrix[i][j] = 1;
				}
			}
		}

		// fill columns
		for (int j = 1; j < m; j++) {
			if (matrix[0][j] == 1) {
				for (int i = 1; i < n; i++) {
					matrix[i][j] = 1;
				}
			}
		}

		if (firstRow) {
			for (int j = 0; j < m; j++) {
				matrix[0][j] = 1;
			}
		}

		if (firstCol) {
			for (int i = 0; i < n; i++) {
				matrix[i][0] = 1;
			}
		}
	}

	public void printMatrix() {
		if (matrix.length == 0) {
			return;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {
				{1, 0, 0, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
		};

		BooleanMatrices b = new BooleanMatrices(matrix);
		b.printMatrix();
		b.fillBooleanMatrices();
		b.printMatrix();

	}

}
