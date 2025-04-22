package com.example.csen275gardenproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

public class PestHandler {
    private ArrayList<Pest> pests;
    private ArrayList<String> allPlants;
    private GardenSimulationAPI gardenSimulationAPI;
    private HashMap<String, Plant> plantsMap;

    public PestHandler(ArrayList<Pest> pests, ArrayList<String> allPlants, GardenSimulationAPI gardenSimulationAPI, HashMap<String, Plant> plantsMap) {
        this.pests = pests;
        this.allPlants = allPlants;
        this.gardenSimulationAPI = gardenSimulationAPI;
        this.plantsMap = plantsMap;
    }

    public void selectRandomPest(){
        Random random = new Random();
        Pest attackingPest = pests.get(random.nextInt(pests.size()));
        handlePestAttack(attackingPest);
    }

    public void handlePestAttack(Pest attackingPest) {
        String pestName = attackingPest.getName();
        gardenSimulationAPI.logMessage("Pest Attack by: " + pestName);

        ArrayList<String> affectedPlants = attackingPest.getTargetPlants();
        ArrayList<String> notAffectedPlants = new ArrayList<>(allPlants);
        notAffectedPlants.removeAll(affectedPlants);

        String attackLevel = generateRandomSeverityLevel();
        int affectedPlantCount, currentCount;
        double affectedPlantFactor;

        if ("Severe".equals(attackLevel)) {
            gardenSimulationAPI.logMessage("Severe pest attack!!! Pesticide spraying has started.");
            affectedPlantFactor = 0.5;
        } else {
            gardenSimulationAPI.logMessage("Biological control for pest is on.");
            affectedPlantFactor = 0.25;
        }

        if (affectedPlants.size() > 0) {
            for (String plantName : affectedPlants) {
                Plant plant = plantsMap.get(plantName);
                if (plant != null) {
                    currentCount = plant.getCount();
                    plant.setPestAttack(true);
                    if(currentCount > 0){
                        affectedPlantCount = (int) Math.round(currentCount * affectedPlantFactor);
                        if(affectedPlantCount > 0){
                            if ("Bee".equals(pestName)) {
                                plant.setCount(currentCount + affectedPlantCount);
                                gardenSimulationAPI.logMessage(affectedPlantCount + " " + plantName + " are planted due to pollination.");
                            }else {
                                plant.kill(affectedPlantCount);
                                gardenSimulationAPI.logMessage(affectedPlantCount + " " + plantName + " plant died due to pest attack.");
                            }
                        }
                    }
                }
            }
        }else {
            gardenSimulationAPI.logMessage("No plants are affected");
        }

    }


    private String generateRandomSeverityLevel() {
        Random random = new Random();
        int severityLevelIndex = random.nextInt(3);

        switch (severityLevelIndex) {
            case 0:
                return "Low";
            case 1:
                return "Moderate";
            case 2:
                return "Severe";
            default:
                return "Unknown";
        }
    }
}

