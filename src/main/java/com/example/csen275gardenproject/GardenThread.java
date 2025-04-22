package com.example.csen275gardenproject;
public class GardenThread extends Thread {
    private Thread t;
    private int sleepTimeInSeconds;

    private int hours;
    private GardenSimulationAPI gardenSimulationAPI;

    public GardenThread(GardenSimulationAPI gardenSimulationAPI, int sleepTimeInHours) {
        this.gardenSimulationAPI = gardenSimulationAPI; // Initialize the correct field
        this.sleepTimeInSeconds = (int) (sleepTimeInHours); // Convert to seconds
        this.hours = 24;
    }

    @Override
    public void start() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                gardenSimulationAPI.tick(hours);
                hours++;
                Thread.sleep(this.sleepTimeInSeconds * 1000); // Adjusted to milliseconds

            } catch (InterruptedException ie) {
                gardenSimulationAPI.logMessage(ie.getMessage());
            }
        }

    }
    public String getTimeElapsed(){return "[Day: " + hours /24 + " Hour: " + hours%24 + "]";}
}
