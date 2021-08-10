package com.bridgelabz.cabservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
	/**
	 * method to return fare, distance and time given
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 25.0;
		int time = 15;
		double totalFare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(265, totalFare, 0.0);
	}

	/**
	 * method to return minimum fare, less distance and time is given
	 */
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0;
		int time = 0;
		double totalFare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, totalFare, 0.0);
	}

}
