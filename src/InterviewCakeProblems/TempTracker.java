package InterviewCakeProblems;

/*
 * You decide to test if your oddly-mathematical heating company is
 * fulfilling its All-Time Max, Min, Mean and Mode Temperature Guarantee™.
 * Write a class TempTracker with these methods:
 *
 * insert()—records a new temperature
 * getMax()—returns the highest temp we've seen so far
 * getMin()—returns the lowest temp we've seen so far
 * getMean()—returns the mean ↴ of all temps we've seen so far
 * getMode()—returns a mode ↴ of all temps we've seen so far
 *
 * Optimize for space and time.
 * Favor speeding up the getter functions (getMax(), getMin(), getMean(), and getMode())
 * over speeding up the insert() function.
 * getMean() should return a double, but the rest of the getter functions can return integers.
 *
 * Temperatures will all be inserted as integers.
 * We'll record our temperatures in Fahrenheit,
 * so we can assume they'll all be in the range 0..1100..110.
 *
 * If there is more than one mode, return any of the modes.
 */
public class TempTracker {

	private int min = 110;
	private int max = 0;
	private int mode = 0;
	private int modeFrequency = 0;
	private double mean = 0.0;
	private int numTemp = 0;
	private int[] occurrences;

	public TempTracker() {
		this.occurrences = new int[111];
	}

	public void insert(int temp) {
		occurrences[temp]++;

		for (int i = 0; i < 111; i++) {
			if (occurrences[i] > modeFrequency) {
				modeFrequency = occurrences[i];
				mode =  i;
			}
		}

		mean = ((numTemp * mean) + temp) / ++numTemp;
		max = Math.max(max, temp);
		min = Math.min(min, temp);
	}

	public double getMean() {
		return mean;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public int getMode() {
		return mode;
	}

	public static void main(String[] args) {
		TempTracker t = new TempTracker();
		t.insert(1);
		t.insert(3);
		t.insert(2);
		t.insert(3);
		t.insert(2);
		t.insert(3);
		t.insert(2);
		t.insert(2);
		t.insert(2);

		System.out.println(t.getMode());
		System.out.println(t.getMean());
		System.out.println(t.getMax());
		System.out.println(t.getMin());
	}

}
