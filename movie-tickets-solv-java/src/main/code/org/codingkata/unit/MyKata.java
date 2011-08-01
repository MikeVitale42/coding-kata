package org.codingkata.unit;

import java.util.ArrayList;
import java.util.List;
import org.codingkata.unit.api.BaseKataSolution;
import org.codingkata.unit.api.IKataSolution.Day;

public class MyKata extends BaseKataSolution {
	private int numTickets = 0;
	private int runtime = 0;
	private Day day = Day.SUN;
	private boolean parquet = false;
	private boolean threeD = false;
	private List<Ticket> tickets = new ArrayList<Ticket>();

	/**
	 * (1) New customers arrive at your ticket booth and tell you
	 * what movie they'd like to see (so keep it in mind ;-)
	 *
	 * @param runtime       movie's runtime in minutes
	 * @param day           day of the week (enum)
	 * @param isParquet     true if seating category is 'parquet' (and not 'loge')
	 * @param is3D          true if the movie's shown in 3D
	 */
	@Override
	public void startPurchase(int runtime, Day day, boolean isParquet, boolean is3D) {
		this.numTickets = 0;
		this.tickets = new ArrayList<Ticket>();

		this.runtime = runtime;
		this.day = day;
		this.parquet = isParquet;
		this.threeD = is3D;
	}

	/**
	 * (2) Add a ticket to the customers' bill
	 *
	 * @param age           the age of the ticket buyer in years
	 * @param isStudent     true if the ticket buyer is a student
	 */
	@Override
	public void addTicket(int age, boolean isStudent) {
		numTickets++;
		tickets.add(new Ticket(runtime, day, parquet, threeD, age, isStudent));
	}

	/**
	 * (3) Calculate the total admission for the current customer(s)
	 *
	 * @return  total in dollars
	 */
	@Override
	public float finishPurchase() {
		float total = 0.0f;
		
		for (Ticket ticket : tickets) {
			total += ticket.calculatePrice(numTickets);
		}
		
		return total;
	}

	private class Ticket {
		private int numTickets = 0;
		private int runtime = 0;
		private Day day = Day.SUN;
		private boolean parquet = false;
		private boolean threeD = false;
		private int age = 0;
		private boolean student = false;
		
		public Ticket(int runtime, Day day, boolean isParquet, boolean is3D, int age, boolean student) {
			this.runtime = runtime;
			this.day = day;
			this.parquet = isParquet;
			this.threeD = is3D;
			this.age = age;
			this.student = student;
		}

		public float calculatePrice(int numTickets) {
			this.numTickets = numTickets;
			System.out.println("Price = [" + getBasePrice() + "] + [" + getExceptionPrice() + "] == [" + (getBasePrice() + getExceptionPrice()) + "]");
			return getBasePrice() + getExceptionPrice();
		}
		
		public float getBasePrice() {
			if (age < 13) {
				return 5.50f;
			} else if ((age >= 65) || (isGroup())) {
				return 6.00f;
			} else if (student) {
				return 8.00f;
			} else {
				return 11.00f;
			}
		}
		
		public float getExceptionPrice() {
			float exceptions = 0.0f;
			
			if (threeD) {
				exceptions += 3.00f;
			}
			
			if (isOverLength()) {
				exceptions += 1.50f;
			}
			
			if (day == Day.THU && !isGroup()) {
				exceptions -= 2.00f;
			} else if ((day == Day.SAT) || (day == Day.SUN)) {
				exceptions += 1.50f;
			}
			
			if (!parquet) {
				exceptions += 2.00f;
			}
			
			return exceptions;
		}
		
		private boolean isOverLength() {
			return (runtime > 120);
		}
		
		private boolean isGroup() {
			return numTickets >= 20;
		}
	}
}
