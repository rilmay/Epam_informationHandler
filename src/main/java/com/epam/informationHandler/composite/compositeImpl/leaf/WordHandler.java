package com.epam.informationHandler.composite.compositeImpl.leaf;

import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.exception.WrongInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(WordHandler.class);
    private String word;

    @Override
    public String read() {
        return " "+word;
    }

    public WordHandler(String word) {
        if (word == null) {
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        this.word = word;
    }
}
