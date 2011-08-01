package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

	/**
	 * Translate a slang text to a TV news-compatible text
	 *
	 * @param text          string full of slang (e.g. 'I am $kewl$.')
	 * @param dictionary    slang dictionary - in pairs, like {{slang, non-slang}, ...}
	 *
	 * @return              the 'cleaned' text
	 */
	@Override
	public String translate(String text, String[][] dictionary) {
		
		for (String[] entries : dictionary) {
			text = text.replaceAll("\\$" + entries[0] + "\\$", entries[1]);
		}
		
		return text;
	}
}
