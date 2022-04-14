package com.blz.cabinvoicegenerator;

public class CabInvoiceGenerator {

    private static final int COST_PER_MINUTE = 1;
    private static final int COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return Math.max(fare, MINIMUM_FARE);
    }
}
