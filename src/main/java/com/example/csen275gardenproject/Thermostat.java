package com.example.csen275gardenproject;


public class Thermostat {

    public static boolean checkPlantTemperature(Plant p){
        //returns true if plant is in ideal temperature, false otherwise
        return p.getMinTemperature() <= p.getCurrentTemperature() && p.getCurrentTemperature() <= p.getMaxTemperature();
    }

    public static int handleTemperature(Plant p){
        int result = 0;
        if (p.getCount()== 0){return result;}
        if (p.getCurrentTemperature() > p.getMaxTemperature()){
            //Plant too hot, cool it down
            p.setCurrentTemperature(p.getMaxTemperature());
            result = 1;

        }
        else if (p.getCurrentTemperature() < p.getMinTemperature()){
            //Plant too cold, heat it up
            p.setCurrentTemperature(p.getMinTemperature());
            result = 2;
        }
        return result;

    }
}
