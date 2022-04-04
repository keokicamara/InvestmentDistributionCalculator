package com.keokicamara.moneycalculator.calculate;

import com.keokicamara.moneycalculator.CalculatorApplication;

import java.io.*;
import java.util.Locale;

public class CalculationSubcategory implements Serializable {

    private String name;
    private final String percentage;
    private final CalculationCategory calculationCategory;

    public CalculationSubcategory(String name, String percentage, CalculationCategory calculationCategory) {
        this.name = name;
        this.percentage = percentage;
        this.calculationCategory = calculationCategory;
    }

    public String getFormattedPercentage() {
        return String.format("%,.2f", Double.parseDouble(percentage) * 100) + "%";
    }

    public String getFormattedName() {
        return "    " + name + ": ";
    }

    public String getFormattedTotal() {
        return "$" + String.format("%,.2f", CalculatorApplication.inputTotal * calculationCategory.getPercentage() * Double.parseDouble(percentage));
    }

    public void printPercentageDistribution() {
        System.out.println(getFormattedName() + getFormattedPercentage());
    }

    public void printFinalDistribution() {
        System.out.println(getFormattedName() + getFormattedTotal());
    }

    public String getName() {
        return name;
    }

}