package InterviewCakeProblems;

/*
 * You want to build a word cloud, an infographic where the size of a word
 * corresponds to how often it appears in the body of text.
 * To do this, you'll need data. Write code that takes a long string and
 * builds its word cloud data in a hash map, where the keys are words
 * and the values are the number of times the words occurred.
 *
 * Think about capitalized words.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCloud {

	public Map<String, Integer> buildWordCloud(String text) {
		Map<String, Integer> wordCloud = new HashMap<String, Integer>();

		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (isPunctuation(word.charAt(word.length() - 1))) {
				word = word.substring(0, word.length() - 1);
			}
			word = word.toLowerCase();
			wordCloud.put(word, wordCloud.containsKey(word) ? wordCloud.get(word) + 1: 1);
		}

		return wordCloud;
	}

	private boolean isPunctuation(char c) {
		return c == '.' || c == ',' || c == ':' || c == '?' || c == '!';
	}

	public static void main(String[] args) {
		String text = "After beating the eggs, Dana read the next step: Add milk and eggs, then add flour and sugar.";
		WordCloud w = new WordCloud();
		Map<String, Integer> wordCloud = w.buildWordCloud(text);
		for (Map.Entry<String, Integer> entry: wordCloud.entrySet()) {
			System.out.print(entry.getKey() + ": " + entry.getValue());
			System.out.println();
		}
	}

}
