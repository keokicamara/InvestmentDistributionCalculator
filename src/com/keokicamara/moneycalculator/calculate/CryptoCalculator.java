package com.keokicamara.moneycalculator.calculate;

import com.keokicamara.moneycalculator.CalculatorApplication;
import com.keokicamara.moneycalculator.settings.PercentageSettings;

public class CryptoCalculator {

    private static double cryptoTotal;

    public static double calculateCryptoTotal() {
        cryptoTotal = CalculatorApplication.inputTotal * PercentageSettings.CRYPTO_PERCENTAGE;
        return cryptoTotal;
    }

    public static double calculateBitcoinTotal() {
        return cryptoTotal * PercentageSettings.BITCOIN_PERCENTAGE;
    }

    public static double calculateEthereumTotal() {
        return cryptoTotal * PercentageSettings.ETHEREUM_PERCENTAGE;
    }

    public static double calculateAltcoinTotal() {
        return cryptoTotal * PercentageSettings.ALTCOIN_PERCENTAGE;
    }

}