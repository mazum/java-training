package com.mazum.training.junit.parameterized;

import com.mazum.training.junit.*;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TaxCalculationImplTest {
    
    private TaxCalculatorImpl taxCalculator = null;
    private double income;
    private int year;
    private double expectedTax;
    
    @Parameters
    public static Collection<Object[]> data() {
        System.out.println("Feeder method called2");
        return Arrays.asList(new Object[][]{
                    /* Income Year Tax */
                    {0.00, 2006, 0.00}, {10000.00, 2006, 1950.00},
                    {20000.00, 2006, 3900.00}, {38000.00, 2006, 7410.00},
                    {38001.00, 2006, 7410.33}, {40000.00, 2006, 8070.00},
                    {60000.00, 2006, 14670.00}, {100000.00, 2006, 30270.00},
                });
    }
    
    public TaxCalculationImplTest(double income, int year, double expectedTax) {
        this.income = income;
        this.year = year;
        this.expectedTax = expectedTax;
    }
    
    @BeforeClass
    public static void start() {
        System.out.println("@BeforeClass called");
    }
    
    @AfterClass
    public static void stop() {
        System.out.println("@AfterClass called");
    }    
    
    @Before
    public void prepareTaxCalculator() {
        taxCalculator = new TaxCalculatorImpl();
        System.out.println("@Before: TaxCalculator object is created");
    }

    @After
    public void cleanupTaxCalculator() {
        taxCalculator = null;
        System.out.println("@After: TaxCalculator object is dereferenced");
    }    

    @Test
    public void shouldCalculateCorrectTax() throws InvalidYearException {
        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);
        assertEquals(expectedTax, calculatedTax, 0.0);
    }
}