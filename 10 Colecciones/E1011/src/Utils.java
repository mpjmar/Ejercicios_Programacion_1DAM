import java.util.ArrayList;

public class Utils {
	
	public static ArrayList<String> chooseWords(String[] words) {
		
		ArrayList<String> chosenWords = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			int idx = (int)(Math.random() * words.length);
			chosenWords.add(words[idx]);
		}
		return chosenWords;
	}
}
