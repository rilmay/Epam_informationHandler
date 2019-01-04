package com.epam.informationHandler.composite.compositeImpl.leaf;

import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.entity.InformationJoint;
import com.epam.informationHandler.exception.WrongInputException;
import com.epam.informationHandler.composite.compositeImpl.leaf.informationType.InformationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(WordHandler.class);
    private InformationJoint word;

    @Override
    public String read() {
        return " " + word.getData();
    }

    public WordHandler(String input) {
        if (input == null) {
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        word = new InformationJoint(input, InformationType.WORD);
    }
}
