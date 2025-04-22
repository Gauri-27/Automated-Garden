package com.example.csen275gardenproject;


public class WaterSensor {
    public static boolean needsWater(Plant plant) {
        return plant.getCurrentWaterLevel() < plant.getMinWaterLevel();
    }
}


