package com.epam.informationHandler.composite.compositeImpl.leaf;

import com.epam.informationHandler.composite.compositeInterface.TextComposite;
import com.epam.informationHandler.entity.InformationJoint;
import com.epam.informationHandler.exception.WrongInputException;
import com.epam.informationHandler.composite.compositeImpl.leaf.informationType.InformationType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolHandler implements TextComposite {
    private final static Logger logger = LogManager.getLogger(SymbolHandler.class);
    private InformationJoint symbol;

    @Override
    public String read() {
        String output = symbol.getData();
        return output.equals("-") ? " " + output : output;
    }

    public SymbolHandler(String input) {
        if (input == null) {
            logger.error("Null pointer accepted");
            throw new WrongInputException("Null pointer accepted");
        }
        symbol = new InformationJoint(input, InformationType.SYMBOL);
    }
}
