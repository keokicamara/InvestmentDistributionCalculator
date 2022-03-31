package com.keokicamara.moneycalculator;

import com.keokicamara.moneycalculator.calculate.CalculationCategory;
import com.keokicamara.moneycalculator.calculate.CalculationSubcategory;
import com.keokicamara.moneycalculator.settings.PercentageSettings;
import com.keokicamara.moneycalculator.settings.SettingsFile;

import java.util.Scanner;

public class CalculatorApplication {

    // TODO make config savable get to work on command config interface :)

    private static final Scanner scanner = new Scanner(System.in);
    public static double inputTotal;

    private static CalculationCategory stocks;
    private static CalculationSubcategory etf;
    private static CalculationSubcategory picks;

    private static CalculationCategory crypto;
    private static CalculationSubcategory bitcoin;
    private static CalculationSubcategory ethereum;
    private static CalculationSubcategory altcoins;

    public static void main(String[] args) {
        SettingsFile.getInstance().setupSettingsFile();
        PercentageSettings.loadPropertiesValues();

        stocks = new CalculationCategory("Stocks", PercentageSettings.STOCK_PERCENTAGE);
        etf = new CalculationSubcategory("ETF", PercentageSettings.ETF_PERCENTAGE, stocks);
        picks = new CalculationSubcategory("Picks", PercentageSettings.PICKS_PERCENTAGE, stocks);

        crypto = new CalculationCategory("Crypto", PercentageSettings.CRYPTO_PERCENTAGE);
        bitcoin = new CalculationSubcategory("BTC", PercentageSettings.BITCOIN_PERCENTAGE, crypto);
        ethereum = new CalculationSubcategory("ETH", PercentageSettings.ETHEREUM_PERCENTAGE, crypto);
        altcoins = new CalculationSubcategory("ALT", PercentageSettings.ALTCOIN_PERCENTAGE, crypto);

        printDistribution();
        promptTotal();
        takeTotalInput();
        printCalculatedDistribution();
        waitForExitCommand();

        SettingsFile.getInstance().closeFileReader();
    }

    private static void printDistribution() {
        System.out.println("""
                You are currently distributing your money as follows:
                """);
        stocks.printPercentageDistribution();
        etf.printPercentageDistribution();
        picks.printPercentageDistribution();
        crypto.printPercentageDistribution();
        bitcoin.printPercentageDistribution();
        ethereum.printPercentageDistribution();
        altcoins.printPercentageDistribution();
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
        stocks.printFinalDistribution();
        etf.printFinalDistribution();
        picks.printFinalDistribution();
        crypto.printFinalDistribution();
        bitcoin.printFinalDistribution();
        ethereum.printFinalDistribution();
        altcoins.printFinalDistribution();
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

}