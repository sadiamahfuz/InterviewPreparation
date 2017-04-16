package InterviewCakeProblems;

/*
 * You created a game that is more popular than Angry Birds.
 * You rank players in the game from highest to lowest score.
 * So far you're using an algorithm that sorts in O(n log n) time,
 * but players are complaining that their rankings aren't updated fast enough.
 * You need a faster sorting algorithm.
 *
 * Write a function that takes:
 *   an array of unsortedScores
 *   the highestPossibleScore in the game
 *   and returns a sorted array of scores in less than O(n log n) time.
 */
public class ScoreRanking {

	public int[] sortScores(int[] scores, int highestPossibleScore) {

		int[] scoreCounts = new int[highestPossibleScore + 1];
		for (int score: scores) {
			scoreCounts[score]++;
		}

		int index = 0;
		for (int i = 0; i < scoreCounts.length; i++) {
			int loop = 0;
			while (loop < scoreCounts[i]) {
				scores[index] = i;
				index++;
				loop++;
			}
		}

		return scores;
	}

	public static void main(String[] args) {
		ScoreRanking s  = new ScoreRanking();
		int[] unsortedScores = {37, 91, 89, 41, 65, 65, 91, 53, 65};
		final int HIGHEST_POSSIBLE_SCORE = 100;

		int[] sorted = s.sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
		for (int i: sorted) {
			System.out.print(i + " ");
		}

	}

}
