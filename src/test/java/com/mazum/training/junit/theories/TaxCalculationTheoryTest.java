package com.mazum.training.junit.theories;

import com.mazum.training.junit.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assume.assumeThat;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TaxCalculationTheoryTest {
    
    private TaxCalculatorImpl taxCalculator = null;

    @DataPoint
    public static int YEAR_2006 = 2006;
    @DataPoint
    public static int YEAR_2007 = 2007;
    @DataPoint
    public static int YEAR_2008 = 2008;
    
    @DataPoint
    public static String test = "Sai";
    
    @DataPoint
    public static double INCOME_1 = 0;
    @DataPoint
    public static double INCOME_2 = 1000;
    @DataPoint
    public static double INCOME_3 = 5000;
    @DataPoint
    public static double INCOME_4 = 8000;
    @DataPoint
    public static double INCOME_5 = 15000;
    @DataPoint
    public static double INCOME_6 = 25000;
    @DataPoint
    public static double INCOME_7 = 35000;
    @DataPoint
    public static double INCOME_8 = 37000;
    @DataPoint
    public static double INCOME_9 = 37999;
    @DataPoint
    public static double INCOME_10 = 38000;
    @DataPoint
    public static double INCOME_12 = 38001;
    @DataPoint
    public static double INCOME_13 = 40000;
    @DataPoint
    public static double INCOME_14 = 50000;
    @DataPoint
    public static double INCOME_15 = 60000;
    
    @Theory
    public void incomeUpTo38000(double income, int year) 
            throws InvalidYearException {
        assumeThat(year, anyOf(is(2007), is(2008)));
        assumeThat(income, lessThanOrEqualTo(38000.00));

        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);
        double expectedTax = income * 0.195;

        System.out.println("Theory: year = " + year + ", income=" + income + ", calculated tax=" + calculatedTax);
        assertThat(expectedTax, is(calculatedTax));
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
    public void shouldUseAverageTaxRateForIncomeBelow60000()
            throws InvalidYearException {

        double income = 50000;
        int year = 2008;
        double expectedTax = (38000 * 0.195) + ((50000 - 38000) * 0.33);

        double calculatedTax = taxCalculator.calculateIncomeTax(income, year);

        assertEquals("Tax value of 50000 should be taxed at " + expectedTax,
                expectedTax, calculatedTax, 0);
        System.out.println("Test: year = " + year + ", income=" + income + ", calculated tax=" + calculatedTax);        
    }
}