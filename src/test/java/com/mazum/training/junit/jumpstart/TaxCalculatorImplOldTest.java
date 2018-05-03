package com.mazum.training.junit.jumpstart;

import com.mazum.training.junit.*;
import junit.framework.TestCase;

public class TaxCalculatorImplOldTest extends TestCase {

    public void testShouldUseLowestTaxRateForIncomeBelow38000()
            throws InvalidYearException {

        TaxCalculatorImpl calc = new TaxCalculatorImpl();
        double income = 30000;
        double expectedTax = income * 0.195;
        double calculatedTax = calc.calculateIncomeTax(30000, 2008);
        assertEquals("Tax below 38000 should be taxed at 19.5%", expectedTax, calculatedTax);
    }
}
