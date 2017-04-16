package InterviewCakeProblems;

public class RotationPointFinder {

	public int findRotationPoint(String[] words) {

		int lo = 0;
		int hi = words.length - 1;

		// if not rotated
		if (words[lo].compareTo(words[hi]) < 0) {
			return lo;
		}

		while (lo < hi) {
			int mid = lo + (hi-lo)/2;

			if (words[mid].compareTo(words[lo]) < 0) {
				// search left
				hi = mid;
			}
			else {
				// search right
				lo = mid;
			}

			if (lo + 1 == hi) {
				break;
			}

		}
		return hi;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = new String[]{
				"ptolemaic",
				"retrograde",
				"supplant",
				"undulate",
				"xenoepist",
				"yolo",
				"zebra",
				"asymptote", // <-- rotates here!
				"babka",
				"banoffee",
				"engender",
				"karpatka",
				"othellolagkage",
		};

		RotationPointFinder r = new RotationPointFinder();
		System.out.println(r.findRotationPoint(words));

	}

}
