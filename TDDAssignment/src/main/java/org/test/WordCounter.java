package org.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

	public String getWordCount(String input) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		if (input != null && !input.isEmpty()) {
			List<String> list = Arrays.asList(input.split(" "));

			for (String string : list) {
				Integer count = map.get(string);
				if (count == null)
					count = 0;
				map.put(string, count + 1);
			}
		}

		String output = map.toString();
		return output.substring(1, output.length() - 1);
	}

}
