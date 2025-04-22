package com.example.csen275gardenproject;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Plant {


    private String name;
    private int count;
    private int maxCount;

    private int diedCount;

    private double minWaterLevel;
    private double maxWaterLevel;

    private double currentWaterLevel;
    private int minTemperature;
    private int maxTemperature;
    private  ArrayList<String> attackingPests;
    private boolean pestAttack;
    private int currentTemperature;
    private int fertilizerLevel;
    private boolean isWatered;

    private double consumptionRate;
    private double floodMultiplier;
    public Plant(String name, int maxCount, double minWaterLevel, double maxWaterLevel,
                 int minTemperature, int maxTemperature, ArrayList<String> attackingPests, double consumptionRate, double floodMultiplier){
        this.name = name;
        this.count = 0;
        this.maxCount = maxCount;
        this.minWaterLevel = minWaterLevel;
        this.maxWaterLevel = maxWaterLevel;
        this.currentWaterLevel = maxWaterLevel;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.attackingPests = attackingPests;
        this.currentTemperature = 75;
        this.pestAttack = false;
        this.isWatered = false;
        this.fertilizerLevel = 0;
        this.consumptionRate = consumptionRate;
        this.floodMultiplier = floodMultiplier;
        this.diedCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count){this.count = count;}

    public int getMaxCount() {
        return maxCount;
    }

    public double getMinWaterLevel() {
        return minWaterLevel;
    }

    public double getMaxWaterLevel() {
        return maxWaterLevel;
    }

    public ArrayList<String> getAttackingPests() {
        return attackingPests;
    }

    public void setPestAttack(boolean pestAttack) {
        this.pestAttack = pestAttack;
    }

    public boolean getPestAttack(){return pestAttack;}

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public void addWater(double water){
        this.currentWaterLevel += water;
        this.currentWaterLevel = Math.clamp(this.currentWaterLevel, minWaterLevel, maxWaterLevel);
    }

    public void addFertilizer(){
        this.fertilizerLevel += 1;
    }

    public void updateDiedCnt(int num) {
        this.diedCount += num;
    }

    public int getDiedCount() {
        return diedCount;
    }
    public void incrementCount(){ this.count++; }

    public int getCurrentTemperature(){return this.currentTemperature;}

    public void setCurrentTemperature(int temperature){this.currentTemperature = temperature;}

    public void kill(int num){
        count -= num;
        updateDiedCnt(num);
    }

    public void decreaseWaterLevel(double amount) {
        this.currentWaterLevel -= amount;
        if (this.currentWaterLevel < 0) {
            this.currentWaterLevel = 0;
        }
    }

    public void setIsWatered(boolean newState){this.isWatered = newState;}

    public boolean getIsWatered(){return this.isWatered;}

    public double getConsumptionRate(){return this.consumptionRate;}

    public double getFloodMultiplier(){return this.floodMultiplier;}
}
