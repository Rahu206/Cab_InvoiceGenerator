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
		double distance = 0.1;
		int time = 1;
		double totalFare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, totalFare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShoulReturnInvoiceSummary() {

		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

		Ride[] rides = { new Ride(25.0, 15), new Ride(15, 5), new Ride(0.1, 1), };
		InvoiceDetails invoiceDetails = invoiceGenerator.calculateFare(rides);
		InvoiceDetails expectedInvoiceDetails = new InvoiceDetails(3, 425.0);
		Assert.assertEquals(expectedInvoiceDetails, invoiceDetails);
	}

}
