package GeekForGeeks;

// The position of the right most set bit of a binary number
// e.g 8 -> 1000 -> 4
public class RightmostSetBit {

	public int getRightMostSetBit(int number) {
		return log2(number & -number) + 1;
	}

	private int log2(int n) {
		return (int) (Math.log(n) / Math.log(2));
	}

	public static void main(String[] args) {
		RightmostSetBit r = new RightmostSetBit();
		System.out.println(r.getRightMostSetBit(8));
	}

}
