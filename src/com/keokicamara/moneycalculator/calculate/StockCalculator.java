package com.keokicamara.moneycalculator.calculate;

import com.keokicamara.moneycalculator.CalculatorApplication;
import com.keokicamara.moneycalculator.settings.PercentageSettings;

public class StockCalculator {

    private static double stocksTotal;

    public static double calculateStockTotal() {
        stocksTotal = CalculatorApplication.inputTotal * PercentageSettings.STOCK_PERCENTAGE;
        return stocksTotal;
    }

    public static double calculateEtfTotal() {
        return stocksTotal * PercentageSettings.ETF_PERCENTAGE;
    }

    public static double calculatePicksTotal() {
        return stocksTotal * PercentageSettings.PICKS_PERCENTAGE;
    }

}