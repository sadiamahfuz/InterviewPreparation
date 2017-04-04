package InterviewCakeProblems;

/*
 * Write a function to reverse a string in-place.
 */
public class StringReverser {

	public String reverse(String s) {
		char[] chars = s.toCharArray();
		int lo = 0;
		int hi = s.length() - 1;

		while (lo < hi) {
			char temp = chars[lo];
			chars[lo] = chars[hi];
			chars[hi] = temp;
			lo++;
			hi--;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		StringReverser s = new StringReverser();
		System.out.println(s.reverse("Hello World."));
	}
}
