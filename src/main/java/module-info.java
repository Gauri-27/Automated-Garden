module org.example.csen275gardenproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.csen275gardenproject to javafx.fxml;
    exports com.example.csen275gardenproject;
}