package com.blz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator cabInvoiceGenerator = null;

    @BeforeEach
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
    }

    @Test
    void givenDistanceAndTime_whenCalculated_shouldReturnTotalFare() {
        double distance = 5;
        int time = 10;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 60);
    }

    @Test
    void givenDistanceAndTime_whenCalculated_shouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 5);
    }

    @Test
    void givenMultipleRides_whenCalculated_shouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(5.0, 10),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }

    @Test
    void givenMultipleRidesAndUserId_whenCalculated_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(5.0, 10),
                new Ride(0.1, 1)
        };
        String userId = "1";
        cabInvoiceGenerator.addRide(userId,rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }
}
