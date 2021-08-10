package com.bridgelabz.cabservice;

public class InvoiceDetails {
	private double averageFare;
	private int numberOfRides;
	private double totalFare;

	public InvoiceDetails(int numberOfRides, double totalFare) {
		this.numberOfRides = numberOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare / this.numberOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceDetails invoiceDetails = (InvoiceDetails) obj;
		return Double.compare(invoiceDetails.averageFare, averageFare) == 0
				&& numberOfRides == invoiceDetails.numberOfRides
				&& Double.compare(invoiceDetails.totalFare, totalFare) == 0;
	}

}
