package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

	/**
	 * Calculate the 'greatest common divisor'
	 *
	 * @param number1   the first number ('numerator')
	 * @param number2   the second number ('denominator')
	 *
	 * @return GCD of number1 and number2
	 */
	@Override
	public int calcGCD(int numerator, int denominator) {
		int gcd = 0;
		int maxLoop = numerator;
		
		if (numerator == 0) {
			return denominator;
		}
		
		while (maxLoop > 0 && gcd == 0) {
			if ((numerator % maxLoop == 0) && (denominator % maxLoop == 0)) {
				gcd = maxLoop;
			} else {
				maxLoop--;
			}
		}
		
		return gcd;
	}
}