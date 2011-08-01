package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

	/**
	 * Calculate an element of the Fibonacci sequence
	 *
	 * @param n     element number
	 * @return      n-th element of the Fibonacci sequence
	 */
	@Override
	public int fibonacci (int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
