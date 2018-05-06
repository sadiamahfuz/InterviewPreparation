package arraysAndStrings;

public class Main {

	public static void main(String[] args) {
		int[][] values = {
				{1, 2, 3, 4, 22},
				{5, 6, 7, 8, 23},
				{9, 10, 11, 12, 24},
				{13, 14, 15, 16, 25},
				{17, 18, 19, 20, 26}
		};

		Matrix m = new Matrix(values);
		System.out.println(m.toString());
		m.rotate90();
		System.out.println(m.toString());
	}

}
