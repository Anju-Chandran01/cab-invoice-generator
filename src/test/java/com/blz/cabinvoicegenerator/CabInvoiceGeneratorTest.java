package com.blz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    @Test
    void givenDistanceAndTime_whenCalculated_shouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 5;
        int time = 10;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 60);
    }

    @Test
    void givenDistanceAndTime_whenCalculated_shouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(fare, 5);
    }

    @Test
    void givenMultipleRides_whenCalculated_shouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(5.0, 10),
                        new Ride(0.1, 1)
                        };
        double fare = cabInvoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(fare, 65);
    }
}
