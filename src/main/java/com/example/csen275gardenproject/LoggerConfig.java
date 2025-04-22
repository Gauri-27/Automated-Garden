package com.example.csen275gardenproject;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LoggerConfig {
    private static Logger logger = Logger.getLogger("GardenLogger");

    static {
        try {
            FileHandler fileHandler = new FileHandler("garden.log", false);
            fileHandler.setFormatter(new SimpleLogFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Disable console logging
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
