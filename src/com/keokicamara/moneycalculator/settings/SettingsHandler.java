package com.keokicamara.moneycalculator.settings;

import com.keokicamara.moneycalculator.CalculatorApplication;
import com.keokicamara.moneycalculator.calculate.CalculationCategory;
import com.keokicamara.moneycalculator.serialization.Deserialize;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SettingsHandler {

    private List<String> deserializedCategoryName = new ArrayList<>();
    public List<CalculationCategory> deserializedObjects = new ArrayList<>();

    public void setupSettings(final File folder) {
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                setupSettings(fileEntry);
            } else if (fileEntry.getName().contains("-CATEGORY.ser") && !deserializedCategoryName.contains(fileEntry.getName())) {
                deserializedCategoryName.add(fileEntry.getName());
            }
        }
        createCategoryObjects();
        System.out.println("DEBUG: " + deserializedCategoryName);
    }

    private void createCategoryObjects() {
        String calculationCategoryName;
        for (String fileName : deserializedCategoryName) {
            calculationCategoryName = fileName.replace("-CATEGORY.ser", "");
            Deserialize.getInstance().deserializeCalculationCategory(calculationCategoryName);
            CalculationCategory placeholderCategory = new CalculationCategory(calculationCategoryName, Deserialize.getInstance().deserializedObject.getPercentageString());
            if (!deserializedObjects.contains(placeholderCategory)) {
                deserializedObjects.add(new CalculationCategory(calculationCategoryName, Deserialize.getInstance().deserializedObject.getPercentageString()));
            }
        }
        System.out.println(deserializedObjects);
    }

    public void cleanSettingsDirectory() {
        for (File file : Objects.requireNonNull(CalculatorApplication.localStorage.listFiles())) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    public boolean isLoadable() {
        return CalculatorApplication.localStorage.listFiles() != null && CalculatorApplication.localStorage.isDirectory();
    }

}