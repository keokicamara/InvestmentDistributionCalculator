package com.keokicamara.moneycalculator.calculate;

import com.keokicamara.moneycalculator.CalculatorApplication;

public class CalculationCategory {

    private final String name;
    private final String percentage;

    public CalculationCategory(String name, String percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return Double.parseDouble(percentage);
    }

    public String getFormattedPercentage() {
        return String.format("%,.2f", Double.parseDouble(percentage) * 100) + "%";
    }

    public String getFormattedName() {
        return name + ": ";
    }

    public String getFormattedTotal() {
        return "$" + String.format("%,.2f", CalculatorApplication.inputTotal * Double.parseDouble(percentage));
    }

    public void printPercentageDistribution() {
        System.out.println(getFormattedName() + getFormattedPercentage());
    }

    public void printFinalDistribution() {
        System.out.println(getFormattedName() + getFormattedTotal());
    }

}