package com.keokicamara.moneycalculator;

import com.keokicamara.moneycalculator.calculate.CryptoCalculator;
import com.keokicamara.moneycalculator.calculate.StockCalculator;
import com.keokicamara.moneycalculator.settings.PercentageSettings;
import com.keokicamara.moneycalculator.settings.SettingsFile;

import java.util.Objects;
import java.util.Scanner;

public class CalculatorApplication {

    /* TODO
       figure out why file exists errors

       also fix file in general

       format doubles output to $##.##
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static double inputTotal;

    public static void main(String[] args) {
        //SettingsFile.setupSettingsFile();
        printDistribution();
        promptTotal();
        takeTotalInput();
        printCalculatedDistribution();
        waitForExitCommand();
    }

    private static void printDistribution() {
        System.out.println("""
                You are currently distributing your money as follows:
                """);
        System.out.println("Stocks: " + PercentageSettings.STOCK_PERCENTAGE * 100 + "%");
        System.out.println("    ETF: " + PercentageSettings.ETF_PERCENTAGE * 100 + "%");
        System.out.println("    Picks: " + PercentageSettings.PICKS_PERCENTAGE * 100 + "%");
        System.out.println("Crypto: " + PercentageSettings.CRYPTO_PERCENTAGE * 100 + "%");
        System.out.println("    BTC: " + PercentageSettings.BITCOIN_PERCENTAGE * 100 + "%");
        System.out.println("    ETH: " + PercentageSettings.ETHEREUM_PERCENTAGE * 100 + "%");
        System.out.println("    ALT: " + PercentageSettings.ALTCOIN_PERCENTAGE * 100 + "%");
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
        System.out.println("Stocks: $" + StockCalculator.calculateStockTotal());
        System.out.println("    ETF: $" + StockCalculator.calculateEtfTotal());
        System.out.println("    Picks: $" + StockCalculator.calculatePicksTotal());
        System.out.println("Crypto: $" + CryptoCalculator.calculateCryptoTotal());
        System.out.println("    BTC: $" + CryptoCalculator.calculateBitcoinTotal());
        System.out.println("    ETH: $" + CryptoCalculator.calculateEthereumTotal());
        System.out.println("    ALT: $" + CryptoCalculator.calculateAltcoinTotal());
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