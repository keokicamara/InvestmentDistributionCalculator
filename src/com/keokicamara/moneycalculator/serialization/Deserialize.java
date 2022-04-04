package com.keokicamara.moneycalculator.serialization;

import com.keokicamara.moneycalculator.calculate.CalculationCategory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;

public class Deserialize {

    private static final Deserialize instance = new Deserialize();

    private Deserialize() {
    }

    public CalculationCategory deserializedObject;

    public void deserializeCalculationCategory(String nameOfObjectInstance) {
        try {

            FileInputStream fileInputStream = new FileInputStream("/local/" + nameOfObjectInstance.toLowerCase(Locale.ROOT) + "-CATEGORY.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            deserializedObject = (CalculationCategory) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static Deserialize getInstance() {
        return instance;
    }

}