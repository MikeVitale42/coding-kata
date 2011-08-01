package org.codingkata.unit;

import org.codingkata.unit.api.BaseKataSolution;

public class MyKata extends BaseKataSolution {

	/**
	 * Welcome a guest
	 *
	 * @param lastName   the last name of the guest
	 * @param isWoman    true if the guest is female
	 * @param isSir      true if the guest was knighted by the queen
	 *
	 * @return          issues welcome text to the guest
	 */
	@Override
	public String welcome (String lastName, boolean isWoman, boolean isSir) {
		StringBuilder buf = new StringBuilder("Hello ");

		if (isSir) {
			buf.append("Sir ");
		} else if (isWoman) {
			buf.append("Ms. ");
		} else {
			buf.append("Mr. ");
		}
		
		buf.append(lastName);
		
		return buf.toString();
	}

}