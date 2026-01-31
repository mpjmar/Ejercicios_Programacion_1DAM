import java.util.ArrayList;
import java.util.Collections;

import input.*;

public class App {
    public static void main(String[] args) throws Exception {

		ArrayList<String> words = new ArrayList<String>(10);
		String word;

		System.out.println("Please, insert 10 words: ");
		for (int i = 0; i < 10; i++) {
			word = ReadInput.input();
			words.add(word);
		}
		System.out.println(words);
		Collections.sort(words);
		System.out.println(words);
	}
}
