package com.keokicamara.moneycalculator.settings;

import java.io.*;
import java.util.Properties;

public class SettingsFile {

    private final String name = "settings.properties";
    private static final SettingsFile instance = new SettingsFile();

    private SettingsFile() {
    }

    private final File settingsFile = new File(name);
    public Properties properties = new Properties();
    private static FileWriter fileWriter;
    public static FileReader fileReader;

    static {
        try {
            fileWriter = new FileWriter(SettingsFile.getInstance().settingsFile);
            fileReader = new FileReader(SettingsFile.getInstance().settingsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupSettingsFile() {
        createFile();
    }

    private void createFile() {
        try {
            settingsFile.createNewFile();
            setDefaultPropertiesValues();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void setDefaultPropertiesValues() {
        properties.setProperty("STOCK_PERCENTAGE", "0.7");
        properties.setProperty("CRYPTO_PERCENTAGE", "0.3");
        properties.setProperty("ETF_PERCENTAGE", "0.5");
        properties.setProperty("PICKS_PERCENTAGE", "0.5");
        properties.setProperty("BITCOIN_PERCENTAGE", "0.6");
        properties.setProperty("ETHEREUM_PERCENTAGE", "0.3");
        properties.setProperty("ALTCOIN_PERCENTAGE","0.1");
        try {
            properties.store(fileWriter, "Distribution Percentages");
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // TODO implement
    private void loadPropertiesValues() {
        try {
            properties.load(new FileInputStream(settingsFile));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static SettingsFile getInstance() {
        return instance;
    }

    public void closeFileReader() {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}