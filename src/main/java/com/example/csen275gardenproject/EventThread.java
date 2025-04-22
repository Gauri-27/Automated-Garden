package com.example.csen275gardenproject;
import java.util.Random;

public class EventThread extends Thread{
    private Thread t;
    private int sleepTimeInSeconds;
    private int hours;
    private int randomHour;
    private boolean dailyEventHappened = false;
    private GardenSimulationAPI garden;
    Random random = new Random();
    EventThread(GardenSimulationAPI garden, int sleepTimeInSeconds){
        this.sleepTimeInSeconds = sleepTimeInSeconds * 1000;
        this.garden = garden;
        this.hours = 0;
    }
    public void start(){
        t = new Thread(this);
        t.start();
    }
    public void run(){
        while (true){
            try{
                if (hours % 24 == 0){
                    dailyEventHappened = false;
                    randomHour = random.nextInt(24);
                }

                int day = hours/24 ;
                if(day != 0 && day % 7 == 0 && hours % 24 == 10){
                    garden.addNewPlant();
                }

                if(hours % 24 == 9){
                    garden.applyFertilizer();
                }

                if (hours % 24 == randomHour && !dailyEventHappened) {
                    triggerRandomEvent();
                    dailyEventHappened = true;
                }
                hours++;
                Thread.sleep(this.sleepTimeInSeconds);
            }
            catch (InterruptedException ie) {
                garden.logMessage(ie.getMessage());
            }
        }
    }
    private void triggerRandomEvent() {
        int event = random.nextInt(3);

        switch (event) {
            case 0:
                garden.handlePestAttack();
                break;
            case 1:
                garden.temperature(random.nextInt(33, 60));
                garden.simulateRainfall();
                dailyEventHappened = true;

                break;
            case 2:
                garden.temperature(random.nextInt(33, 120));
                dailyEventHappened = true;

                break;
            default:
                break;
        }
    }
}

