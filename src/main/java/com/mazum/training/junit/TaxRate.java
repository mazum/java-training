package com.mazum.training.junit;

public class TaxRate {

    private double minimumRevenue;
    private double maxiumumRevenue;
    private double rate;

    public TaxRate(double minimumRevenue, double maxiumuRevenue, double rate) {
        super();
        this.minimumRevenue = minimumRevenue;
        this.maxiumumRevenue = maxiumuRevenue;
        this.rate = rate;
    }

    public double getMinimumRevenue() {
        return minimumRevenue;
    }

    public double getMaxiumumRevenue() {
        return maxiumumRevenue;
    }

    public double getRate() {
        return rate;
    }

    private double getApplicableAmount(double totalRevenue) {
        double applicableAmount = 0.0;
        if (totalRevenue >= minimumRevenue) {
            applicableAmount = totalRevenue - minimumRevenue;
            if (maxiumumRevenue > 0) {
                if (totalRevenue > maxiumumRevenue) {
                    applicableAmount = maxiumumRevenue - minimumRevenue;
                }
            }
        }
        return applicableAmount;
    }

    public double calculateTax(double totalRevenue) {
        return getApplicableAmount(totalRevenue) * rate;
    }
}

