package com.keokicamara.moneycalculator.settings;

import com.keokicamara.moneycalculator.CalculatorApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PercentageSettings {

    public static String STOCK_PERCENTAGE;
    public static String CRYPTO_PERCENTAGE;

    public static String ETF_PERCENTAGE;
    public static String PICKS_PERCENTAGE;

    public static String BITCOIN_PERCENTAGE;
    public static String ETHEREUM_PERCENTAGE;
    public static String ALTCOIN_PERCENTAGE;

    public static void loadPropertiesValues() {
        try {
            SettingsFile.getInstance().properties.load(SettingsFile.fileReader);

            STOCK_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("STOCK_PERCENTAGE");
            CRYPTO_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("CRYPTO_PERCENTAGE");

            ETF_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("ETF_PERCENTAGE");
            PICKS_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("PICKS_PERCENTAGE");

            BITCOIN_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("BITCOIN_PERCENTAGE");
            ETHEREUM_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("ETHEREUM_PERCENTAGE");
            ALTCOIN_PERCENTAGE = SettingsFile.getInstance().properties.getProperty("ALTCOIN_PERCENTAGE");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}