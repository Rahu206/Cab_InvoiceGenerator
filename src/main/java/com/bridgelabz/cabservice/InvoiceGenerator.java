package com.bridgelabz.cabservice;

public class InvoiceGenerator {
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * UC1-This method is to calculate the fare of ride with the given time and
	 * distance
	 * 
	 * @param distance
	 * @param time
	 * @return total fare of cab
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;

	}

	/**
	 * UC2 - This method is calculating aggregate cab fare of multiple rides
	 * 
	 * @param rides
	 * @return calculate total fare
	 */
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.distance, ride.time);
		return totalFare;
	}
}
