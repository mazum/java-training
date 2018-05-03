package com.mazum.training.junit;

public interface TaxCalculator {

    double calculateIncomeTax(double income, int year)
            throws InvalidYearException;
}

