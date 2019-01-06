package com.epam.informationHandler.utility;

public class LoggerMessage {
    public static String getShortMessage(String s) {
        return (s.length() > 100) ? s.substring(0, 99) + "..." : s;
    }
}
