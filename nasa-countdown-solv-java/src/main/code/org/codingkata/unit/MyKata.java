package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    // YOUR IMPLEMENTATION
	@Override
	public Integer[] countdown(int start) {
		Integer[] ints = new Integer[start + 1];
		int count = 0;
		
		while (start >= 0) {
			ints[count] = start;
			start--;
			count++;
		}

		return ints;
	}
}