package com.blz.cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    Ride[] rides = null;
    CabInvoiceGenerator cabInvoiceGenerator;
    InvoiceSummary expectedInvoiceSummary;
    RideRepository rideRepository;

    @BeforeEach
    public void setUp() {
        cabInvoiceGenerator = new CabInvoiceGenerator();
        rideRepository = new RideRepository();
        cabInvoiceGenerator.setRideRepository(rideRepository);
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
                new Ride(CabRide.NORMAL, 5.0, 10),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedValue = new InvoiceSummary(2, 65.0);
        Assertions.assertEquals(summary, expectedValue);
    }

    @Test
    void givenMultipleRidesWith2CategoryRides_whenCalculated_shouldReturnEqual() {
        String userId = "asd";
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        cabInvoiceGenerator.addRide(userId,rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        Assertions.assertEquals(summary, expectedInvoiceSummary);
    }
}
