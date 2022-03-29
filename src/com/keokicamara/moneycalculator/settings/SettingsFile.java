package com.keokicamara.moneycalculator.settings;

import java.io.*;
import java.util.Properties;

public class SettingsFile {

    private static File settingsFile = new File("settings.properties");
    public static Properties properties = new Properties();
    private static FileWriter fileWriter;
    private static FileReader fileReader;

    static {
        try {
            fileWriter = new FileWriter(settingsFile);
            fileReader = new FileReader(settingsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setupSettingsFile() {
        // if (settingsFile.exists()) { //this doesn't work properly
        loadPropertiesValues();
        System.out.println("called props");
        //} else {
            //createFile();
       // }
    }

    private static void createFile() {
        try {
            settingsFile.createNewFile();
            setDefaultPropertiesValues();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void setDefaultPropertiesValues() {
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

    private static void loadPropertiesValues() {
        try {
            properties.load(fileReader);
            fileReader.close();
            System.out.println("filereader called");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}