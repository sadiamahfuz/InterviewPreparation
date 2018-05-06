package CrackingTheCodingInterview.arraysAndStrings;

/**
 * Answer to Question 1.7
 * @author mahfuzs
 *
 */
public class Matrix {

	int[][] values;
	public Matrix(int[][] values) {
		this.values = values;
	}

	/**
	 * Rotate matrix by 90 degrees
	 */
	public void rotate90() {
		// First transpose
		this.transpose();

		// Reverse each row
		for (int i = 0; i < values.length; i++) {
			int end = values[i].length-1;
			for (int j = 0; j < values[i].length/2; j++) {
				int temp = values[i][j];
				values[i][j] = values[i][end];
				values[i][end] = temp;
				end--;
			}
		}

	}

	public void transpose() {

		for (int row = 0; row < values.length; row++) {
			for (int col = row; col < values[row].length; col++) {
				int temp = values[row][col];
				values[row][col] = values[col][row];
				values[col][row] = temp;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				s.append(values[i][j] + "\t");
			}
			s.append("\n");
		}

		return s.toString();
	}

}
