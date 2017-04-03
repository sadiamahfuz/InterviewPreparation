package InterviewCakeProblems;

/*
 * A crack team of love scientists from OkEros (a hot new dating site)
 * have devised a way to represent dating profiles as rectangles on a
 * two-dimensional plane.
 *
 * They need help writing an algorithm to find the intersection
 * of two users' love rectangles.
 * They suspect finding that intersection is the key to a matching algorithm
 * so powerful it will cause an immediate acquisition by Google or Facebook or something.
 *
 * Write a function to find the rectangular intersection of two given love rectangles.

As with the example above, love rectangles are always "straight" and never "diagonal."
More rigorously: each side is parallel with either the x-axis or the y-axis.


 */

public class RectangleIntersection {

	public Rectangle findIntersection(Rectangle r1, Rectangle r2) {

		int[] xOverlap = this.findXOverlap(r1, r2);
		int[] yOverlap = this.findYOverlap(r1, r2);

		if (xOverlap == null || yOverlap == null) {
			System.out.println("No Intersection");
			return new Rectangle();
		}

		return new Rectangle(xOverlap[0], yOverlap[0], xOverlap[1] - xOverlap[0], yOverlap[1] - yOverlap[0]);
	}

	private int[] findXOverlap(Rectangle r1, Rectangle r2) {

		int left = Math.max(r1.leftX, r2.leftX);
		int right = Math.min(r1.leftX + r1.width, r2.leftX + r2.width);

		if (left >= right) {
			return null;
		}

		return new int[] {left, right};
	}

	private int[] findYOverlap(Rectangle r1, Rectangle r2) {

		int bottom = Math.max(r1.bottomY, r2.bottomY);
		int top = Math.min(r1.bottomY + r1.height, r2.bottomY + r2.height);

		if (bottom >= top) {
			return null;
		}

		return new int[] {bottom, top};
	}

	public static void main(String[] args) {

	}
}
