package com.mazum.training.junit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest_BeforeAfter_HamcrestTest {

    private TaxCalculatorImpl taxCalculator = null;

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

        //assertEquals("Tax below 38000 should be taxed at 19.5%", expectedTax, calculatedTax, 0);
        assertThat(calculatedTax, is(expectedTax));
    }
    
    private int getCurrentYear() {

        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }    

    /* Hamcrest Matchers - Logical*/
    @Test
    public void hamcrestAssertIsRed() {
        String color = "red";
        assertThat(color, is("red"));
    }

    @Test
    public void hamcrestAssertNotBlue() {
        String color = "red";
        assertThat(color, not("blue"));
    }
    
    @Test
    public void hamcrestAssertIsRedOrBLue() {
        String color = "red";
        //assertThat(color, isOneOf("red", "blue")); Deprecated
        assertThat(color, is(oneOf("red", "blue")));
    }    

    /* Hamcrest Matchers - Object */
    @Test
    public void hamcrestAssertNull() {
        String color = null;
        assertThat(color, is(nullValue()));
    }
    
    @Test
    public void hamcrestAssertNotNull() {
        String color = "red";
        assertThat(color, is(notNullValue()));
    }    
    
    @Test
    public void hamcrestAssertSameInstance() {
        String color1 = new String("red");
        String color2 = color1;
        assertThat(color2, is(sameInstance(color1)));
    }        

    /* This is same as is(color1) */
    @Test
    public void hamcrestAssertEqualTo() {
        String color1 = new String("red");
        String color2 = new String("red");
        assertThat(color2, is(equalTo(color1)));
    }       
   
    @Test
    public void hamcrestIsClass() {
        List<?> myList = new ArrayList<Object>();
        assertThat(myList, is(instanceOf(Collection.class)));
    }
    
    @Test
    public void hamcrestAssertIsRedOrBlue() {
        String color = "red";
        assertThat(color, anyOf(is("red"), is("blue")));
    }    
    
    /* Hamcrest Matches - Numbers */
    @Test
    public void hamcrestAssertCloseTo20() {
        double value = 17.5;
        assertThat(value, closeTo(16, 1.5));
    }
    
    @Test
    public void hamcrestAssertIsLessThan20() {
        int value = 15;
        assertThat(value, lessThan(20));
    }    
    
    @Test
    public void hamcrestAssertIsBetween10and20() {
        int value = 15;
        assertThat(value, allOf(greaterThanOrEqualTo(10),
                lessThanOrEqualTo(20)));

        assertTrue("Value should be between 10 and 20",
                value >= 10 && value <= 20);
    }

    /* Hamcrest Matchers - Collections */
    @Test
    public void hamcrestAssertHasItem() {
        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        assertThat(colors, hasItem("blue"));
    }

    @Test
    public void hamcrestAssertHasItems() {
        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        assertThat(colors, hasItems("red", "blue"));
        //assertThat("red", isIn(colors)); Deprecated
        assertThat("red", is(in(colors)));
    }

    @Test
    public void hamcrestHasItemLessThan() {
        List<Integer> ages = new ArrayList<Integer>();
        ages.add(20);
        ages.add(30);
        ages.add(40);
        assertThat(ages, not(hasItem(lessThan(18))));
    }        
    
    @Test
    public void hamcrestAssertHasItemInArray() {
        String[] colors = new String[]{"red", "green", "blue"};
        assertThat(colors, hasItemInArray("blue"));
    }

    @Test
    public void hamcrestAssertIsIn() {
        String[] colors = new String[]{"red", "green", "blue"};
        //assertThat("red", isIn(colors)); Deprecated
        assertThat("red", is(in(colors)));
    }
    
    @Test
    public void hamcrestAssertNotIsIn() {
        String[] colors = new String[]{"red", "green", "blue"};
        String color = "yellow";
        //assertThat(color, not(isIn(colors))); Deprecated
        assertThat(color, not(is(in(colors))));
    }
    
    @Test 
    public void hamcrestAnything() {
        int result = 2;
        assertThat(result, is(anything()));
    }
}