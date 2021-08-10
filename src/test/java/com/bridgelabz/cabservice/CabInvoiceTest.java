package com.bridgelabz.cabservice;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CabInvoiceTest {
	static InvoiceGenerator invoiceGenerator;

	@BeforeClass
	public static void createInvoiceGeneratorObj() {
		invoiceGenerator = new InvoiceGenerator();
	}

	/**
	 * method to return fare, distance and time given
	 */
	
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 25.0;
		int time = 15;
		double fare = invoiceGenerator.calaculateFare(distance, time);
		Assert.assertEquals(265, fare, 0.0);
	}
	
	/**
	 * method to return minimum fare, less distance and time is given
	 */

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calaculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	/**
	 * method to return invoice summary of multiple rides
	 */

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(25, 15), new Ride(0.1, 1) };
		InvoiceDetails details = invoiceGenerator.calaculateFare(rides);
		InvoiceDetails expectedInvoiceSummary = new InvoiceDetails(2, 270);
		Assert.assertEquals(expectedInvoiceSummary, details);
	}
     
	/**
	 * method to give user id  return invoice summary
	 */
	
	@Test
	public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		String userId = "143";
		invoiceGenerator.addRides(userId, rides);
		InvoiceDetails details = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceDetails expectedInvoicedetails = new InvoiceDetails(2, 30);
		Assert.assertEquals(expectedInvoicedetails, details);
	}

}
