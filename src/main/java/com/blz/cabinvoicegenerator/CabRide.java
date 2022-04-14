package com.blz.cabinvoicegenerator;

public enum CabRide {
    NORMAL(10, 1, 5), PREMIUM(15, 2, 20);

    private final double costPerKM;
    private final double costPerMin;
    private final int minimumCost;

    CabRide(double costPerKM, double costPerMin, int minimumCost){
        this.costPerKM = costPerKM;
        this.costPerMin = costPerMin;
        this.minimumCost = minimumCost;
    }

    public double calculateCostOfRide(Ride ride) {
        double rideCost = ride.distance*costPerKM + ride.time*costPerMin;
        return Math.max(rideCost, minimumCost);
    }
}
