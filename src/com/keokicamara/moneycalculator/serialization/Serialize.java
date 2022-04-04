package com.keokicamara.moneycalculator.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;

public class Serialize {

    private static final Serialize instance = new Serialize();

    private Serialize() {
    }

    public void serializeCalculationCategory(Object object, String name) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("/local/" + name.toLowerCase(Locale.ROOT) + "-CATEGORY.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(object);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Serialize getInstance() {
        return instance;
    }
}