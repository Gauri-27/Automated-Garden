package com.example.csen275gardenproject;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class SimpleLogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Extract the relevant part of the log message
        String message = record.getMessage();
        int infoIndex = message.indexOf("INFO:");
        if (infoIndex != -1) {
            return message.substring(infoIndex) + System.lineSeparator();
        }
        return message + System.lineSeparator();
    }
}
