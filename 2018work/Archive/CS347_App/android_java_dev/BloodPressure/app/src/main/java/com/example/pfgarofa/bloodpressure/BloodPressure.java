package com.example.pfgarofa.bloodpressure;

/**
 * Created by pfgarofa on 2/5/2018.
 *
 * Source: http://www.merckmanuals.com/home/heart-and-blood-vessel-disorders/high-blood-pressure/high-blood-pressure#v718040
 */

public class BloodPressure {

    public static final String mCategories[] = {
            "Low reading; reevaluate",
            "Optimal blood pressure",
            "Normal blood pressure",
            "Prehypertension",
            "Stage 1 hypertension",
            "Stage 2 hypertension"
    };

    public static final String mRecommendations[] = {
            "Take blood pressure reading again.",
            "Blood pressure is rechecked in 2 years.",
            "Blood pressure is rechecked in 2 years.",
            "Blood pressure is rechecked in 1 year, and advice about lifestyle changes is provided.",
            "The high blood pressure is confirmed within 2 months, and advice about lifestyle changes is provided.",
            "The person is evaluated or referred to a health care provider within 1 month. For people with very high pressures (such as 180/110 mm Hg or higher), evaluation or treatment is immediate or within 1 week, depending on the person's condition."
    };

    public static int bp(int systolic, int diastolic) {

        if (systolic < 100 || diastolic < 60)
            return 0;   // "Low reading; reevaluate";
        else if (systolic < 115 && diastolic < 75)
            return 1;   // "Optimal blood pressure";
        else if (systolic < 120 && diastolic < 80)
            return 2;   // "Normal blood pressure";
        else if (systolic < 140 && diastolic < 90)
            return 3;   // "Prehypertension";
        else if (systolic < 160 && diastolic < 100)
            return 4;   // "Stage 1 hypertension";
        else
            return 5;   // "Stage 2 hypertension":

    }


}
