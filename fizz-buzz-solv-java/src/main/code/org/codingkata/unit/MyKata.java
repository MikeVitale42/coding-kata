package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

    @Override
	public String answer(int input) {
		if (input % 15 == 0) {
			return "fizzbuzz";
		} else if (input % 3 == 0) {
			return "fizz";
		} else if (input % 5 == 0) {
			return "buzz";
		} else {
			return String.valueOf(input);
		}
	}
}
