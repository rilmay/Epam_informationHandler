package com.epam.informationHandler.exception;

public class WrongInputException extends NullPointerException {
    public WrongInputException() {
        super();
    }

    public WrongInputException(String s) {
        super(s);
    }
}
