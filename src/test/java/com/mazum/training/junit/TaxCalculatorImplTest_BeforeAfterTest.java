package com.mazum.training.junit;

import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest_BeforeAfterTest {
    
    private TaxCalculatorImpl taxCalculator = null;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
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
        
        assertEquals("Tax below 50000 should be taxed at " + expectedTax,
                expectedTax, calculatedTax, 0);
    }    

    @Test(expected=InvalidYearException.class)
    public void futureYearsShouldBeInvalid()
            throws InvalidYearException {

        double income = 30000;
        int year = getCurrentYear() + 1;
        
        taxCalculator.calculateIncomeTax(income, year);
    }
    
    @Test(timeout=1000)
    public void shouldCalculateCorrectTax() throws InvalidYearException {
        double income = 50000;
        int year = getCurrentYear();
        double expectedTax = (38000 * 0.195) + ((50000 - 38000) * 0.33);        
        
        for (int i = 1; i < 50000; i++) {
            double calculatedTax = taxCalculator.calculateIncomeTax(income, year);
            assertEquals(expectedTax, calculatedTax, 0.0);
        }
    }
    
    @Test
    public void exceptionShouldIncludeAClearMessage() {    
    	double income = 30000;
        int year = getCurrentYear() + 1;
    	try {
    		taxCalculator.calculateIncomeTax(income, year);
    		fail("calculateIncomeTax() should throw an exception.");
    	} catch (InvalidYearException expected) {
    		assertEquals(expected.getMessage(),"No tax calculations available yet for the year 2019");
    	}
    }
    
    @Test
    public void exceptionShouldIncludeAClearMessageAlternate() throws InvalidYearException {    
    	exception.expect(InvalidYearException.class);
    	exception.expectMessage("No tax calculations available yet for the year 2019");
    	double income = 30000;
        int year = getCurrentYear() + 1;
        taxCalculator.calculateIncomeTax(income, year);
    }
    
    private int getCurrentYear() {
        
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }
}
