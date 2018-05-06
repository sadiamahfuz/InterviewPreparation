package Hard;

public class HighestAppointment {

	public int getHighest(int[] appt) {
		int n = appt.length;

		if (n == 0) {
			return 0;
		}

		int[] result = new int[n];
		boolean[] incl = new boolean[n];
		result[0] = appt[0];
		incl[0] = true;

		for (int i = 1; i < n; i++) {
			int withCurrent = result[i-1] + appt[i] - appt[i-1];


			if (withCurrent > result[i-1]) {
				incl[i-1] = false;
				incl[i] = true;
			}
			result[i] = Math.max(withCurrent, result[i-1]);
		}


		return result[n-1];
	}


	public static void main(String[] args) {
		int[] input = {30, 15, 60, 75, 45, 15, 15, 45};
		HighestAppointment h = new HighestAppointment();
		System.out.println(h.getHighest(input));

	}

}
