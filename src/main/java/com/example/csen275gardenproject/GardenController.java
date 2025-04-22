package com.example.csen275gardenproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class GardenController {

    private GardenSimulationAPI garden = new GardenSimulationAPI(this);

    //Rose Section
    @FXML
    private Label rosesCountLabel;
    @FXML
    private ImageView rosePestImage;
    @FXML
    private ImageView roseSprinklerImage;
    @FXML
    private ImageView roseThermostatImage;

    //Jasmine Section
    @FXML
    private Label jasminesCountLabel;
    @FXML
    private ImageView jasminePestImage;
    @FXML
    private ImageView jasmineSprinklerImage;
    @FXML
    private ImageView jasmineThermostatImage;

    //Sunflower Section
    @FXML
    private Label sunflowerCountLabel;
    @FXML
    private ImageView sunflowerPestImage;
    @FXML
    private ImageView sunflowerSprinklerImage;
    @FXML
    private ImageView sunflowerThermostatImage;

    //Tomoato Section
    @FXML
    private Label tomatoesCountLabel;
    @FXML
    private ImageView tomatoPestImage;
    @FXML
    private ImageView tomatoSprinklerImage;
    @FXML
    private ImageView tomatoThermostatImage;

    //Potato Section
    @FXML
    private Label potatoesCountLabel;
    @FXML
    private ImageView potatoPestImage;
    @FXML
    private ImageView potatoSprinklerImage;
    @FXML
    private ImageView potatoThermostatImage;

    //Carrot Section
    @FXML
    private Label carrotsCountLabel;
    @FXML
    private ImageView carrotPestImage;
    @FXML
    private ImageView carrotSprinklerImage;
    @FXML
    private ImageView carrotThermostatImage;

    //Apple Section
    @FXML
    private Label applesCountLabel;
    @FXML
    private ImageView applePestImage;
    @FXML
    private ImageView appleSprinklerImage;
    @FXML
    private ImageView appleThermostatImage;

    //Cherry Section
    @FXML
    private Label cherriesCountLabel;
    @FXML
    private ImageView cherryPestImage;
    @FXML
    private ImageView cherrySprinklerImage;
    @FXML
    private ImageView cherryThermostatImage;

    //Lemon Section
    @FXML
    private Label lemonsCountLabel;
    @FXML
    private ImageView lemonPestImage;
    @FXML
    private ImageView lemonSprinklerImage;
    @FXML
    private ImageView lemonThermostatImage;

    //Cactus Section
    @FXML
    private Label cactiCountLabel;
    @FXML
    private ImageView cactusPestImage;
    @FXML
    private ImageView cactusSprinklerImage;
    @FXML
    private ImageView cactusThermostatImage;

    //Agave Section
    @FXML
    private Label agaveCountLabel;
    @FXML
    private ImageView agavePestImage;
    @FXML
    private ImageView agaveSprinklerImage;
    @FXML
    private ImageView agaveThermostatImage;

    //Aloe Vera Section
    @FXML
    private Label aloeVeraCountLabel;
    @FXML
    private ImageView aloeVeraPestImage;
    @FXML
    private ImageView aloeVeraSprinklerImage;
    @FXML
    private ImageView aloeVeraThermostatImage;

    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private Label timeLabel;
    @FXML
    private Label temperatureLabel;
    @FXML
    private BorderPane applicationBorder;

    @FXML
    private ImageView timeImage;

    @FXML
    private Button startButton;
    @FXML
    private Button addButton;

    @FXML
    private Button stopButton;

    private Image coolerImage = new Image("file:images/thermometer-hot.png");
    private Image heaterImage = new Image("file:images/thermometer-cold.png");

    private Image nightImage = new Image("file:images/night.jpeg");
    private Image dayImage = new Image("file:images/day.jpeg");
    private Image rainImage = new Image("file:images/rain.jpeg");
    @FXML
    public void initialize(){

    }

    @FXML
    public void onStartButtonPressed(){

        startButton.setVisible(false);
        typeComboBox.setVisible(false);
        addButton.setVisible(false);

        rosePestImage.setVisible(false);
        jasminePestImage.setVisible(false);
        sunflowerPestImage.setVisible(false);
        potatoPestImage.setVisible(false);
        tomatoPestImage.setVisible(false);
        carrotPestImage.setVisible(false);
        applePestImage.setVisible(false);
        cherryPestImage.setVisible(false);
        lemonPestImage.setVisible(false);
        cactusPestImage.setVisible(false);
        aloeVeraPestImage.setVisible(false);
        agavePestImage.setVisible(false);

        garden.initializeGardenGUI();


    }

    @FXML
    public void onAddPlantButtonPressed(){
        garden.AddPlant(typeComboBox.getSelectionModel().getSelectedItem());
        updateCountLabels();
    }

    @FXML
    public void updateCountLabels(){

        rosesCountLabel.setText(String.valueOf(garden.getPlantCount("Rose")));
        jasminesCountLabel.setText(String.valueOf(garden.getPlantCount("Jasmine")));
        sunflowerCountLabel.setText(String.valueOf(garden.getPlantCount("Sunflower")));

        potatoesCountLabel.setText(String.valueOf(garden.getPlantCount("Potato")));
        tomatoesCountLabel.setText(String.valueOf(garden.getPlantCount("Tomato")));
        carrotsCountLabel.setText(String.valueOf(garden.getPlantCount("Carrot")));

        applesCountLabel.setText(String.valueOf(garden.getPlantCount("Apple Tree")));
        cherriesCountLabel.setText(String.valueOf(garden.getPlantCount("Cherry Tree")));
        lemonsCountLabel.setText(String.valueOf(garden.getPlantCount("Lemon Tree")));

        cactiCountLabel.setText(String.valueOf(garden.getPlantCount("Cactus")));
        agaveCountLabel.setText(String.valueOf(garden.getPlantCount("Agave")));
        aloeVeraCountLabel.setText(String.valueOf(garden.getPlantCount("Aloe Vera")));


    }

    public void updateActiveSystemImages(){

        //Can we change each switch case to be a function instead?
        temperatureLabel.setText("Temperature: " + garden.getTemperature() + "°F");
        switch (garden.getThermostatStatus("Rose")){
            case "Cold":
                roseThermostatImage.setVisible(true);
                roseThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                roseThermostatImage.setVisible(true);
                roseThermostatImage.setImage(heaterImage);
                break;
            default:
                roseThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Jasmine")){
            case "Cold":
                jasmineThermostatImage.setVisible(true);
                jasmineThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                jasmineThermostatImage.setVisible(true);
                jasmineThermostatImage.setImage(heaterImage);
                break;
            default:
                jasmineThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Sunflower")){
            case "Cold":
                sunflowerThermostatImage.setVisible(true);
                sunflowerThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                sunflowerThermostatImage.setVisible(true);
                sunflowerThermostatImage.setImage(heaterImage);
                break;
            default:
                sunflowerThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Potato")){
            case "Cold":
                potatoThermostatImage.setVisible(true);
                potatoThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                potatoThermostatImage.setVisible(true);
                potatoThermostatImage.setImage(heaterImage);
                break;
            default:
                potatoThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Tomato")){
            case "Cold":
                tomatoThermostatImage.setVisible(true);
                tomatoThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                tomatoThermostatImage.setVisible(true);
                tomatoThermostatImage.setImage(heaterImage);
                break;
            default:
                tomatoThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Carrot")){
            case "Cold":
                carrotThermostatImage.setVisible(true);
                carrotThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                carrotThermostatImage.setVisible(true);
                carrotThermostatImage.setImage(heaterImage);
                break;
            default:
                carrotThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Apple Tree")){
            case "Cold":
                appleThermostatImage.setVisible(true);
                appleThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                appleThermostatImage.setVisible(true);
                appleThermostatImage.setImage(heaterImage);
                break;
            default:
                appleThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Cherry Tree")){
            case "Cold":
                cherryThermostatImage.setVisible(true);
                cherryThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                cherryThermostatImage.setVisible(true);
                cherryThermostatImage.setImage(heaterImage);
                break;
            default:
                cherryThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Lemon Tree")){
            case "Cold":
                lemonThermostatImage.setVisible(true);
                lemonThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                lemonThermostatImage.setVisible(true);
                lemonThermostatImage.setImage(heaterImage);
                break;
            default:
                lemonThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Cactus")){
            case "Cold":
                cactusThermostatImage.setVisible(true);
                cactusThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                cactusThermostatImage.setVisible(true);
                cactusThermostatImage.setImage(heaterImage);
                break;
            default:
                cactusThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Aloe Vera")){
            case "Cold":
                aloeVeraThermostatImage.setVisible(true);
                aloeVeraThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                aloeVeraThermostatImage.setVisible(true);
                aloeVeraThermostatImage.setImage(heaterImage);
                break;
            default:
                aloeVeraThermostatImage.setVisible(false);
                break;
        }
        switch (garden.getThermostatStatus("Agave")){
            case "Cold":
                agaveThermostatImage.setVisible(true);
                agaveThermostatImage.setImage(coolerImage);
                break;
            case "Hot":
                agaveThermostatImage.setVisible(true);
                agaveThermostatImage.setImage(heaterImage);
                break;
            default:
                agaveThermostatImage.setVisible(false);
                break;
        }
    }

    public void updateSprinklerImages(){
        roseSprinklerImage.setVisible(garden.getPlantWatered("Rose"));
        jasmineSprinklerImage.setVisible(garden.getPlantWatered("Jasmine"));
        sunflowerSprinklerImage.setVisible(garden.getPlantWatered("Sunflower"));
        potatoSprinklerImage.setVisible(garden.getPlantWatered("Potato"));
        tomatoSprinklerImage.setVisible(garden.getPlantWatered("Tomato"));
        carrotSprinklerImage.setVisible(garden.getPlantWatered("Carrot"));
        appleSprinklerImage.setVisible(garden.getPlantWatered("Apple Tree"));
        cherrySprinklerImage.setVisible(garden.getPlantWatered("Cherry Tree"));
        lemonSprinklerImage.setVisible(garden.getPlantWatered("Lemon Tree"));
        cactusSprinklerImage.setVisible(garden.getPlantWatered("Cactus"));
        aloeVeraSprinklerImage.setVisible(garden.getPlantWatered("Aloe Vera"));
        agaveSprinklerImage.setVisible(garden.getPlantWatered("Agave"));
    }

    public void updateTime(int time) {
        timeLabel.setText(garden.getTimeString());
        if (6 <= time%24 && time%24 < 19){
            //6am - 6pm
            timeImage.setImage(dayImage);
        }
        else if (time % 24 >= 19 || time % 24 <6 ){
            //7pm - 5ams
            timeImage.setImage(nightImage);
        }
    }


    public void updateRain(){
        timeImage.setImage(rainImage);
    }

    public void updatePest(String plantName){
        switch (plantName) {
            case "Rose":
                rosePestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Jasmine":
                jasminePestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Sunflower":
                sunflowerPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Potato":
                potatoPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Tomato":
                tomatoPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Carrot":
                carrotPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Apple Tree":
                applePestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Cherry Tree":
                cherryPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Lemon Tree":
                lemonPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Cactus":
                cactusPestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Agave":
                agavePestImage.setVisible(garden.getIsPlantAttacked(plantName));
                break;
            case "Aloe Vera":
                aloeVeraPestImage.setVisible(garden.getIsPlantAttacked(plantName));

        }
    }

    @FXML
    private void onStopButtonPressed(){
        garden.getState();
        System.exit(0);
    }
}