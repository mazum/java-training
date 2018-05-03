package com.mazum.training.junit.jumpstart;

import com.mazum.training.junit.*;
import java.util.Calendar;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest_BeforeClassAfterClass {

    private static TaxCalculatorImpl taxCalculator = null;

    @BeforeClass
    public static void initializeTaxCalculator() {
        taxCalculator = new TaxCalculatorImpl();
        System.out.println("@BeforeClass: TaxCalculator object is created");
    }

    @Before
    public void resetTaxCalculator() {
        taxCalculator.reset();
        System.out.println("@Before: TaxCalculator object is reset");
    }

    @AfterClass
    public static void releaseTaxCalculator() {
        taxCalculator = null;
        System.out.println("@AfterClass: TaxCalculator object is dereferenced");
    }

    @Test
    public void shouldUseLowestTaxRateForIncomeBelow38000()
            throws InvalidYearException {

        double income = 30000;
        int year = getCurrentYear();
        double expectedTax = income * 0.195;

        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);
        assertEquals("Tax below 38000 should be taxed at 19.5%",
                expectedTax, calculatedTax, 0);
    }

    @Test
    public void shouldUseAverageTaxRateForIncomeBelow60000()
            throws InvalidYearException {

        double income = 50000;
        int year = getCurrentYear();
        double expectedTax = (38000 * 0.195) + ((50000 - 38000) * 0.33);
        
        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);
        
        assertEquals("Tax value of 50000 should be taxed at " + expectedTax,
                expectedTax, calculatedTax, 0);
    }

    private int getCurrentYear() {

        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }
}
