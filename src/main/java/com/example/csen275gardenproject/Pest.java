package com.example.csen275gardenproject;
import java.util.ArrayList;

public class Pest {
    private String name;

    private ArrayList<String> targetPlants;

    public Pest(String name, ArrayList<String> targetPlants) {
        this.name = name;
        this.targetPlants = targetPlants;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTargetPlants() {
        return targetPlants;
    }


}
