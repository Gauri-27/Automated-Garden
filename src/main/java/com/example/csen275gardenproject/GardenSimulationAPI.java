package com.example.csen275gardenproject;

import javafx.application.Platform;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class GardenSimulationAPI {

    private static final Logger logger = LoggerConfig.getLogger();

    //Flowers
    private Plant rose = new Plant("Rose", 20, 4, 8, 65, 75, new ArrayList<>(List.of("Bee","Aphids","Mites")), 0.2, 0.05);
    private Plant jasmine = new Plant("Jasmine", 20, 4, 8, 45, 65, new ArrayList<>(List.of("Bee","Aphids","Mites")), 0.2, 0.05);
    private Plant sunflower = new Plant("Sunflower", 20, 4, 8, 70, 85, new ArrayList<>(List.of("Bee","Aphids","Mites")), 0.2, 0.05);

    //Vegetables
    private Plant potato = new Plant("Potato", 20, 6, 12, 60, 70, new ArrayList<>(List.of("Beetle","Aphids")), 0.5, 0.08);
    private Plant tomato = new Plant("Tomato", 20, 6, 12, 55, 85, new ArrayList<>(List.of("Beetle","Aphids")), 0.5, 0.08);
    private Plant carrot = new Plant("Carrot", 20, 4, 8, 40, 80, new ArrayList<>(List.of("Carrot fly","Aphids")), 0.2, 0.05);

    //Trees
    private Plant appleTree = new Plant("Apple Tree", 10, 12, 24, 41, 75, new ArrayList<>(List.of("Aphids","Apple Maggot")), 1.2, 0);
    private Plant cherryTree = new Plant("Cherry Tree", 10, 12, 24, 32, 45, new ArrayList<>(List.of("Aphids","Cherry Fruit Fly")), 1.1, 0);
    private Plant lemonTree = new Plant("Lemon Tree", 15, 12, 24, 25, 90, new ArrayList<>(List.of("Aphids", "Thrips")), 1.3, 0);

    //Succulents
    private Plant cactus = new Plant("Cactus", 10, 1, 2, 50, 100, new ArrayList<>(List.of("Mealy Bugs")), 0.01, 0.1);
    private Plant aloeVera = new Plant("Aloe Vera", 10, 1, 2, 50, 80, new ArrayList<>(List.of("Mealy Bugs", "Aphids")),0.01, 0.1);
    private Plant agave = new Plant("Agave", 10, 1, 2, 45, 80, new ArrayList<>(List.of("Mealy Bugs")), 0.01, 0.07);

    private int temperature = 75;
    private int time = 24;
    private boolean rained;

    private GardenThread gardenThread;

    private GardenController controller = null;

    public ArrayList<Plant> plants = new ArrayList<Plant>();
    private HashMap<String, Plant> plantsMap = new HashMap<>();
    public ArrayList<Pest> pests = new ArrayList<>();
    private PestHandler pestHandler;

    private final Random rand = new Random();

    public GardenSimulationAPI(){
        pests.add(new Pest("Aphids", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower", "Potato", "Tomato", "Carrot", "Apple Tree", "Cherry Tree", "Lemon Tree", "Aloe Vera"))));
        pests.add(new Pest("Mites", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower"))));
        pests.add(new Pest("Beetle", new ArrayList<>(List.of("Tomato", "Potato"))));
        pests.add(new Pest("Carrot fly", new ArrayList<>(List.of("Carrot"))));
        pests.add(new Pest("Apple Maggot", new ArrayList<>(List.of("Apple"))));
        pests.add(new Pest("Cherry Fruit Fly", new ArrayList<>(List.of("Cherry"))));
        pests.add(new Pest("Thrips", new ArrayList<>(List.of("Lemon Tree"))));
        pests.add(new Pest("Mealy Bugs", new ArrayList<>(List.of("Agave","Cactus","Aloe Vera"))));
        pests.add(new Pest("Bee", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower"))));

        //Flowers
        plantsMap.put("Rose", rose);
        plantsMap.put("Jasmine", jasmine);
        plantsMap.put("Sunflower", sunflower);

        //Vegetables
        plantsMap.put("Potato", potato);
        plantsMap.put("Tomato", tomato);
        plantsMap.put("Carrot", carrot);

        //Trees
        plantsMap.put("Apple Tree", appleTree);
        plantsMap.put("Cherry Tree", cherryTree);
        plantsMap.put("Lemon Tree", lemonTree);

        //Succulents
        plantsMap.put("Cactus", cactus);
        plantsMap.put("Agave", agave);
        plantsMap.put("Aloe Vera", aloeVera);

        ArrayList<String> allPlants = new ArrayList<String>();
        for(Plant p: plants){
            allPlants.add(p.getName());
        }

        pestHandler = new PestHandler(pests, allPlants, this, plantsMap);

        plants.add(rose);
        plants.add(jasmine);
        plants.add(sunflower);
        plants.add(potato);
        plants.add(tomato);
        plants.add(carrot);
        plants.add(appleTree);
        plants.add(cherryTree);
        plants.add(lemonTree);
        plants.add(cactus);
        plants.add(aloeVera);
        plants.add(agave);
        rained = false;
    }

    public GardenSimulationAPI(GardenController controller){
        pests.add(new Pest("Aphids", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower", "Potato", "Tomato", "Carrot", "Apple Tree", "Cherry Tree", "Lemon Tree", "Aloe Vera"))));
        pests.add(new Pest("Mites", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower"))));
        pests.add(new Pest("Beetle", new ArrayList<>(List.of("Tomato", "Potato"))));
        pests.add(new Pest("Carrot fly", new ArrayList<>(List.of("Carrot"))));
        pests.add(new Pest("Apple Maggot", new ArrayList<>(List.of("Apple"))));
        pests.add(new Pest("Cherry Fruit Fly", new ArrayList<>(List.of("Cherry"))));
        pests.add(new Pest("Thrips", new ArrayList<>(List.of("Lemon Tree"))));
        pests.add(new Pest("Mealy Bugs", new ArrayList<>(List.of("Agave","Cactus","Aloe Vera"))));
        pests.add(new Pest("Bee", new ArrayList<>(List.of("Rose", "Jasmine", "Sunflower"))));

        //Flowers
        plantsMap.put("Rose", rose);
        plantsMap.put("Jasmine", jasmine);
        plantsMap.put("Sunflower", sunflower);

        //Vegetables
        plantsMap.put("Potato", potato);
        plantsMap.put("Tomato", tomato);
        plantsMap.put("Carrot", carrot);

        //Trees
        plantsMap.put("Apple Tree", appleTree);
        plantsMap.put("Cherry Tree", cherryTree);
        plantsMap.put("Lemon Tree", lemonTree);

        //Succulents
        plantsMap.put("Cactus", cactus);
        plantsMap.put("Agave", agave);
        plantsMap.put("Aloe Vera", aloeVera);

        ArrayList<String> allPlants = new ArrayList<String>();
        for(Plant p: plants){
            allPlants.add(p.getName());
        }

        pestHandler = new PestHandler(pests, allPlants, this, plantsMap);
        plants.add(rose);
        plants.add(jasmine);
        plants.add(sunflower);
        plants.add(potato);
        plants.add(tomato);
        plants.add(carrot);
        plants.add(appleTree);
        plants.add(cherryTree);
        plants.add(lemonTree);
        plants.add(cactus);
        plants.add(aloeVera);
        plants.add(agave);
        rained = false;

        this.controller = controller;
    }

    public void initializeGardenGUI(){
        gardenThread = new GardenThread(this, 2);
        EventThread eventThread = new EventThread(this, 2);
        gardenThread.start();
        eventThread.start();
        logger.info("Garden is starting.");
    }

    public void initializeGarden(){
        //load plants from config
        try {
        File file = new File("src/main/java/com/example/csen275gardenproject/config.txt");
        Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] pair = line.split(":");
                Plant p = plantsMap.get(pair[0]);
                int count = Integer.parseInt(pair[1]);
                if (p != null && count >= 0){
                    p.setCount(count);
                }
            }
        }
        catch (FileNotFoundException fNFE){
            logger.info(fNFE.getMessage());
        }
        //start garden thread
        gardenThread = new GardenThread(this, 150);
        gardenThread.start();
        logger.info("Garden is starting.");


    }

    public void AddPlant(String selectItem) {
        Plant plant = plantsMap.get(selectItem);
        if (plant == null && rose.getCount() < rose.getMaxCount()) {
            rose.incrementCount();
            logMessage(rose.getName() + ": " + rose.getCount());
        }
        else if (plant != null && plant.getCount() < plant.getMaxCount()){
            plant.incrementCount();
            logMessage(plant.getName() + ": " + plant.getCount());
        }
    }
    public int getPlantCount(String plantName) {
        Plant plant = plantsMap.get(plantName);
        if (plant != null) {
            return plant.getCount();
        }
        return 0;
    }

    public void getState(){
        logMessage("Current state of Garden");
        logger.info("Garden's current temperature: " + temperature);
        for(Plant p: plants){
            logger.info("Name: "+p.getName());
            logger.info("Current count: " + p.getCount() + " Dead: " + p.getDiedCount());
            logger.info("Current temperature: " + p.getCurrentTemperature());
            logger.info("Water level: " +p.getCurrentWaterLevel());
        }

    }

    public void handlePestAttack() {
        logMessage("Pest attack event triggered");
        pestHandler.selectRandomPest();
    }

    public void parasite(String pestName){
        logMessage("Pest attack event triggered");
        for (Pest pest: pests){
            if (pest.getName() == pestName){
                pestHandler.handlePestAttack(pest);
            }
        }
    }

    public HashMap<String, Object> getPlants(){

        HashMap<String, Object> plantMap = new HashMap<>();

        ArrayList<String> plantlist = new ArrayList<>();
        ArrayList<Integer> waterRequirementlist = new ArrayList<>();
        ArrayList<ArrayList<String>> parasiteslist = new ArrayList<>();


        for(Plant p: plants){
            plantlist.add(p.getName());
            waterRequirementlist.add((int) p.getMaxWaterLevel());
            parasiteslist.add(p.getAttackingPests());
        }

        plantMap.put("plants",plantlist);
        plantMap.put("waterRequirement",waterRequirementlist);
        plantMap.put("parasites",parasiteslist);

        return plantMap;
    }

    public void tick(int hours){
        for(Plant p: plants){
            p.setIsWatered(false);
            if (!Thermostat.checkPlantTemperature(p)){
                //Plant temp not ideal
                int result = Thermostat.handleTemperature(p);
                switch(result){
                    case 1:
                        logMessage(p.getName() + " is above ideal temperature, cooler activated");
                        break;
                    case 2:
                        logMessage(p.getName() + " is below ideal temperature, heater activated");
                        break;
                }

            }
        }

        if (hours % 24 == 23){
            for (Plant p: plants){
                if (!Thermostat.checkPlantTemperature(p) && p.getCount() > 0){
                    //End of day and plant is NOT in ideal temp, kill some
                    //random amount died
                    int plantsDied = rand.nextInt(0, p.getCount()/2);
                    p.kill(plantsDied);
                    logMessage(p.getName() + " area temperature is not ideal "  + plantsDied + " died");
                }
            }
        }


        checkWaterLevels(); // Use the correct field
        decreaseWaterLevels();
        if (hours % 24 == 0 && hours != 24) { // Check if 24 hours have passed
            logger.info("Day " + (hours/24 - 1) + " completed.");
            printWaterLevels(); // Print water levels at the end of the day
        }
        time = hours;
        if (controller != null){
            Platform.runLater( () -> updateGUI());
        }
    }

    public void addNewPlant(){
        logMessage("Gardener has planted new plants");
        for (Plant p: plants){
            int currentCount = p.getCount();
            int maxCount = p.getMaxCount();
            if (currentCount == 0 || ((double) currentCount / maxCount) < 0.5) {
                int newPlantCount = (int) (p.getMaxCount() * 0.25);
                p.setCount(p.getCount() + newPlantCount);
                logMessage("Planted " + newPlantCount + " new " + p.getName());
            }
        }
    }


    private void updateGUI(){
        controller.updateCountLabels();
        controller.updateActiveSystemImages();
        controller.updateSprinklerImages();
        controller.updateTime(time);
        if (rained){
            controller.updateRain();
            rained = false;
        }
        for (Plant p: plants) {
            controller.updatePest(p.getName());
            if (p.getPestAttack()) {
                p.setPestAttack(false);
            }
        }
    }
    public void rain(int amount){
        logMessage("Rain event triggered");

        if (amount >= 100){
            logMessage("Flooding occured due to heavy rain");
        }
        for (Plant p: plants){
            if (amount >= 100){
                int affectedPlantCnt = (int)Math.round(p.getCount() * p.getFloodMultiplier());
                p.kill(affectedPlantCnt);
                logMessage(affectedPlantCnt + " " + p.getName() + " died due to heavy rain");
            }
            p.addWater(amount);
        }
    }

    public void temperature(int temperature){
        logMessage("Temperature event triggered, temperature changed to " + temperature + " degrees fahrenheit");
        this.temperature = temperature;
        for (Plant p: plants){
            p.setCurrentTemperature(temperature);
        }
    }

    public void checkWaterLevels() {

        for (Plant p : plants){
            if (WaterSensor.needsWater(p)){
                double amount = SprinklerSystem.activateSprinkler(p);
                if (amount > 0){
                    logMessage("Activating sprinkler for " + p.getName() + ", added " + amount + " inches of water.");
                }
            }
            else{
                p.setIsWatered(false);
            }
        }
    }

    public void decreaseWaterLevels() {
        for (Plant p : plants) {
            p.decreaseWaterLevel((getWaterDecreaseAmount(p)));
        }
    }
    // New method to calculate water decrease amount based on temperature
    private double getWaterDecreaseAmount(Plant plant) {
        double baseDecreaseAmount = 1; // Base decrease amount
        if (temperature > 80) {
            baseDecreaseAmount *= 2; // Double the decrease rate if temperature is above 80°F
        }
        if(temperature < 45) {
            baseDecreaseAmount *= .5; // Double the decrease rate if temperature is below 35F
        }
        return baseDecreaseAmount * plant.getConsumptionRate();
    }
    public void printWaterLevels() {
        for (Plant p: plants){
            logger.info(p.getName() + " water level: " + p.getCurrentWaterLevel());
        }
    }

    public void simulateRainfall() {
        String rainSeverity = "";
        int rainfallAmount = 0;
        // Generate random rainfall amount
        switch (rand.nextInt(3)){
            case 0:
                rainSeverity = "Low";
                rainfallAmount = rand.nextInt(0,30);
                break;
            case 1:
                rainSeverity = "Moderate";
                rainfallAmount = rand.nextInt(30,80);
                break;
            case 2:
                rainSeverity = "Severe";
                rainfallAmount = rand
                        .nextInt(80,100);
                break;
            default:
                rainSeverity = "Unknown";
        }
        // Increase water levels of all plants by the rainfall amount
        logMessage(rainSeverity + " rain happened");
        rain(rainfallAmount);
        rained = true;
    }

    public void applyFertilizer(){
        logMessage("Garden fertilization has started");
        for(Plant p : plants){
            p.addFertilizer();
        }
    }

    public int getTemperature(){return this.temperature;}
    public String getTimeString(){
        return "Day: " + time/24 + " Hour: " + time%24;
    }

    public boolean getIsPlantAttacked(String plantName){
        return plantsMap.get(plantName).getPestAttack();
    }

    public String getThermostatStatus(String plantName){
        Plant p = plantsMap.get(plantName);
        if (p.getCount() == 0){
            return "Normal";
        }
        if (p!=null){
            if (temperature < p.getMinTemperature()){
                return "Cold";
            }
            else if (temperature > p.getMaxTemperature()){
                return "Hot";
            }
            else{
                return "Normal";
            }
        }
        return "Normal";
    }

    public boolean getPlantWatered(String plantName){
        Plant plant = plantsMap.get(plantName);
        if (plant != null){
            return plant.getIsWatered();
        }
        return false;
    }

 
    public void logMessage(String message){
        logger.info("[" + getTimeString() + "] " + message);
    }


}
