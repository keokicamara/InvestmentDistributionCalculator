package com.keokicamara.moneycalculator.commands;

import com.keokicamara.moneycalculator.CalculatorApplication;
import com.keokicamara.moneycalculator.calculate.CalculationCategory;
import com.keokicamara.moneycalculator.serialization.Serialize;

import java.util.Locale;
import java.util.Objects;

public class CreateCategoryCommand {

    private String name;
    private boolean canContinue = false;

    public CreateCategoryCommand(String name) {
        this.name = name;
    }

    public void run() {
        if (canContinue) {
            setupCategoryPrompt();
            promptFinished();
        } else if (Objects.equals(CalculatorApplication.scanner.nextLine(), name)) {
            setupCategoryPrompt();
            promptFinished();
        } else {
            System.exit(0);
        }
    }

    private void setupCategoryPrompt() {
        String categoryName, categoryPercentage;
        System.out.println("Please name the category");
        categoryName = CalculatorApplication.scanner.nextLine();
        System.out.println("What percentage would you like to allocate to this category? (ex: 0.15 = 15%)");
        categoryPercentage = CalculatorApplication.scanner.nextLine();
        CalculationCategory calculationCategory = new CalculationCategory(categoryName, categoryPercentage);
        Serialize.getInstance().serializeCalculationCategory(calculationCategory, calculationCategory.getName());
        System.out.println("You have successfully created " + calculationCategory.getName().toLowerCase(Locale.ROOT) +
                " and are allocating " + calculationCategory.getFormattedPercentage() + ".");
    }

    private void promptFinished() {
        System.out.println("Type 'create' to make another category, otherwise type anything else.");
        if (Objects.equals(CalculatorApplication.scanner.nextLine(), "create")) {
            canContinue = true;
            run();
        } else {
            canContinue = false;
        }
    }

}