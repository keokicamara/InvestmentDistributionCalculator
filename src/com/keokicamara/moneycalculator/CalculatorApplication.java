package com.keokicamara.moneycalculator;

import com.keokicamara.moneycalculator.calculate.CalculationCategory;
import com.keokicamara.moneycalculator.commands.CreateCategoryCommand;
import com.keokicamara.moneycalculator.settings.SettingsHandler;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class CalculatorApplication {

    // TODO work on app flow, implement subcategory creation, CLEAN THIS SHIT UP BRO

    private static final SettingsHandler settingsHandler = new SettingsHandler();
    public static final File localStorage = new File("/local/");

    public static final Scanner scanner = new Scanner(System.in);
    public static double inputTotal;

    public static void main(String[] args) {
        /*
        printDistribution();
        promptTotal();
        takeTotalInput();
        printCalculatedDistribution();
        waitForExitCommand();

        SettingsFile.getInstance().closeFileReader();
        */


        promptLoadSettings();
        printDistribution();

    }

    private static void printDistribution() {
        System.out.println("""
                You are currently distributing your money as follows:
                """);
        for (CalculationCategory calculationCategory : settingsHandler.deserializedObjects) {
            calculationCategory.printPercentageDistribution();
        }
        System.out.println(" ");
    }

    private static void promptTotal() {
        System.out.println("How much money do you have to distribute?");
    }

    private static void takeTotalInput() {
        while (true) {
            try {
                inputTotal = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException ignoredException) {
                System.out.println("Please input a valid double.");
            }
        }
    }

    private static void printCalculatedDistribution() {
        System.out.println("""
                
                ---------------------------------------------------------------------------
                According to the current configuration, you should distribute
                your money as follows:
                
                """);

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" ");
    }

    private static void waitForExitCommand() {
        System.out.println("Type anything when you're done!");
        while (true) {
            if (scanner.nextLine() != null) {
                break;
            }
        }
    }

    private static void promptLoadSettings() {
        System.out.println("Do you have a configuration you want to load? <y/n>");
        String scannerInput = scanner.nextLine();
        if (Objects.equals(scannerInput, "y")) {
            settingsHandler.setupSettings(localStorage);
        } else if (Objects.equals(scannerInput, "n")) {
            settingsHandler.cleanSettingsDirectory();
            promptCreateSettings();
        } else {
            repromptLoadSettings();
        }
    }

    private static void repromptLoadSettings() {
        System.out.println("Not valid input! Please type 'y' for yes or 'n' for no.");
        promptLoadSettings();
    }

    private static void promptCreateSettings() {
        System.out.println("Hmmm.... we didn't find any settings to load. Type 'create' to get started!");
        CreateCategoryCommand createCategoryCommand = new CreateCategoryCommand("create");
        createCategoryCommand.run();
    }

    private static void repromptCreateSettings() {
        System.out.println("Not valid input! Please type 'create'.");
        promptCreateSettings();
    }

}