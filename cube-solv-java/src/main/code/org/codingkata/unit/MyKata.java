package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

import java.util.ArrayList;
import java.util.List;

public class MyKata extends BaseKataSolution {
	private static final List<Integer> primes = new ArrayList<Integer>();
	
	static {
		primes.add(1);
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		primes.add(17);
		primes.add(19);
		primes.add(23);
		primes.add(29);
		primes.add(31);
		primes.add(37);
		primes.add(41);
		primes.add(43);
		primes.add(47);
	}

	/**
	 * Test if a cube door is trapped
	 *
	 * @param code1     first code
	 * @param code2     second code
	 * @param code3     third code
	 *
	 * @return true if any of the codes' checksum is a prime number
	 */
	@Override
	public boolean containsPrimeNumber (String code1, String code2, String code3) {
		return isPrime(calcNum(code1)) || isPrime(calcNum(code2)) || isPrime(calcNum(code3));
	}
	
	private int calcNum(String number) {
		char[] chars = number.toCharArray();
		int value = 0;
		
		for (char ch : chars) {
			value += Integer.valueOf(String.valueOf(ch));
		}
		
		return value;
	}
	
	private boolean isPrime(int input) {
		return primes.contains(input);
	}
}
