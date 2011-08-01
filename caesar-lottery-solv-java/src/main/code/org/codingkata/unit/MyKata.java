package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {
	private static String[] numerals = new String[51];
	
	static {
		numerals[0] = "";
		numerals[1] = "I";
		numerals[2] = "II";
		numerals[3] = "III";
		numerals[4] = "IV";
		numerals[5] = "V";
		numerals[6] = "VI";
		numerals[7] = "VII";
		numerals[8] = "VIII";
		numerals[9] = "IX";
		numerals[10] = "X";
		numerals[20] = "XX";
		numerals[30] = "XXX";
		numerals[40] = "XL";
		numerals[50] = "L";
	}
	
	/**
	 * Convert an Arabic numeral to Roman numeral
	 *
	 * @param number    an Arabic numeral
	 * @return          the Roman numeral equivalent to the Arabic numeral
	 */
	@Override
	public String convert (int number) {
		int tens = 1;
		int remainder = 0;
		String retVal = "";
		
		while (number > 0) {
			remainder = number % 10;
			retVal = numerals[remainder * tens] + retVal;
			tens *= 10;
			number /= 10;
		}
		
		return retVal;
	}
	
	
}