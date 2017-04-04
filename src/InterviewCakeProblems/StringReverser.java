package InterviewCakeProblems;

/*
 * Write a function to reverse a string in-place.
 */
public class StringReverser {

	public String reverse(String s) {
		char[] chars = s.toCharArray();

		// first reverse entire string
		reverse(chars, 0, chars.length - 1);

		int lo = 0;
		int hi = 0;
		// now reverse each word
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == ' ') {
				hi = i-1;
				reverse(chars, lo, hi);
				lo = i + 1;
			}
		}

		reverse(chars, lo, chars.length - 1);

		return new String(chars);
	}


	public void reverse(char[] chars, int lo, int hi) {
		while (lo < hi) {
			char temp = chars[lo];
			chars[lo] = chars[hi];
			chars[hi] = temp;
			lo++;
			hi--;
		}
	}

	public static void main(String[] args) {
		StringReverser s = new StringReverser();
		System.out.println(s.reverse("day hot a is today"));
	}
}
