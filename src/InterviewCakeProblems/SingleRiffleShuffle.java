package InterviewCakeProblems;

/*
 * I figured out how to get rich: online poker.
 * I suspect the online poker game I'm playing shuffles cards by doing a single riffle.
 * To prove this, let's write a function to tell us if a full deck of cards shuffledDeck is a single riffle of two other halves half1 and half2.
 *
 * We'll represent a stack of cards as an array of integers in the range 1..52
 * (since there are 52 distinct cards in a deck).
 */
public class SingleRiffleShuffle {

	public boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

		int half1Index = 0;
		int half2Index = 0;

		for (int card: shuffledDeck) {
			if (half1Index < half1.length &&
					half1[half1Index] == card) {
				half1Index++;
			}
			else if (half2Index < half2.length &&
					half2[half2Index] == card) {
				half2Index++;
			}
			else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		SingleRiffleShuffle s = new SingleRiffleShuffle();
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {6,7,8,9,10};
		int[] deck = new int[] {1,6,7,8,2,3,4,5,9,10};

		System.out.println(s.isSingleRiffle(a, b, deck));
	}

}
