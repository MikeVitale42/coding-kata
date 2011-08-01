package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

	/**
	 * Revert a word in 'backward talk' to understand it
	 *
	 * @param word  the backwards word
	 * @return      the regular word
	 */
	@Override
	public String revert (String word) {
		char[] input = word.toCharArray();
		char[] output = new char[word.length()];
		int i = 0;
		
		while (i < word.length()) {
			output[i] = input[word.length() - i - 1];
			i++;
		}
		
		return new String(output);
	}
}