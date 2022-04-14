package com.blz.cabinvoicegenerator;

public class InvoiceSummary {

    private final int numberOfRides;
    private final double totalFare;
    private final double averageCost;

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageCost = this.totalFare / this.numberOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageCost, averageCost) == 0;
    }
}
