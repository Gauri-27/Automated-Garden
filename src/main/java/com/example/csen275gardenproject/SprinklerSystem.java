package com.example.csen275gardenproject;

public class SprinklerSystem {

    public static double activateSprinkler(Plant plant) {
        double waterAmount = 0;
        if (plant.getCount() == 0) {
            plant.setIsWatered(false);
        } else {


            switch (plant.getName()) {
                case "Rose":
                case "Jasmine":
                case "Sunflower":
                    waterAmount = 2.0;
                    break;
                case "Tomato":
                case "Potato":
                    waterAmount = 4.0;
                    break;
                case "Carrot":
                    waterAmount = 1.0;
                    break;
                case "Apple Tree":
                case "Cherry Tree":
                case "Lemon Tree":
                    waterAmount = 18;
                    break;
                case "Cactus":
                case "Aloe Vera":
                case "Agave":
                    waterAmount = 0.5;
                    break;
                default:
                    waterAmount = 1.0;
            }

            plant.setIsWatered(true);
            plant.addWater(waterAmount);
        }
        return waterAmount;
    }

    public static void activateSprinklerToMax(Plant plant) {
        double requiredWater = plant.getMaxWaterLevel() - plant.getCurrentWaterLevel();
        plant.addWater(requiredWater);
    }
}
