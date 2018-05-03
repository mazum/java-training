package com.mazum.training.junit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaxCalculatorImpl implements TaxCalculator {
	public static final List<TaxRate> TAX_RATES = new ArrayList<TaxRate>();
    private double tax = 0.0;

    static {
        TAX_RATES.add(new TaxRate(0, 38000, 0.195));
        TAX_RATES.add(new TaxRate(38000, 60000, 0.33));
        TAX_RATES.add(new TaxRate(60000, 0, 0.39));
    }
	
    public double calculateIncomeTax(double income, int year)
            throws InvalidYearException {

        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);

        if (year > currentYear) {
            throw new InvalidYearException(
                    "No tax calculations available yet for the year " + year);
        }

        assert income >= 0 : "Revenue should not be negative";

        double totalTax = 0.0;
        for (TaxRate rate : TAX_RATES) {
            totalTax += rate.calculateTax(income);
        }
        tax = totalTax;
        return totalTax;
    }
    
    public double getLastCalculatedTax() {
        return tax;
    }
    
    public void reset() {
        tax = 0.0;
    }
}
