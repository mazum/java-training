package com.mazum.training.junit.jumpstart;

import com.mazum.training.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest_Basic {

    @Test
    public void shouldUseLowestTaxRateForIncomeBelow38000()
            throws InvalidYearException {

        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();
        double income = 30000;
        double expectedTax = income * 0.195;

        double calculatedTax = taxCalculator.calculateIncomeTax(30000, 2008);

        assertEquals("Tax below 38000 should be taxed at 19.5%", expectedTax, calculatedTax, 0);
    }

    @Test
    public void shouldUseAverageTaxRateForIncomeBelow60000()
            throws InvalidYearException {

        double income = 50000;
        int year = 2008;
        double expectedTax = (38000 * 0.195) + ((50000 - 38000) * 0.33);
        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();

        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);

        assertEquals("Tax value of 50000 should be taxed at " + expectedTax,
                expectedTax, calculatedTax, 0);
    }
}
